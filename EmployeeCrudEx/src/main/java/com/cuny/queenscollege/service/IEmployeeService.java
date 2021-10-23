package com.cuny.queenscollege.service;

import java.util.List;

import com.cuny.queenscollege.entity.Employee;



public interface IEmployeeService {
	Integer saveEmployee(Employee employee);
	
	void deleteEmployee(Integer id);
	List<Employee> getAllEmployees();
	Employee getOneEmployee(Integer id);
	void updateEmployee(Employee employee);

}
