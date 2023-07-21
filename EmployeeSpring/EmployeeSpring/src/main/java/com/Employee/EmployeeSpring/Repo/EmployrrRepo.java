package com.Employee.EmployeeSpring.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.EmployeeSpring.Entity.EmployeeEnt;

public interface EmployrrRepo extends JpaRepository<EmployeeEnt, Integer>{
	 EmployeeEnt findById(int id);
//	 Optional<EmployeeEnt> findBY
}
