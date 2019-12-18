package com.employeesystem.controller;

import java.util.ArrayList;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
=======
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
=======
>>>>>>> 13410f3b72eee15241386d28bdc81dcd61735e5b
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> e98d030e731edc1c483f653c8ed8cc75504c9ce4
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.employeesystem.models.Employee;
import com.employeesystem.models.UserNotFoundException;
import com.employeesystem.repositories.EmployeeRepository;
import com.employeesystem.service.EmployeeService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeController 
{
<<<<<<< HEAD
	
	
	private EmployeeService eservice;
	
	
=======
<<<<<<< HEAD
	
	
=======
	

>>>>>>> 13410f3b72eee15241386d28bdc81dcd61735e5b
	private EmployeeService eservice;
>>>>>>> e98d030e731edc1c483f653c8ed8cc75504c9ce4

	@RequestMapping(value="/getallemployees",method=RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return  eservice.getAllEmployee();
	}
	
	/*
	 * @RequestMapping(value="/postemployee",method = RequestMethod.POST) public
	 * String postEmployee() { return eservice.postEmployee(); }
	 */
	@GetMapping(value="/getemployee")
	public Employee getemployee(@RequestParam("id") int id) {
		Employee emp=eservice.getEmployee(id);
		if(emp==null) {
			throw new UserNotFoundException("employee is not found");
		}
		
		return emp;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> e98d030e731edc1c483f653c8ed8cc75504c9ce4
	}
	@GetMapping(value="/getsomeemployee")
	public List<Employee> getsomeemployee(@RequestParam("from") int from,@RequestParam int to) {
		
		
		return eservice.getsomeEmployee(from, to);
<<<<<<< HEAD
	}
	@PostMapping(value="/posthello",consumes = MediaType.APPLICATION_JSON_VALUE,produces ="application/json")
	 public ResponseEntity<Object> postResponseController(
		      @RequestBody Employee emp) {
		System.out.println("controlled executed");
		Employee e=eservice.postEmployee(emp);
	        return new ResponseEntity<Object>(e,HttpStatus.CREATED);
	}
	//deleting employee object
	@DeleteMapping("/delete")
	public ResponseEntity<Object> deleteEmployee(@RequestBody Employee emp){
		
		eservice.deleteEmployee(emp);
		return ResponseEntity.noContent().build();
	}
	//updating or creating the employee object using put method
	@PutMapping("/putemployee")
	public ResponseEntity<Object> putEmployee(@RequestBody Employee emp){
		Employee e=eservice.putEmployee(emp);
		
		return new ResponseEntity<Object>(e,HttpStatus.OK);
	}
	
	
=======
	}
	@PostMapping(value="/posthello",consumes = MediaType.APPLICATION_JSON_VALUE,produces ="application/json")
	 public ResponseEntity<Object> postResponseController(
		      @RequestBody Employee emp) {
		System.out.println("controlled executed");
		Employee e=eservice.postEmployee(emp);
	        return new ResponseEntity<Object>(e,HttpStatus.CREATED);
=======
	}
	@GetMapping(value="/getsomeemployee")
	public List<Employee> getsomeemployee(@RequestParam("from") int from,@RequestParam int to) {
		
		
		return eservice.getsomeEmployee(from, to);
	}
	@PostMapping(value="/posthello",consumes = MediaType.APPLICATION_JSON_VALUE,produces ="application/json")
	 public Employee postResponseController(
		      @RequestBody Employee emp) {
		System.out.println("controlled executed");
		//Employee e=;
	        return eservice.postEmployee(emp) ;
>>>>>>> 13410f3b72eee15241386d28bdc81dcd61735e5b
	}
>>>>>>> e98d030e731edc1c483f653c8ed8cc75504c9ce4
	@GetMapping(value="/helloworld")
	public String helloworld() {
		
		return "hello world";
	}
	
}
