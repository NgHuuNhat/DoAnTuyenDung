package com.tuyendungvieclam.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "book_tour")
public class BookTourEntity extends BaseEntity {

	@Id
	@Column(name = "book_tour_id")
	private String bookTourId;

	@Column(name = "full_name_customer")
	private String fullNameCustomer;

	@Column(name = "email_customer")
	private String emailCustomer;

	@Column(name = "phone_number_customer")
	private String phoneNumberCustomer;

	@Column(name = "address_customer")
	private String addressCustomer;

	@Column(name = "noted_customer")
	private String notedCustomer;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "new_id")
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
