package com.neosoft.poc.service;

import com.neosoft.poc.model.dto.EmployeeDto;

import javax.swing.text.BadLocationException;
import java.util.List;

public interface IEmployeeService {
    String save(EmployeeDto employeeDto);
    List<EmployeeDto>getAllEmployee();
    EmployeeDto getById(String id) throws Exception;
    String deleteById(String id);
    String update(EmployeeDto dto);
}
