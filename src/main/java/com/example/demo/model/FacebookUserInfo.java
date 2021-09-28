package com.example.demo.model;

import java.util.Map;

public class FacebookUserInfo extends UserInfo {

	public FacebookUserInfo(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getLogin() {
		return (String) attributes.get("email");
	}
}