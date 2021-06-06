package com.vmo.backendservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vmo.backendservices.persistance.Domain.EmployeeDetails;
import com.vmo.backendservices.persistance.Repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeDetails> findAll(){
		return employeeRepository.findAll();
	}
	
	public EmployeeDetails save(EmployeeDetails employeeDetails) {
		return employeeRepository.save(employeeDetails);
	}
	
	public Optional<EmployeeDetails> findOne(Integer id){
		return employeeRepository.findById(id);
	}
	
	public void delete(Integer id) {
		employeeRepository.deleteById(id);
	}

	public List<Object[]> getCountGroupByDepartment(){
		List<Object[]> results = employeeRepository.findDepartmentWithCounts();
		return results;
	}
}
