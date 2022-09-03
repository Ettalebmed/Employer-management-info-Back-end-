package com.employeemanagement;

import java.util.List;

import javax.transaction.Transactional;

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

import com.employeemanagement.model.Employee;
import com.employeemanagement.serviece.EmployeeService;

@RestController
@CrossOrigin()
@RequestMapping("/employee")

public class EmployeeRessource {
	private final EmployeeService empservice;

	public EmployeeRessource(EmployeeService empservice) {
	
		this.empservice = empservice;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = empservice.findAllEmployee();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		Employee employee= empservice.findEmployeeById(id);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee  newEmployee = empservice.addEmployee(employee);
		return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);	
		}
	
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee  updatedEmployee = empservice.updateEmployee(employee);
		return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);	
		}
	
	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
		empservice.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);	
		}
}
