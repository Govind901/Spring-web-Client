package com.Company.CompanySpring.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table(name="company")
@Entity(name="CompantEnt")
public class CompantEnt {
		
	@Id
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
	public CompantEnt(int companyId, String compantName, String address) {
		super();
		this.companyId = companyId;
		this.compantName = compantName;
		this.address = address;
	}
	public CompantEnt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
