package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.ChangeProfilePic_Output_pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
/**
 * @Description To maintain change the profile pic
 * @CreationDate 29/06/2022
 * @author Dell
 *
 */
public class ChangeProfilePicStep extends BaseClass {
	Response response;
/**
 * @Descriptiondd headers and beared authorization
 * @CreationDate 29/06/2022
 */
	@Given("User should add headers and beared authorization and multipart\\/form-data for accessing changeprofilepic endpoint")
	public void userShouldAddHeadersAndBearedAuthorizationAndMultipartFormDataForAccessingChangeprofilepicEndpoint() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "multipart/form-data");
		Header h2 = new Header("Authorization", "Bearer " + LoginStep.commonVariables.getLogToken());
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);
		multipart();
	}
/**
 * @Description send request address for ChangeProfilePic
 * @CreationDate 29/06/2022
 * @param string
 */
	@When("User send {string} request address for ChangeProfilePic")
	public void userSendRequestAddressForChangeProfilePic(String string) {
		response = requestType("POST", Endpoints.CHANGEPROFILEPIC);

	}
/**
 * @Description verify the changeprofilepic response message
 * @CreationDate 29/06/2022
 * @param string
 */
	@Then("User verify the changeprofilepic response message matches with {string}")
	public void userVerifyTheChangeprofilepicResponseMessageMatchesWith(String string) {
		 
		
	}

}
