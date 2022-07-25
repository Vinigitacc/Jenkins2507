package com.payload;

import com.pojo.AddAddress_Input_pojo;
import com.pojo.DeleteAddress_Input_pojo;
import com.pojo.UpdateAddress_Input_pojo;
/**
 * 
 * @author Dell
 *@Description
 *@CreationDate
 */
public class Payload {
/**
 * @Description
 *@CreationDate
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
 * @return
 */
	public static AddAddress_Input_pojo createAddress(String first_name, String last_name, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address, String address_type) {

		AddAddress_Input_pojo addAddress_Input_pojo = new AddAddress_Input_pojo(first_name, last_name, mobile,
				apartment, state, city, country, zipcode, address, address_type);
		return addAddress_Input_pojo;
	}
/**
 * @Description
 *@CreationDate
 * @param address_id
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
 * @return
 */
	public static UpdateAddress_Input_pojo updateAddress(String address_id, String first_name, String last_name,
			String mobile, String apartment, int state, int city, int country, String zipcode, String address,
			String address_type) {

		UpdateAddress_Input_pojo updateAddress_Input_pojo = new UpdateAddress_Input_pojo(address_id, first_name,
				last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		return updateAddress_Input_pojo;

	}
/**
 * @Description
 *@CreationDate
 * @param address_id
 * @return
 */
	public static DeleteAddress_Input_pojo deleteAddress(String address_id) {

		DeleteAddress_Input_pojo deleteAddress_Input_pojo = new DeleteAddress_Input_pojo(address_id);
		return deleteAddress_Input_pojo;

	}

}
