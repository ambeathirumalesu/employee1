package com.employeesystem.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.employeesystem.models.Employee;
import com.employeesystem.repositories.EmployeeRepository;
import com.employeesystem.service.EmployeeService;

import java.util.List;
@RestController
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService eservice;
	

	
	@RequestMapping(value="/getallemployees",method=RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return  eservice.getAllEmployee();
	}
	
	@RequestMapping(value="/postemployee",method = RequestMethod.POST)
	public String postEmployee() {
		return eservice.postEmployee();
	}
}
