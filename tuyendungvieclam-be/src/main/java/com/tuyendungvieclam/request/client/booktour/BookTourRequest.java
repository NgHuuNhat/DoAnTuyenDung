package com.tuyendungvieclam.request.client.booktour;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookTourRequest {

	@JsonProperty("tour_date_from")
	private String tourDateFrom;
	
	@JsonProperty("tour_date_to")
	private String tourDateTo;
	
	@JsonProperty("amount_adults")
	private int amountAdults;
	
	@JsonProperty("amount_kid_5_from_11")
	private int amountKid5From11;
	
	@JsonProperty("amount_kid_2_from_5")
	private int amountKid2From5;
	
	@JsonProperty("amount_kid_less_2")
	private int amountKidLess2;
	
	@JsonProperty("full_name_customer")
	private String fullNameCustomer;
	
	@JsonProperty("email_customer")
	private String emailCustomer;
	
	@JsonProperty("phone_number_customer")
	private String phoneNumberCustomer;
	
	@JsonProperty("address_customer")
	private String addressCustomer;
	
	@JsonProperty("noted_customer")
	private String notedCustomer;
	
	@JsonProperty("user_name")
	private String userName;
	
	@JsonProperty("new_id")
	private String newId;

	public String getTourDateFrom() {
		return tourDateFrom;
	}

	public void setTourDateFrom(String tourDateFrom) {
		this.tourDateFrom = tourDateFrom;
	}

	public String getTourDateTo() {
		return tourDateTo;
	}

	public void setTourDateTo(String tourDateTo) {
		this.tourDateTo = tourDateTo;
	}

	public int getAmountAdults() {
		return amountAdults;
	}

	public void setAmountAdults(int amountAdults) {
		this.amountAdults = amountAdults;
	}

	public int getAmountKid5From11() {
		return amountKid5From11;
	}

	public void setAmountKid5From11(int amountKid5From11) {
		this.amountKid5From11 = amountKid5From11;
	}

	public int getAmountKid2From5() {
		return amountKid2From5;
	}

	public void setAmountKid2From5(int amountKid2From5) {
		this.amountKid2From5 = amountKid2From5;
	}

	public int getAmountKidLess2() {
		return amountKidLess2;
	}

	public void setAmountKidLess2(int amountKidLess2) {
		this.amountKidLess2 = amountKidLess2;
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

	public String getNotedCustomer() {
		return notedCustomer;
	}

	public void setNotedCustomer(String notedCustomer) {
		this.notedCustomer = notedCustomer;
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
