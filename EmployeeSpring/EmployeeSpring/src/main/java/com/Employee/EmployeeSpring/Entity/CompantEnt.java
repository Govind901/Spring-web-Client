package com.Employee.EmployeeSpring.Entity;

import org.springframework.stereotype.Component;

@Component
public class CompantEnt {
	int companyId;
	String compantName;
	String address;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompantName() {
		return compantName;
	}
	public void setCompantName(String compantName) {
		this.compantName = compantName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
