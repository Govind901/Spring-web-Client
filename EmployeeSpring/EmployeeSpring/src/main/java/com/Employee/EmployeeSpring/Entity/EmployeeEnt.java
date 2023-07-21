package com.Employee.EmployeeSpring.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="EmployeeEnt")
public class EmployeeEnt {
	@Id
	int empId;
	String empName;
	String empAddress;
	int companyId;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public void setCompanyId(int companyId) {
		this.companyId=companyId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public EmployeeEnt(int empId, String empName, String empAddress, int companyId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.companyId = companyId;
	}
	public EmployeeEnt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
