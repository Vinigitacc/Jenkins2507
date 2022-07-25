package com.pojo;
/**
 * @Description To get the common variables for login,address and changeprofilepic
 * CreationDate 29/06/2022
 * @author Dell
 *
 */
public class CommonVariables {
	
	private String logToken;
	private int statusCode;
	private String Address_id;
	

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getAddress_id() {
		return Address_id;
	}

	public void setAddress_id(String address_id) {
		Address_id = address_id;
	}

	public String getLogToken() {
		return logToken;
	}

	public void setLogToken(String logToken) {
		this.logToken = logToken;
	}
	
	
	
	

}
