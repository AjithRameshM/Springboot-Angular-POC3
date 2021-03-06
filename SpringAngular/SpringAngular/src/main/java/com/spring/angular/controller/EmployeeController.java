package com.spring.angular.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.angular.model.Employee;
import com.spring.angular.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> employees = employeeService.findAllEmployee();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		 Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee addEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(addEmployee,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee updateEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
	}
	

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id){
		  employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
