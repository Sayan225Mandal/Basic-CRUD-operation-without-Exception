package com.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.employeeservice.model.Employee;
import com.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addemployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee employee1 = employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee1);
	}

	@GetMapping("/getallempolyee")
	public ResponseEntity<List<Employee>> getAllEmployeeById() {
		List<Employee> employee = employeeService.getAllEmployeeById();
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

	@GetMapping("/getemployeebyid/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int empId) {
		Employee employee = employeeService.getEmployeeById(empId);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

	@PutMapping("/updateemployee/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int empId, @RequestBody Employee updateEmployee) {
		Employee updated = employeeService.updateEmployee(empId, updateEmployee);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}

	@DeleteMapping("/deleteemployeebyid/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int empId) {
		String message = employeeService.deleteEmployee(empId);
		return ResponseEntity.status(HttpStatus.OK).body(message);

	}

}
