package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);
	
	List<Employee>getAllEmployees();
	
	Employee getEmployeeById(int id);
	
	Employee updateEmployee(int id,Employee employee);
	
	String deleteEmployee(int id);
}
