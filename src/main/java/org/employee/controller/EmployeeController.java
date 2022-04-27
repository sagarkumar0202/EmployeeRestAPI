package org.employee.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.employee.exception.idNotFoundException;
import org.employee.models.Employee;
import org.employee.repository.EmployeeRepository;
import org.employee.service.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController 
{
 
	@Autowired
	EmployeeServiceImplementation dao;
	
	@Autowired
	EmployeeRepository repo;
	
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		HttpHeaders header=new HttpHeaders();
		header.add("projectname", "EmployeeRestAPI");
		
		List<Employee> elist=(List<Employee>)dao.findAllEmployee();
		
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(elist);
		
		
	}
	
	@PostMapping("/addemployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee )
	{
		dao.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).header("project", "EmployeeREST API").body("Employee record added!!");
	}
	
	@GetMapping("/getemployee/{id}")
	public Employee getEmployeeById(@PathVariable long id) throws idNotFoundException
	{
		Employee e=dao.getEmployeeById(id);
		if(e!=null)
		{
		return e;
		}
		else
		{
			throw new idNotFoundException("Wrong employee Id!!");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable long id)throws EmptyResultDataAccessException
	{
		dao.deleteById(id);
		return "record deleted!!";
	}
	
	@PutMapping("/update/{id}")
	public String update(@RequestBody Employee employee,@PathVariable long id)throws NoSuchElementException,HttpMessageNotReadableException 
	{
		dao.update(employee, id);
		return "record updated";
	}
	
	
	  @GetMapping("/getbyname") 
	  public List<Employee> getEmployeeByName(@RequestParam("name") String name) 
	  { 
		 return repo.findByemployeeName(name); 
		 }
	 
	
}
