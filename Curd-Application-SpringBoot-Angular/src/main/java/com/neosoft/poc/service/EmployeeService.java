package com.neosoft.poc.service;

import com.neosoft.poc.model.EmployeeState;
import com.neosoft.poc.model.dto.EmployeeDto;
import com.neosoft.poc.model.dto.EmployeeDtoConvertor;
import com.neosoft.poc.repository.IEmployeeRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepositroy employeeRepositroy;

    @Override
    public String save(EmployeeDto employeeDto) {
        EmployeeState employeeState = new EmployeeDtoConvertor().convertDtoToBean(employeeDto);
        EmployeeState e = employeeRepositroy.save(employeeState);
        if (e != null) {
            return "Employee registration sucessful";
        }
        return "registration failed";
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeState> employeeStates = employeeRepositroy.findAll();
        return new EmployeeDtoConvertor().convertListOfBeansToDto(employeeStates);
    }

    @Override
    public EmployeeDto getById(String id) throws Exception {
        Optional<EmployeeState> optional = employeeRepositroy.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("Employee not found");
        }
        return new EmployeeDtoConvertor().convertBeanToDto(optional.get());
    }

    @Override
    public String deleteById(String id) {
        Optional<EmployeeState> optional = employeeRepositroy.findById(id);
        if (optional.isPresent()) {
            employeeRepositroy.delete(optional.get());
            return "Employee deleted sucessfuly";
        }

        return "employee not found";
    }

    @Override
    public String update(EmployeeDto dto) {
        EmployeeState state=new EmployeeDtoConvertor().convertDtoToBean(dto);

        List<EmployeeState>list=employeeRepositroy.findAll();
        Optional<EmployeeState> employeeState = employeeRepositroy.findById(dto.getId());
        EmployeeState oldState = null;
        oldState = employeeState.get();
        oldState.setEname(dto.getEname());
        oldState.setDept(dto.getDept());
        oldState.setSalary(dto.getSalary());
        employeeRepositroy.save(oldState);
        return "Employee updated sucessfully" + dto.getId();

    }
}
