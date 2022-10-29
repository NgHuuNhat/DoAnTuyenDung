package com.tuyendungvieclam.request.admin.booktour;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateBookTourRequest {

	@JsonProperty("book_tour_id")
	private String bookTourId;

	@JsonProperty("full_name_customer")
	private String fullNameCustomer;

	@JsonProperty("email_customer")
	private String emailCustomer;

	@JsonProperty("phone_number_customer")
	private String phoneNumberCustomer;

	@JsonProperty("address_customer")
	private String addressCustomer;

	@JsonProperty("user_name")
	private String userName;

	@JsonProperty("new_id")
	private String newId;

	public String getBookTourId() {
		return bookTourId;
	}

	public void setBookTourId(String bookTourId) {
		this.bookTourId = bookTourId;
	}

	public String getFullNameCustomer() {
		return fullNameCustomer;
	}

	public void setFullNameCustomer(String fullNameCustomer) {
		this.fullNameCustomer = fullNameCustomer;
	}

	public String getEmailCustomer() {
		return emailCustomer;
	}

	public void setEmailCustomer(String emailCustomer) {
		this.emailCustomer = emailCustomer;
	}

	public String getPhoneNumberCustomer() {
		return phoneNumberCustomer;
	}

	public void setPhoneNumberCustomer(String phoneNumberCustomer) {
		this.phoneNumberCustomer = phoneNumberCustomer;
	}

	public String getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	

}
