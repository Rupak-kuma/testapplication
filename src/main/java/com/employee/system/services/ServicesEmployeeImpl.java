package com.employee.system.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.system.exception.IdNotFoundException;
import com.employee.system.model.Employee;
import com.employee.system.repository.EmployeeDAO;





@Service
public class ServicesEmployeeImpl implements IEmployeeServices{
	
@Autowired
private EmployeeDAO dao;



public Employee addEmployee(Employee emp) throws IdNotFoundException {
	if(!dao.findById(emp.getId()).isPresent())

  return dao.save(emp);
	else 
		throw new IdNotFoundException("Enter Id is not exist");
}
	
	public  List<Employee> displayEmployee(){
		
		return dao.findAll();
		}
	
	
	public Employee searchById(int id) throws IdNotFoundException {
		if(dao.findById(id).isPresent())
			return dao.findById(id).get();
		else
			throw new IdNotFoundException("Enter Id is not exist");
	}
	

	public boolean deleteEmployee(int id) throws IdNotFoundException,SQLException {
		
		if(dao.findById(id).isPresent()) {
			dao.deleteById(id);
			return true;
		}
		
		else 
			throw new IdNotFoundException("Enter Id is not exist");
		
	}
	public Employee updateEmployee(int id,Employee emp) throws IdNotFoundException, SQLException {

		if(dao.findById(id).isPresent())
			return dao.saveAndFlush(emp);
		else
			throw new IdNotFoundException("Enter Id is not exist");
	}

	
	
}