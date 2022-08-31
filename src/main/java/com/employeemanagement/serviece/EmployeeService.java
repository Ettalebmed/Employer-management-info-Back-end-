package com.employeemanagement.serviece;

import java.util.List;
import java.util.UUID;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.exception.UserNotFoundException;
import com.employeemanagement.model.Employee;
import com.employeemanagement.repositry.EmployeeRepo;
@Service
public  class EmployeeService {
	
	
	private  EmployeeRepo employeerepo ;
	@Autowired
	public EmployeeService(EmployeeRepo employeerepo) {
		super();
		this.employeerepo = employeerepo;
	}
	
	
	public  Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeerepo.save(employee);
	}
	
	

	public List<Employee> findAllEmployee(){
		return employeerepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeerepo.save(employee);
		
	}
	
	
	public void deleteEmployee(Long id) {
		employeerepo.deleteEmployeeById(id);
	}
	
	
	public Employee findEmployeeById(Long id) {
		return employeerepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("no user with this id"));
				
	
	}

}
