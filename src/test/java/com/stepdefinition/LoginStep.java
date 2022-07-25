package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.CommonVariables;
import com.pojo.Login_Output_pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

/**
 * @author Dell
 * @Description To maintain loginpage
 * @Creation Date 29/06/2022
 */
public class LoginStep extends BaseClass {

	public static CommonVariables commonVariables = new CommonVariables();

	Response response;
	String logtoken;

	/**
	 * @Description add Header
	 * @Creation Date 29/06/2022
	 */
	@Given("User should add header")
	public void userShouldAddHeader() {

		addHeader("Content-Type", "application/json");

	}

	/**
	 * @Description add basic authentication for login
	 * @Creation Date 29/06/2022
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Given("User should add basic authentication for login")
	public void userShouldAddBasicAuthenticationForLogin() throws FileNotFoundException, IOException {

		basicAuth(getPropertyFileValue("userName"), getPropertyFileValue("Password"));

	}

	/**
	 * @Description Send request for login endpoint
	 * @Creation Date 29/06/2022
	 * @param string
	 */
	@When("User should send {string} request for login endpoint")
	public void userShouldSendRequestForLoginEndpoint(String string) {
		response = requestType("POST", Endpoints.LOGIN);
		int statuscode = getStatusCode(response);
		commonVariables.setStatusCode(statuscode);
	}

	/**
	 * @Description verify the login response body firstName
	 * @Creation Date 29/06/2022
	 * @param string
	 */
	@Then("User should verify the login response body firstName present as {string} and get the logtoken saved")
	public void userShouldVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtokenSaved(String string) {

		Login_Output_pojo login_Output_pojo = response.as(Login_Output_pojo.class);
		String first_name = login_Output_pojo.getData().getFirst_name();
		System.out.println(first_name);

		Assert.assertEquals(first_name, "Vini", "verify firstname");

		logtoken = login_Output_pojo.getData().getLogtoken();
		commonVariables.setLogToken(logtoken);
		System.out.println(logtoken);
	}

}
