package com.prince.spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prince.spring.model.Employee;
import com.prince.spring.service.EmployeeService;

@RestController
public class EmployeeController {

	public EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/api/emp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/api/getall")
	public List<Employee> getEmployees(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable long id){
		
		return new ResponseEntity<Employee>(employeeService.getEmpById(id), HttpStatus.OK);
	}
	
	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<Employee> updateEmpById(@PathVariable long id ,@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id,employee),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<String> deleteEmpById(@PathVariable long id){
		
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee successfully deleted", HttpStatus.OK);
		
	}
}
