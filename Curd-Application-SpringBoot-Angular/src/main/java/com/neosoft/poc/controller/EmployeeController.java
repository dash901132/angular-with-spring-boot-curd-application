package com.neosoft.poc.controller;

import com.neosoft.poc.config.ResourceNotFoundException;
import com.neosoft.poc.model.dto.EmployeeDto;
import com.neosoft.poc.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?>getEmployeeById(@PathVariable(value = "id") String employeeId) throws Exception {
        EmployeeDto employeeDto=employeeService.getById(employeeId);
        return ResponseEntity.ok().body(employeeDto);
    }

    @PostMapping("/employees")
    public ResponseEntity<?> createEmployee( @RequestBody EmployeeDto employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeDetails) throws Exception {
      return ResponseEntity.ok(employeeService.update(employeeDetails));

    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") String eid){
        String employeeDto=employeeService.deleteById(eid);
        return ResponseEntity.ok("Employee deleted sucessfully ");
    }

}
