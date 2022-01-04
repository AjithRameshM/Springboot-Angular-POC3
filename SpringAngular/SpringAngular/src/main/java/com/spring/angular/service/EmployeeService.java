package com.spring.angular.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.angular.exception.EmployeeNotFoundException;
import com.spring.angular.model.Employee;
import com.spring.angular.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeerepository;

	//add employee
	public Employee addEmployee(Employee employee) {
		//employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeerepository.save(employee);
		}
	
	//find All employee
	public List<Employee> findAllEmployee(){
		return employeerepository.findAll();
	}
	
	//update employee
	public Employee updateEmployee(Employee employee) {
		return employeerepository.save(employee);
	}
	
	//find by id
	public Employee findEmployeeById(Long id) {
        return employeerepository.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("User by id " + id + " was not found"));
    }
	
	//delete employee
	public void deleteEmployee(Long id) {
		employeerepository.deleteEmployeeById(id);
	}
}
