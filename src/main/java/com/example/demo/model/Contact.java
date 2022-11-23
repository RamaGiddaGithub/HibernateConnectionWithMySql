package com.example.demo.model;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {
   private String phone;
   private String email;
   private Address address;
   
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Contact [phone=" + phone + ", email=" + email + "]";
}
   
}