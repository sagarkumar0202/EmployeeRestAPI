package org.employee.service;

import java.util.List;
import java.util.Optional;

import org.employee.models.Employee;
import org.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	EmployeeRepository erepo;
	
	@Override
	public List<Employee> findAllEmployee() {
		
		return (List<Employee>)erepo.findAll();
	}

	@Override
	public void addEmployee(Employee employee) {
		
		erepo.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> e=erepo.findById(id);
		
		if(e.isPresent())
		{
		    return e.get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public void deleteById(long id) {
	
		erepo.deleteById(id);
		
	}

	@Override
	public Employee update(Employee employee, long id) {
		
		Optional<Employee> e=erepo.findById(id);
		Employee emp=e.get();
		
		emp.setEmployeeCity(employee.getEmployeeCity());
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setEmployeeSalary(employee.getEmployeeSalary());
		
		erepo.save(emp);
		
		return emp;
	}

	

}
