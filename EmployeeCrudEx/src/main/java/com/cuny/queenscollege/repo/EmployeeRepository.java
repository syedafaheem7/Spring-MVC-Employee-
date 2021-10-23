package com.cuny.queenscollege.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cuny.queenscollege.entity.Employee;


public interface EmployeeRepository extends 
JpaRepository<Employee, Integer> {

}
