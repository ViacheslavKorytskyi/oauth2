package com.example.demo.model;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class UserInfoFactory {

	public UserInfo create(String provider, Map<String, Object> attributes) {
		UserInfo userInfo = null;
		if (provider.equalsIgnoreCase("github")) {
			userInfo = new GitHubUserInfo(attributes);
		}
		if (provider.equalsIgnoreCase("google")) {
			userInfo = new GoogleUserInfo(attributes);
		}
		return userInfo;
	}
}