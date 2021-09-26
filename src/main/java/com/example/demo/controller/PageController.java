package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/login/oauth2")
	public String loginPage() {
		return "loginPage";
	}

	@GetMapping("/secured")
	public String securedPage() {
		return "securedPage";
	}
}