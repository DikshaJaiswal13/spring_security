package com.pack.service;

import java.util.List;

import com.pack.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee e);
	public List<Employee> listEmployees();
	public void deleteEmployee(Integer id);
}

