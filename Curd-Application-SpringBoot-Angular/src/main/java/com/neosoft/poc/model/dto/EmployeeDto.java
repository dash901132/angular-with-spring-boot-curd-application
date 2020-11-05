package com.neosoft.poc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Document("employee_state")
    public class EmployeeDto {
        protected String id;
        protected String ename;
        protected String lname;
        protected String salary;
        protected String dept;



    }
