package com.n22.infinitude.ums.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.n22.infinitude.ums.ahelper.AccountHelper;
import com.n22.infinitude.ums.constants.AppConstants;

@RestController 
@RequestMapping("uwindsor")
public class AccountController {
	
	@Autowired
	AccountHelper accountHelper;
	
	@GetMapping("check")
	public HttpStatus checkConnection() {
		
		return HttpStatus.ACCEPTED;
	}
	
	@PostMapping("login")
	public HttpStatus userLogin(@RequestBody JsonObject body) {
		
		return HttpStatus.ACCEPTED;
	}
	
	/*Sample request body
   *{
    "firstName": "Nishanthan",
    "middleName": "NA",
    "lastName": "Modachur Ravichandran",
    "dob": "2002-06-22",
    "country": "INDIA",
    "phoneNumber": "2269611701",
    "program": "MAC",
    "degree": "Graduate"
	 }*/
	@PostMapping("register/student")
	public String registerStudent(@RequestParam(name = "params", required = false) HashMap<String, String> params,
			@RequestHeader(required = false) HashMap<String, String> headers, @RequestBody HashMap<String, String> body) {

		HashMap<String, String> emailContents = new HashMap<>();
		if (!body.get(AppConstants.MIDDLE_NAME).isBlank()
				&& !body.get(AppConstants.MIDDLE_NAME).equalsIgnoreCase(AppConstants.NA)) {
			emailContents.put(AppConstants.EMAIL_ADDRESS, body.get(AppConstants.MIDDLE_NAME));
		} else if (!body.get(AppConstants.LAST_NAME).isBlank()) {
			emailContents.put(AppConstants.EMAIL_ADDRESS, body.get(AppConstants.LAST_NAME));
		}

		emailContents.put(AppConstants.DOB, body.get(AppConstants.DOB));

		String test = accountHelper.generateEmailAddress(emailContents);

		return test;
	}
	

}
