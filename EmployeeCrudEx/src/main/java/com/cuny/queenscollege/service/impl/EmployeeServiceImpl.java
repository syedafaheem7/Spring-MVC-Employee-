package com.cuny.queenscollege.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cuny.queenscollege.entity.Employee;
import com.cuny.queenscollege.repo.EmployeeRepository;
import com.cuny.queenscollege.service.IEmployeeService;
import org.springframework.stereotype.Service;



@Service
public class EmployeeServiceImpl  implements IEmployeeService{
	
	@Autowired   //anotation for association
	private EmployeeRepository repo; //has a

	@Override
	public Integer saveEmployee(Employee employee) {
		employee = repo.save(employee);
		return employee.getId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List <Employee> list = repo.findAll();
		
		return list;
	}
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
	}
	
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt = repo.findById(id);
		if(opt.isPresent()) {
			Employee e = opt.get();
			return e;
		}
		// TODO : else throw exception Employee not found
		return null;
	}
	
	public void updateEmployee(Employee e) {
		repo.save(e);
	}
	

}
