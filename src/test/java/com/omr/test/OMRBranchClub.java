package com.omr.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payload.Payload;
import com.pojo.AddAddress_Input_pojo;
import com.pojo.AddAddress_Output_pojo;
import com.pojo.ChangeProfilePic_Output_pojo;
import com.pojo.DeleteAddress_Input_pojo;
import com.pojo.DeleteAddress_Output_pojo;
import com.pojo.GetAddress_Output_pojo;
import com.pojo.Login_Output_pojo;
import com.pojo.UpdateAddress_Input_pojo;
import com.pojo.UpdateAddress_Output_pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
/**
 * 
 * @author Dell
 * @Description
 * @CreationDate 20/06/2022
 *
 */
public class OMRBranchClub extends BaseClass {
	String logtoken;
	String address_id;
/**
 * @Description
 * @CreationDate 20/06/2022
 * @throws FileNotFoundException
 * @throws IOException
 */
	@Test(priority = 1)
	public void Login() throws FileNotFoundException, IOException {

		addHeader("Content-Type", "application/json");
		basicAuth(getPropertyFileValue("userName"), getPropertyFileValue("Password"));
		Response response = requestType("POST", Endpoints.LOGIN);
		int statuscode = getStatusCode(response);
		System.out.println(statuscode);

		Assert.assertEquals(statuscode, 200, "verify status code");

		Login_Output_pojo login_Output_pojo = response.as(Login_Output_pojo.class);
		String first_name = login_Output_pojo.getData().getFirst_name();
		System.out.println(first_name);

		Assert.assertEquals(first_name, "Vini", "verify firstname");
		logtoken = login_Output_pojo.getData().getLogtoken();
	}
/**
 * @Description
 * @CreationDate 20/06/2022
 */
	@Test(priority = 2)
	private void addAddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);

		AddAddress_Input_pojo addAddress_Input_pojo = Payload.createAddress("vini", "Tha", "1234567898",
				"apartment", 33, 3378, 101, "600041", "52", "home");
		addBody(addAddress_Input_pojo);

		Response response = requestType("POST", Endpoints.ADDADDRESS);
		int StatusCode = getStatusCode(response);
		System.out.println(StatusCode);
		Assert.assertEquals(StatusCode, 200, "verify status code");

		AddAddress_Output_pojo addAddress_Output_pojo = response.as(AddAddress_Output_pojo.class);
		String message = addAddress_Output_pojo.getMessage();
		System.out.println(message);

		int id = addAddress_Output_pojo.getAddress_id();
		address_id = String.valueOf(id);
		System.out.println(address_id);
		Assert.assertEquals(message, "Address added successfully", "verify Address added successfully");
	}
/**
 * @Description
 * @CreationDate 20/06/2022
 */
	@Test(priority = 3)
	private void updateAddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);

		UpdateAddress_Input_pojo updateAddress_Input_pojo =Payload.updateAddress(address_id, "vini", "Tha",
				"1234567898", "apartment", 33, 3378, 101, "202020", "52", "home");
		addBody(updateAddress_Input_pojo);

		Response response = requestType("PUT", Endpoints.UPDATEADDRESS);
		int StatusCode = getStatusCode(response);
		System.out.println(StatusCode);
		System.out.println(getResBodyAsPretty(response));
		Assert.assertEquals(StatusCode, 200, "verify status code");

		UpdateAddress_Output_pojo updateAddress_Output_pojo = response.as(UpdateAddress_Output_pojo.class);
		String message = updateAddress_Output_pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address updated successfully", "verify Address updated successfully");

	}
/**
 * @Description
 * @CreationDate 20/06/2022 
 */
	@Test(priority = 4)
	private void GetAddress() {

		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);

		Response response = requestType("GET", Endpoints.GETADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		System.out.println(getResBodyAsPretty(response));
		Assert.assertEquals(statusCode, 200, "verify status code");

		GetAddress_Output_pojo getAddress_Output_pojo = response.as(GetAddress_Output_pojo.class);
		String message = getAddress_Output_pojo.getMessage();
		Assert.assertEquals(message, "OK", "verify OK");

	}
/**
 * @Description
 * @CreationDate 20/06/2022
 */
	@Test(priority = 5)
	public void DeleteAddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);

		DeleteAddress_Input_pojo deleteAddress_Input_pojo = Payload.deleteAddress(address_id);
		addBody(deleteAddress_Input_pojo);

		Response response = requestType("DELETE", Endpoints.DELETEADDRESS);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "verify status code");

		DeleteAddress_Output_pojo deleteAddress_Output_pojo = response.as(DeleteAddress_Output_pojo.class);
		String message = deleteAddress_Output_pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address deleted successfully", "verify Address deleted successfully");

	}
/**
 * @Description
 * @CreationDate 20/06/2022
 */
	@Test(priority = 6)
	public void changeProfilePic() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("Content-Type", "multipart/form-data");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);
		addHeaders(headers);

		multipart();

		Response response = requestType("POST", Endpoints.CHANGEPROFILEPIC);
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "verify status code");

		 ChangeProfilePic_Output_pojo
		 changeProfilePic_Output_pojo=response.as(ChangeProfilePic_Output_pojo.class);
		 String message = changeProfilePic_Output_pojo.getMessage();
		 Assert.assertEquals(message,"Profile updated Successfully", "verify Profile updated Successfully");

	}

}
