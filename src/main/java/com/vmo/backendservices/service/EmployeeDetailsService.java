package com.vmo.backendservices.service;

import java.util.List;
import java.util.Optional;

import com.vmo.backendservices.persistance.Domain.EmployeeDetails;;

public interface EmployeeDetailsService {
	
	List<EmployeeDetails> findAll();
	
	EmployeeDetails save(EmployeeDetails employeeDetails);
	
	Optional<EmployeeDetails> findOne(Integer id);
	
	void delete(Integer id);

}
