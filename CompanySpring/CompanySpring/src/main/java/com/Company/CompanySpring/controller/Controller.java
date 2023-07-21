package com.Company.CompanySpring.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Company.CompanySpring.Entity.CompantEnt;
import com.Company.CompanySpring.Exception.ApiExceptions;
import com.Company.CompanySpring.Repo.CompanyRepo;
@RequestMapping("/api")
@RestController
public class Controller {
	@Autowired
	CompanyRepo companyRepo;
	
	@GetMapping("/company/{id}")
	public ResponseEntity<CompantEnt> companyById(@PathVariable int  id) {
		Optional<CompantEnt> use=companyRepo.findById(id);
		System.out.println("gf "+use.toString());
		if(use.isPresent()) {
			CompantEnt res = new CompantEnt(use.get().getCompanyId(),use.get().getCompantName(),use.get().getAddress());
		
			return new ResponseEntity<>(res,HttpStatus.OK);
		}
		else {
			throw new ApiExceptions("INCORRECT ID ENTERED");
//			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/company")
	public ResponseEntity<String> adingCompany(@RequestBody CompantEnt ce) {
		System.out.println("dgh");
		Optional<CompantEnt> use=companyRepo.findById(ce.getCompanyId());
		System.out.println("ddikv");
		if(use.isEmpty()) {
			companyRepo.save(ce);
			return new ResponseEntity<String>("CREATED",HttpStatus.CREATED);
		}
		else {
			System.out.println("doing");
			throw new ApiExceptions("ENTER CORRRECT CREDENTIALS");
//			return new ResponseEntity<>("ENTER CORRRECT CREDENTIALS",HttpStatus.BAD_REQUEST);
		}
	}

}
