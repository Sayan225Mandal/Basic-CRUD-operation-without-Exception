package com.employeeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeservice.model.Employee;
import com.employeeservice.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee employee1 = employeeRepo.save(employee);
		return employee1;
	}

	@Override
	public List<Employee> getAllEmployeeById() {
		List<Employee> employees = employeeRepo.findAll();
		return employees;
	}

	@Override
	public Employee getEmployeeById(int empId) {
		Optional<Employee> employee = employeeRepo.findById(empId);
		if (employee.isPresent()) {
			return employeeRepo.findById(empId).get();
		} else
			return null;
	}

	@Override
	public Employee updateEmployee(int empId, Employee updateEmployee) {
		Optional<Employee> employee = employeeRepo.findById(empId);
		if (employee.isPresent()) {
			Employee existingCourse = employee.get();
			existingCourse.setEmpName(updateEmployee.getEmpName());
			existingCourse.setDepartment(updateEmployee.getDepartment());
			existingCourse.setSalary(updateEmployee.getSalary());
			return employeeRepo.save(existingCourse);
		} else {
			return null;
		}
	}

	@Override
	public String deleteEmployee(int empId) {
		Optional<Employee> deleteEmployee = employeeRepo.findById(empId);
		if (deleteEmployee.isPresent()) {
			employeeRepo.delete(deleteEmployee.get());
			return "Employee " + empId + "delete successfully";
		} else {
			return "Employee with ID " + empId + " not found.";
		}
	}

}
