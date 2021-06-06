package com.employee.system.controller;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.system.exception.IdNotFoundException;
import com.employee.system.model.Employee;
import com.employee.system.services.IEmployeeServices;


@RestController

@RequestMapping("/api")
public class EmployeeController {

	
	@Autowired
	private IEmployeeServices service;


	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> displayEmployee() {
		//List<Employee> list = service.displayEmployee();
			
		return new ResponseEntity<List<Employee>>(service.displayEmployee(),HttpStatus.OK);
	}
	

		@PostMapping("/addEmployee")
		public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) throws IdNotFoundException, SQLException {
			return new ResponseEntity<Employee>(service.addEmployee(emp),HttpStatus.OK);
			
			
		
	}
		@GetMapping("/searchEmployee/{id}")
		public ResponseEntity<Employee>  searchEmployee(@PathVariable int id) throws IdNotFoundException{
			//List<Employee> l = new ArrayList<Employee>();
			return new ResponseEntity<Employee>(service.searchById(id),HttpStatus.OK);
		
			
		}
		@PutMapping("/updateEmployee/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee e) throws IdNotFoundException, SQLException  {
			return new ResponseEntity<Employee>(service.updateEmployee(id,e),HttpStatus.OK);
		}
		
		
		@DeleteMapping("/deleteEmployee/{id}")
		public ResponseEntity<Boolean> deleteEmployee(@PathVariable int id) throws IdNotFoundException, SQLException {
			return new ResponseEntity<Boolean>(service.deleteEmployee(id),HttpStatus.OK);
	}
	}