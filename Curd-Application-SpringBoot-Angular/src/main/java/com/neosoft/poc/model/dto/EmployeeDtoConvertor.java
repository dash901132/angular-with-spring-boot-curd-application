package com.neosoft.poc.model.dto;

import com.neosoft.poc.model.EmployeeState;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDtoConvertor {
    public EmployeeState convertDtoToBean(EmployeeDto employeedto)
    {
        EmployeeState employeeState = new EmployeeState();
        if (employeedto.getId()!=null)
        {
            employeeState.setId(employeedto.getId());
        }
        BeanUtils.copyProperties(employeedto, employeeState);
        return employeeState;
    }


    public  EmployeeDto convertBeanToDto(EmployeeState employee)
    {
        EmployeeDto employeeDto=new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        return employeeDto;

    }

    public List<EmployeeDto> convertListOfBeansToDto(List<EmployeeState> employeeList){
        final List<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
        employeeList.stream().forEach(x->{
            employeeDtoList.add(this.convertBeanToDto(x));
        });

        return employeeDtoList;
    }
}
