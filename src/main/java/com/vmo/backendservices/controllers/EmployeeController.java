package com.vmo.backendservices.controllers;

import com.vmo.backendservices.persistance.Domain.EmployeeDetails;
import com.vmo.backendservices.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<EmployeeDetails> findOne(@PathVariable Long id) {
        return employeeDetailsService.findOne(id);
    }

    @RequestMapping(value = "/updateEmployee/{id}", method = RequestMethod.PUT)
    public EmployeeDetails update(@PathVariable Integer id, @RequestBody EmployeeDetails employeeDetails) {
        employeeDetails.setEmployeeId(id);
        return employeeDetailsService.save(employeeDetails);
    }

    @RequestMapping(value = "/removeEmployee/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        employeeDetailsService.delete(id);
    }

    @RequestMapping(value = "/countByDepartment", method = RequestMethod.GET)
    public List<Object[]> getCountGroupByDepartment() {
        return employeeDetailsService.getCountGroupByDepartment();
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> getFile() {
        String filename = "tutorials.csv";
        InputStreamResource file = new InputStreamResource(employeeDetailsService.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }
}
