package com.prince.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prince.spring.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	//we don't need to @repository becoz jpa repo by default are taking care of 

}
