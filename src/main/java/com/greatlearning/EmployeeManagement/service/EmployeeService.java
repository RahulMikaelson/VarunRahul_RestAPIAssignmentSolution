package com.greatlearning.EmployeeManagement.service;

import java.util.List;

import com.greatlearning.EmployeeManagement.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee employe);

	public void deleteById(int theId);

	public List<Employee> searchBy(String f_name);

}
