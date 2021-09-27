package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.demo.service.CustomOauth2UserService;
import com.example.demo.service.CustomOidcUserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomOauth2UserService userService;
	@Autowired
	private CustomOidcUserService oidcUserService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/index").permitAll().antMatchers("/secured/**")
				.authenticated().and().oauth2Login().loginPage("/login/oauth2").defaultSuccessUrl("/secured")
				.userInfoEndpoint().userService(userService).oidcUserService(oidcUserService);
	}
}