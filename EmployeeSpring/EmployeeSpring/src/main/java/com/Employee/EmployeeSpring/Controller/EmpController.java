package com.Employee.EmployeeSpring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.Employee.EmployeeSpring.Entity.CompantEnt;
import com.Employee.EmployeeSpring.Entity.EmployeeEnt;
import com.Employee.EmployeeSpring.Entity.ResponceData;
import com.Employee.EmployeeSpring.Exception.ApiExceptions;
import com.Employee.EmployeeSpring.Repo.EmployrrRepo;

@RequestMapping("/api")
@RestController
public class EmpController {
	 WebClient webclient=WebClient.create("http://localhost:7071/api");
	@Autowired
	EmployrrRepo employrrRepo;
	
	
	@GetMapping("/employee/{i}")
	public ResponseEntity<ResponceData> getingEmpData(@PathVariable int i) {
		ResponceData responce=new ResponceData();
		EmployeeEnt use=employrrRepo.findById(i);
		CompantEnt com = new CompantEnt();
		 com=webclient.get().uri("/company/"+use.getCompanyId()).retrieve().bodyToMono(CompantEnt.class).block();
		 responce.setEmployeeEnt(use);
		 responce.setCompantEnt(com);
		 return new ResponseEntity<>(responce,HttpStatus.OK);		
	}
	
	
	@PostMapping("/employee")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeEnt ee) {
		EmployeeEnt use=employrrRepo.findById(ee.getEmpId());
		if(use==(null)) {
			employrrRepo.save(ee);
			return new ResponseEntity<>("INSERTED",HttpStatus.CREATED);
		}
		else {
			throw new ApiExceptions("ENTER CORRECT CREDENTIALS");		
			}
	} 
	
	@PostMapping("/employeeCompany")
	public ResponseEntity<String> addempcom(@RequestBody ResponceData rd) {
		employrrRepo.save(rd.getEmployeeEnt());
		return new ResponseEntity<>(insertingToCompany(rd.getCompantEnt()),HttpStatus.CREATED);
				
	}
	
	@PostMapping("/company") 
	public ResponseEntity<String> addComp(@RequestBody CompantEnt ce) {
		return new ResponseEntity<>(insertingToCompany(ce),HttpStatus.CREATED);
	
	}
	
	@PutMapping("/employee")
	public ResponseEntity<String> updation(@RequestBody EmployeeEnt ee) {
		EmployeeEnt emp=employrrRepo.findById(ee.getEmpId());
		if(!emp.equals(null)) {
			emp.setCompanyId(ee.getCompanyId());
			emp.setEmpAddress(ee.getEmpAddress());
			emp.setEmpName(ee.getEmpName());
			employrrRepo.save(emp);
			
			return new ResponseEntity<>("UPDATED",HttpStatus.CREATED);
		}
		else {
			
			return new ResponseEntity<>("ENTER CORRECT DETAILS",HttpStatus.BAD_REQUEST);
		}
	}
	
	public String insertingToCompany(CompantEnt ce) {
		
		Object responce = webclient.post().uri("/company").bodyValue(ce).retrieve().bodyToMono(Object.class).block();
//		if(responce.stat)
		if(responce.getClass().equals(String.class)) {
			return responce.toString();
			
		}
		else {
			return "dfgtrrth";
		}
	
	}
	
	
}
