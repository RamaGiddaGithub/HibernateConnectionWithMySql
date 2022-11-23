package com.example.demo.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
private String address;
private String state;
private String country;
private int pincode;
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
@Override
public String toString() {
	return "Address [address=" + address + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
}

}
