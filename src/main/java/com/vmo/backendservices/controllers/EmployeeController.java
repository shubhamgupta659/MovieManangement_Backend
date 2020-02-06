
package com.vmo.backendservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vmo.backendservices.persistance.Domain.EmployeeDetails;
import com.vmo.backendservices.service.EmployeeDetailsService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeDetailsService employeeDetailsService;

	@GetMapping("/findEmployees")
	public List<EmployeeDetails> listUser() {
		return employeeDetailsService.findAll();
	}

	@RequestMapping(value = "/insertEmployee", method = RequestMethod.POST)
	public EmployeeDetails create(@RequestBody EmployeeDetails employeeDetails) {
		return employeeDetailsService.save(employeeDetails);
	}

	@RequestMapping(value = "/findEmployee/{id}", method = RequestMethod.GET)
	public Optional<EmployeeDetails> findOne(@PathVariable Integer id) {
		return employeeDetailsService.findOne(id);
	}

	@RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
	public EmployeeDetails update(@PathVariable Integer id, @RequestBody EmployeeDetails employeeDetails) {
		employeeDetails.setEmployeeId(id);
		return employeeDetailsService.save(employeeDetails);
	}

	@RequestMapping(value = "/removeEmployee/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") Integer id) {
		employeeDetailsService.delete(id);
	}
}
