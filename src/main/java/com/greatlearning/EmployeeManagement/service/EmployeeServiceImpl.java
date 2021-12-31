package com.greatlearning.EmployeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.entity.Employee;
import com.greatlearning.EmployeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employerepository;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub

		List<Employee> emply = employerepository.findAll();
		return emply;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employerepository.findById(theId).get();
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employerepository.save(employee);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub;
		employerepository.deleteById(theId);

	}

	@Override
	public List<Employee> searchBy(String f_name) {
		// TODO Auto-generated method stub
		List<Employee> emplyee = employerepository.findByFirstNameContainsAllIgnoreCase(f_name);
		return emplyee;
	}

}
