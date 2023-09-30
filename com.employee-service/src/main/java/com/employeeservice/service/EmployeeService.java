package com.employeeservice.service;

import java.util.List;

import com.employeeservice.model.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	List<Employee> getAllEmployeeById();

	Employee getEmployeeById(int empId);

	String deleteEmployee(int empId);

	Employee updateEmployee(int empId, Employee updateEmployee);

}
