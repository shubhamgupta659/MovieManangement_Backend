package com.vmo.backendservices.service;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import com.vmo.backendservices.persistance.Domain.EmployeeDetails;;

public interface EmployeeDetailsService {
	
	List<EmployeeDetails> findAll();
	
	EmployeeDetails save(EmployeeDetails employeeDetails);
	
	Optional<EmployeeDetails> findOne(Long id);
	
	void delete(Long id);

	public List<Object[]> getCountGroupByDepartment();

	public ByteArrayInputStream load();

}
