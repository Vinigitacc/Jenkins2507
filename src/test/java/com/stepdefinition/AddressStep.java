package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payload.Payload;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.AddAddress_Output_pojo;
import com.pojo.DeleteAddress_Input_pojo;
import com.pojo.DeleteAddress_Output_pojo;
import com.pojo.GetAddress_Output_pojo;
import com.pojo.UpdateAddress_Input_pojo;
import com.pojo.UpdateAddress_Output_pojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * 
 * @author Dell
 * @Description To maintain Create,update,get and delete address
 * @CreationDate 29/06/2022
 */
public class AddressStep extends BaseClass {
	String logtoken;
	static String address_id;
	Response response;

	/**
	 * @Description headers and bearer authorization
	 * @CreationDate 29/06/2022
	 */
	@Given("User add headers and bearer authorization for accessing address endpoints")
	public void userAddHeadersAndBearerAuthorizationForAccessingAddressEndpoints() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + LoginStep.commonVariables.getLogToken());
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);
	}

	/**
	 * @Description add request body for Add new address
	 * @CreationDate 29/06/2022
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 */
	@When("user add request body for Add new address {string},{string},{string},{string},{string},{string},{string},{string},{string}and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String first_name, String last_name, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {

		AddAddress_Input_pojo createAddress = Payload.createAddress("vini", "Tha", "1234567898", "apartment", 33, 3378,
				101, "600041", "52", "home");
		addBody(createAddress);
	}

	/**
	 * @Description send request for add new address"
	 * @CreationDate 29/06/2022
	 * @param string
	 */
	@When("User send {string} request for add new address")
	public void userSendRequestForAddNewAddress(String string) {
		response = requestType("POST", Endpoints.ADDADDRESS);

	}

	/**
	 * @Description verify the create address response message
	 * @CreationDate 29/06/2022
	 * @param expected
	 */
	@Then("User verify the create address response message matches {string}")
	public void userVerifyTheCreateAddressResponseMessageMatches(String expected) {

		AddAddress_Output_pojo addAddress_Output_pojo = response.as(AddAddress_Output_pojo.class);
		String message = addAddress_Output_pojo.getMessage();
		System.out.println(expected);
		System.out.println(message);
		Assert.assertEquals("verify Address added successfully", expected, addAddress_Output_pojo.getMessage());
		LoginStep.commonVariables.setAddress_id(String.valueOf(addAddress_Output_pojo.getAddress_id()));

	}

	/**
	 * @Description request body for  update address
	 * @CreationDate 29/06/2022
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 */
	@When("user add request body for  update address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyForUpdateAddressAnd(String first_name, String last_name, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {

		UpdateAddress_Input_pojo updateAddress = Payload.updateAddress(address_id, "vini", "Tha", "1234567898",
				"apartment", 33, 3378, 101, "202020", "52", "home");
		addBody(updateAddress);

	}

	/**
	 * @Description send request for  update address
	 * @CreationDate 29/06/2022
	 * @param string
	 */
	@When("User send {string} request for  update address")
	public void userSendRequestForUpdateAddress(String string) {
		response = requestType("PUT", Endpoints.UPDATEADDRESS);
	}

	/**
	 * @Descriptionverify the update address response message
	 * @CreationDate 29/06/2022
	 * @param expected
	 */
	@Then("User verify the update address response message matches {string}")
	public void userVerifyTheUpdateAddressResponseMessageMatches(String expected) {
		UpdateAddress_Output_pojo updateAddress_Output_pojo = response.as(UpdateAddress_Output_pojo.class);
		System.out.println(updateAddress_Output_pojo.getMessage());
		Assert.assertEquals("verify Address updated successfully", expected, updateAddress_Output_pojo.getMessage());

	}

	/**
	 * @Description send request for get existing address
	 * @CreationDate 29/06/2022
	 * @param string
	 */
	@When("User send {string} request for get existing address")
	public void userSendRequestForGetExistingAddress(String string) {
		response = requestType("GET", Endpoints.GETADDRESS);

	}

	/**
	 * @Description verify the get existing address response message
	 * @CreationDate 29/06/2022
	 * @param expected
	 */
	@Then("User verify the get existing address response message matches {string}")
	public void userVerifyTheGetExistingAddressResponseMessageMatches(String expected) {
		GetAddress_Output_pojo getAddress_Output_pojo = response.as(GetAddress_Output_pojo.class);
		Assert.assertEquals("verify OK message", expected, getAddress_Output_pojo.getMessage());
	}

	/**
	 * @Description send request for delete address
	 * @CreationDate 29/06/2022
	 * @param string
	 */
	@When("User send {string} request for delete address")
	public void userSendRequestForDeleteAddress(String string) {
		DeleteAddress_Input_pojo deleteAddress = Payload.deleteAddress(LoginStep.commonVariables.getAddress_id());
		addBody(deleteAddress);
		response = requestType("DELETE", Endpoints.DELETEADDRESS);

	}

	/**
	 * @Description verify the delete address response message 
	 * @CreationDate  29/06/2022
	 * @param expected
	 */
	@Then("User verify the delete address response message matches {string}")
	public void userVerifyTheDeleteAddressResponseMessageMatches(String expected) {
		DeleteAddress_Output_pojo deleteAddress_Output_pojo = response.as(DeleteAddress_Output_pojo.class);
		System.out.println(deleteAddress_Output_pojo.getMessage());
		Assert.assertEquals("verify Address deleted successfully", expected, deleteAddress_Output_pojo.getMessage());

	}
}
