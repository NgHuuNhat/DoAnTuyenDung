package com.tuyendungvieclam.response.admin.booktour;

import com.tuyendungvieclam.dto.BookTourDTO;

public class ViewUpdateBookTourResponse {

	private String bookTourId;

	private String tourDateFrom;

	private String tourDateTo;

	private int amountAdults;

	private int amountKid5From11;

	private int amountKid2From5;

	private int amountKidLess2;

	private String fullNameCustomer;

	private String emailCustomer;

	private String phoneNumberCustomer;

	private String addressCustomer;

	private String notedCustomer;

	private String userName;

	private String newId;

	public String getBookTourId() {
		return bookTourId;
	}

	public void setBookTourId(String bookTourId) {
		this.bookTourId = bookTourId;
	}

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

	public static ViewUpdateBookTourResponse copy(BookTourDTO booktourDTO) {
		ViewUpdateBookTourResponse result = new ViewUpdateBookTourResponse();
		result.setAddressCustomer(booktourDTO.getAddressCustomer());
		result.setEmailCustomer(booktourDTO.getEmailCustomer());
		result.setBookTourId(booktourDTO.getBookTourId());
		result.setFullNameCustomer(booktourDTO.getFullNameCustomer());
		result.setNewId(booktourDTO.getNewId());
		result.setNotedCustomer(booktourDTO.getNotedCustomer());
		result.setPhoneNumberCustomer(booktourDTO.getPhoneNumberCustomer());
		result.setUserName(booktourDTO.getUserName());
		return result;
	}

}
