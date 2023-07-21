package com.Company.CompanySpring.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Company.CompanySpring.Entity.CompantEnt;

public interface CompanyRepo extends JpaRepository<CompantEnt, Integer >{
//	Optional<CompantEnt> findById(int id);
}
