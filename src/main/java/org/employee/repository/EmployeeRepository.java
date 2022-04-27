package org.employee.repository;

import java.util.Collection;
import java.util.List;

import org.employee.models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>
{
	
	//Equality Condition Keywords
	List<Employee> findByemployeeName(String name);
	List<Employee> findByemployeeNameIs(String name);
	List<Employee> findByemployeeNameEquals(String name);
	List<Employee> findByemployeeNameIsNot(String name);
	List<Employee> findByemployeeNameIsNotNull();
	List<Employee> findByemployeeNameIsNull();
	
	
	//Similarity Condition Keywords
	
	List<Employee> findByemployeeNameStartingWith(String prefix);
	List<Employee> findByemployeeNameEndingWith(String suffix);
	List<Employee> findByemployeeNameContaining(String infix);
	
	
	//Comparison Condition Keywords
	
	List<Employee> findByemployeeSalaryLessThan(Double salary);
	List<Employee> findByemployeeSalaryLessThanEqual(Double salary);
	List<Employee> findByemployeeSalaryGreaterThan(Double salary);
	List<Employee> findByemployeeSalaryGreaterThanEqual(Double salary);
	List<Employee> findByemployeeSalaryBetween(Double startSalary, Double endSalary);
	List<Employee> findByemployeeSalaryIn(Collection<Double> ages);
	
	//Date condition keywords
	//List<User> findByBirthDateAfter(ZonedDateTime birthDate);
	//List<User> findByBirthDateBefore(ZonedDateTime birthDate);
	
	
	// Multiple Condition Expressions
	//List<Employee> findByemployeeNameOremployeeCity(String name,String city );
	
	
	//Sorting the Results
	
	//List<Employee> findByemployeeNameOrderByemployeeName(String name);
	//List<Employee> findByemployeeSalaryOrderByemployeeSalaryAsc(Double salary);
    
	
	//JPQL
	@Query("select e FROM Employee e")
	public List<Employee> getAllEmployee();
	
	
	@Query(value="select e FROM Employee e where e.employeeName= :name")
	public List<Employee> getEmployeeByName(@Param("name") String name);
	
	
	@Query("select e FROM Employee e where e.employeeName= :name and e.employeeCity= :city")
	public List<Employee> getEmployeeByName(@Param("name") String name,@Param("city") String city);
	
	@Query(value="select * FROM Employee",nativeQuery=true)
	public List<Employee> getEmployees();
	
}
