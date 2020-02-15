package com.project.king1.dao;

import com.project.king1.model.Employee;
import java.util.List;


public interface EmployeeDAO {
	
	// for returning list of employee
	List<Employee> get();

	//for returning single employee
	Employee get(int id);
	
	// we can save the employee
	void save(Employee employee);
	
	//we can delete the specific employee
	void delete(int id);
	
	
	
}