package com.prince.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prince.spring.exception.ResourceNotFoundException;
import com.prince.spring.model.Employee;
import com.prince.spring.repository.EmployeeRepository;
import com.prince.spring.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	public EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
	return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmpById(long id) {
//		Optional<Employee>employee=  employeeRepository.findById(id);
//		
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "ID", id);
//		}
		
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id));
	}

	@Override
	public Employee updateEmployee(long id,Employee employee) {
		
		//for checking id exist or not
	    Employee existingEmployee=employeeRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee", "ID", id));
		 existingEmployee.setFirstName(employee.getFirstName());
		 existingEmployee.setLastName(employee.getLastName());
		 existingEmployee.setEmail(employee.getEmail());
		 
		 employeeRepository.save(existingEmployee);
	    
	    return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		//to check in db employee is exist or not 
		employeeRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee", "ID", id));
		
		employeeRepository.deleteById(id);
		
	}

	

}
