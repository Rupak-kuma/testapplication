package com.employee.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.system.model.Employee;



@Repository
public interface EmployeeDAO extends JpaRepository<Employee,Integer >{
	
	
	
}