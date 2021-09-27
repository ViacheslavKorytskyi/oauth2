package com.example.demo.model;

import java.util.Map;

public abstract class UserInfo {
	protected Map<String, Object> attributes;

	public UserInfo(Map<String, Object> attributes) {
		super();
		this.attributes = attributes;
	}

	public abstract String getLogin();
}