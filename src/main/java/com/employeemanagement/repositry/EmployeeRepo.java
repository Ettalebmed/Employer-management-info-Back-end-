package com.employeemanagement.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagement.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>{

	 void deleteEmployeeById(Long id) ;//automaticly detect that this function is used to delete an emp
//	 by id

	 Optional<Employee> findEmployeeById(Long id);
		
		
	

}
