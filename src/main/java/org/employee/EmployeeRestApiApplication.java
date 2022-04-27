package org.employee;

import org.employee.repository.EmployeeRepository;
import org.employee.service.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
public class EmployeeRestApiApplication {
	

	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestApiApplication.class, args);
		
	    
	}

}

