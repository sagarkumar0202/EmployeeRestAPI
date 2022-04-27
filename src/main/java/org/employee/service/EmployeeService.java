package org.employee.service;

import java.util.List;

import org.employee.models.Employee;

public interface EmployeeService {
	
	List<Employee> findAllEmployee();
	void addEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteById(long id);
	Employee update(Employee employee,long id);
	
}
