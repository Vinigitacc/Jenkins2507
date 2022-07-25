package com.stepdefinition;

import org.junit.Assert;

import cucumber.api.java.en.Then;

public class CommonStep {

	@Then("User should verify the statuscode is {int}")
	public void userShouldVerifyTheStatuscodeIs(int expValue) {



		Assert.assertEquals("verify statuscode", expValue, LoginStep.commonVariables.getStatusCode());

	}

}
