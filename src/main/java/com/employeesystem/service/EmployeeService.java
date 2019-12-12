package com.employeesystem.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeesystem.dao.EmployeeDao;
import com.employeesystem.models.Employee;
import com.employeesystem.repositories.EmployeeRepository;

import java.util.List;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao edao;
	@Autowired
	private EmployeeRepository erpo;
	
	public List getAllEmployee(){
		//Iterable<Employee> eiterable=(Iterable<Employee>) edao.getAll();
		List elist=edao.getAll();
		//eiterable.forEach(em->elist.add(em));
		
		return elist;
	}
	public String postEmployee() {
		Employee emp=new Employee();
		emp.setId(3);
		emp.setName("meena");
		emp.setEmail("meena@gmail.com");
		emp.setCompany_name("infoys");
		String result="";
		if(!erpo.existsById(emp.getId())) {
			erpo.save(emp);
			result="Employee succesully registed";
		}
		else {
			result="employee is not registed";
		}
		return result;
	}
}
