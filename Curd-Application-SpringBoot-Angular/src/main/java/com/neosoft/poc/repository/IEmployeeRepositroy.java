package com.neosoft.poc.repository;

import com.neosoft.poc.model.EmployeeState;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IEmployeeRepositroy  extends MongoRepository<EmployeeState,String> {
   // Optional<EmployeeState>getById(String eid);
}
