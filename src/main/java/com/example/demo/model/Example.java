package com.example.demo.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
public class Example {
private int number;
private String Ename;
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public String getEname() {
	return Ename;
}
public void setEname(String ename) {
	Ename = ename;
}
@Override
public String toString() {
	return "Example [number=" + number + ", Ename=" + Ename + "]";
}

}
