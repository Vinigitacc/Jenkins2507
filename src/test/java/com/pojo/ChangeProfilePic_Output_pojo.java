package com.pojo;
/**
 * 
 * @author Dell
 *@Description To maintain ChangeProfilePic_Output_pojo class by using Getters and Setters
 *@CreationDate 20/06/2022
 */
public class ChangeProfilePic_Output_pojo {
	
	private int status;
	private String message;
	private Data data;
	private int cart_count;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public int getCart_count() {
		return cart_count;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}

}
