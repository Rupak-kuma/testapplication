package com.employee.system.services;

import java.sql.SQLException;
import java.util.List;

import com.employee.system.exception.IdNotFoundException;
import com.employee.system.model.Employee;





    public interface IEmployeeServices {
	public  List<Employee> displayEmployee();
	public Employee  addEmployee(Employee emp) throws IdNotFoundException, SQLException;
	public boolean deleteEmployee(int id) throws IdNotFoundException, SQLException;
	public Employee searchById(int idr) throws IdNotFoundException;

    public Employee updateEmployee(int id,Employee e) throws IdNotFoundException, SQLException;


}
