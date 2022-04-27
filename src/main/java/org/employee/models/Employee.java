package org.employee.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private long employeeId;
	private String employeeName;
	private String employeeCity;
	private double employeeSalary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(long employeeId, String employeeName, String employeeCity, double employeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeCity = employeeCity;
		this.employeeSalary = employeeSalary;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeCity() {
		return employeeCity;
	}
	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeCity="
				+ employeeCity + ", employeeSalary=" + employeeSalary + "]";
	}
	
	

}
