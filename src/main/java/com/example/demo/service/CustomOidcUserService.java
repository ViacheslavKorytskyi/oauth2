package com.example.demo.service;

import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import com.example.demo.model.GoogleUserInfo;
import com.example.demo.model.User;
import com.example.demo.model.UserInfo;
import com.example.demo.model.UserInfoFactory;
import com.example.demo.repository.UserRepository;

@Service
public class CustomOidcUserService extends OidcUserService {

	private UserRepository userRepository;

	private UserInfoFactory userInfoFactory;

	public CustomOidcUserService(UserRepository userRepository, UserInfoFactory userInfoFactory) {
		super();
		this.userRepository = userRepository;
		this.userInfoFactory = userInfoFactory;
	}

	@Override
	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
		OidcUser oidcUser = super.loadUser(userRequest);
		String provider = userRequest.getClientRegistration().getRegistrationId();
		UserInfo userInfo = userInfoFactory.create(provider, oidcUser.getAttributes());
		boolean exists = userRepository.existsByLoginAndProvider(userInfo.getLogin(), provider);
		if (!exists) {
			User user = new User();
			user.setLogin(userInfo.getLogin());
			user.setProvider(provider);
			userRepository.save(user);
		}
		return oidcUser;
	}
}