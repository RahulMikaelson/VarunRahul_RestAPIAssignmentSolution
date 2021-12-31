package com.greatlearning.EmployeeManagement.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee_details")
@Data
@Getter
@Setter
public class Employee {
	private int id;
	private String f_name;
	private String l_name;

	public Employee() {
		super();
	}

	public Employee(String f_name, String l_name) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
	}

}
