package com.prince.spring.service;


import java.util.List;

import com.prince.spring.model.Employee;


public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmpById(long id);
	Employee updateEmployee(long id,Employee employee);
	void deleteEmployee(long id);

}
