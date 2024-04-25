package com.n22.infinitude.ums.helper;

import java.util.HashMap;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.n22.infinitude.ums.constants.AppConstants;
@Component
public class AccountHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountHelper.class);
	
	public String generateEmailAddress(HashMap<String, String> emailContents) {

		LOGGER.info("generateEmailAddress() Method, PARAMETERS: {}", emailContents);

		String name = emailContents.get(AppConstants.MAILBOX_NAME);
		String dob = emailContents.get(AppConstants.DOB);

		name = name.trim().substring(0, 4).toLowerCase();
		dob = dob.trim().substring(8);

		// Create a Random object
		Random random = new Random();
		int intSuffix = random.nextInt(9);

		String emailAddress = name + dob + intSuffix + AppConstants.EMAIL_DOMAIN;

		LOGGER.info("generateEmailAddress() Method, RETURN: {}", emailAddress);

		return emailAddress;
	}

}
