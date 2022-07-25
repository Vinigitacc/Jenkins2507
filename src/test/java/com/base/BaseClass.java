package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.config.MultiPartConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
/**
 * 
 * @author Dell
 *@Description To maintain Reusable methods
 *@CreationDate 27/06/2022
 */
public class BaseClass {

	RequestSpecification reqSpec;

	Response response;
/**
 * @Description To add Header
 *@CreationDate 27/06/2022
 * @param key
 * @param value
 */
	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}
/**
 * @Description To add Headers
 *@CreationDate 27/06/2022				
 * @param headers
 */
	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);

	}
/**
 * @Description To get QueryParameter
 *@CreationDate 27/06/2022
 * @param key
 * @param value
 */
	public void queryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}
/**
 * @Description To get PathParameter
 *@CreationDate 27/06/2022
 * @param key
 * @param value
 */
	public void pathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);

	}
/**
 * @Description To get Basic Authentication
 *@CreationDate 27/06/2022
 * @param userName
 * @param Password
 */
	public void basicAuth(String userName, String Password) {

		reqSpec = reqSpec.auth().preemptive().basic(userName, Password);

	}
/**
 * @Description To get multipart header
 *@CreationDate 27/06/2022
 */
	public void multipart() {
		reqSpec = reqSpec.multiPart("profile_picture",
				new File("C:\\Users\\Dell\\Pictures\\Saved Pictures\\pinkTree.png"));

	}
/**
 * @Description To get getPropertyFileValue 
 *@CreationDate 27/06/2022
 * @param key
 * @return String
 * @throws FileNotFoundException
 * @throws IOException
 */
	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		// System.out.println(value);
		return value;

	}
/**
 *@Description To get Addbody for object
 *@CreationDate 27/06/2022 
 * @param reqBody
 */
	public void addBody(Object reqBody) {
		reqSpec = reqSpec.body(reqBody);

	}
/**
 * @Description  To get Addbody for String
 *@CreationDate 27/06/2022
 * @param reqBody
 */
	public void addBody(String reqBody) {
		reqSpec = reqSpec.body(reqBody);

	}
/**
 * @Description To get reqType and endpoints
 *@CreationDate 27/06/2022
 * @param reqType
 * @param endPoint
 * @return Response
 */
	public Response requestType(String reqType, String endPoint) {
		switch (reqType) {
		case "GET":
			response = reqSpec.log().all().get(endPoint);
			break;

		case "POST":
			response = reqSpec.log().all().post(endPoint);
			break;

		case "PUT":
			response = reqSpec.log().all().put(endPoint);
			break;

		case "DELETE":
			response = reqSpec.log().all().delete(endPoint);
			break;

		default:
			break;
		}
		return response;
	}
/**
 * @Description To get statusCode
 *@CreationDate 27/06/2022
 * @param response
 * @return int
 */
	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;

	}
/**
 * @Description To get responseBody
 *@CreationDate 27/06/2022
 * @param response
 * @return ResponseBody
 */
	public ResponseBody getResponseBody(Response response) {
		ResponseBody responseBody = response.getBody();
		return responseBody;
	}
/**
 * @Description To get output as String format
 *@CreationDate 27/06/2022
 * @param response
 * @return String
 */
	public String getResBodyAsString(Response response) {
		String asString = getResponseBody(response).asString();
		return asString;

	}
/**
 * @Description To get output as pretty format
 *@CreationDate 27/06/2022
 * @param response
 * @return String
 */
	public String getResBodyAsPretty(Response response) {
		String asPrettyString = getResponseBody(response).asPrettyString();
		return asPrettyString;

	}
}
