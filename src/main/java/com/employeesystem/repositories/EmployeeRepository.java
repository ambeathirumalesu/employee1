package com.employeesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.employeesystem.models.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
}
