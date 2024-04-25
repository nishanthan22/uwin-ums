package com.n22.infinitude.ums.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

@RestController 
@RequestMapping("uwindsor")
public class AccountController {
	
	@GetMapping("check")
	public HttpStatus checkConnection() {
		
		return HttpStatus.ACCEPTED;
	}
	
	@PostMapping("login")
	public HttpStatus userLogin(@RequestBody JsonObject body) {
		
		return HttpStatus.ACCEPTED;
	}
	

}
