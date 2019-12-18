package com.employeesystem.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.employeesystem.dao.EmployeeDao;
import com.employeesystem.models.Employee;
import com.employeesystem.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;
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
	public Employee postEmployee(Employee emp) {
		/*
		 * Employee emp=new Employee(); emp.setId(4); emp.setName("charan");
		 * emp.setEmail("charan@gmail.com"); emp.setCompany_name("infoys");
		 */
<<<<<<< HEAD
		//System.out.println("empservice entered");
=======
<<<<<<< HEAD
		//System.out.println("empservice entered");
=======
		System.out.println("empservice entered");
>>>>>>> 13410f3b72eee15241386d28bdc81dcd61735e5b
>>>>>>> e98d030e731edc1c483f653c8ed8cc75504c9ce4
		if(!erpo.existsById(emp.getId())) {
			erpo.save(emp);
			
		}
		return emp;
<<<<<<< HEAD
	
	}
	public Employee putEmployee(Employee emp) {
		erpo.save(emp);
		return emp;
=======
>>>>>>> e98d030e731edc1c483f653c8ed8cc75504c9ce4
	}
	public Employee getEmployee(int id) {
		Employee emp=null;
		if(erpo.existsById(id)) {
		 emp=edao.getEmployee(id);
<<<<<<< HEAD
		}
		return emp;
	}
	public List getsomeEmployee(int from,int to) {
		List l=(List) erpo.findAll();
		
		List<Employee> someemp=(List) l.stream().filter(emp->(((Employee) emp).getId()>=from && ((Employee) emp).getId()<=to)).collect(Collectors.toList());
		//System.out.println(someemp);
		return someemp;
	}
	public void deleteEmployee(Employee emp) {
		if(erpo.existsById(emp.getId())) {
				erpo.delete(emp);
			
		}
=======
		}
		return emp;
	}
	public List getsomeEmployee(int from,int to) {
		List l=(List) erpo.findAll();
		
		List<Employee> someemp=(List) l.stream().filter(emp->(((Employee) emp).getId()>=from && ((Employee) emp).getId()<=to)).collect(Collectors.toList());
		//System.out.println(someemp);
		return someemp;
>>>>>>> e98d030e731edc1c483f653c8ed8cc75504c9ce4
	}
}
