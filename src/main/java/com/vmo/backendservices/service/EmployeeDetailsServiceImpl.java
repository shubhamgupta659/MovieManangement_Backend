package com.vmo.backendservices.service;

import com.vmo.backendservices.persistance.Domain.EmployeeDetails;
import com.vmo.backendservices.persistance.Repository.EmployeeRepository;
import com.vmo.backendservices.utility.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDetails> findAll() {
        return employeeRepository.findAll();
    }

    public EmployeeDetails save(EmployeeDetails employeeDetails) {
        return employeeRepository.save(employeeDetails);
    }

    public Optional<EmployeeDetails> findOne(Integer id) {
        return employeeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    public List<Object[]> getCountGroupByDepartment() {
        List<Object[]> results = employeeRepository.findDepartmentWithCounts();
        return results;
    }

    public ByteArrayInputStream load() {
        List<EmployeeDetails> tutorials = employeeRepository.findAll();

        ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
        return in;
    }
}
