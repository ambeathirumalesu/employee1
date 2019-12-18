package com.employeesystem.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.employeesystem.models.Employee;
import com.employeesystem.repositories.EmployeeRepository;

class EmployeeDaoTest {
	@Mock
	EmployeeRepository emprpo;
	@InjectMocks
	EmployeeDao empdao;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		
	}
	@Test
	void testGetAll() {
		Employee emp1=new Employee();
		emp1.setId(1);
		emp1.setEmail("thiru@gamil.com");
		emp1.setName("thirumalesu");
		emp1.setCompany_name("globallogic");
		Employee emp2=new Employee();
		emp2.setId(2);
		emp2.setEmail("th@gamil.com");
		emp2.setName("thiru");
		emp2.setCompany_name("globallogic");
		List<Employee> emplist=new ArrayList<Employee>();
		emplist.add(emp1);
		emplist.add(emp2);
		when(emprpo.findAll()).thenReturn(emplist);
		List<Employee> daolist=empdao.getAll();
		assertAll("employee1",
				()->{
					Employee e1=daolist.get(0);
					assertNotNull(e1);
					assertEquals(emp1.getId(), e1.getId());
					assertTrue(emp1.getEmail().equalsIgnoreCase(e1.getEmail()));
				}
				);
		assertAll("employee2",
				()->{
					Employee e2=daolist.get(1);
					assertNotNull(e2);
					assertEquals(emp2.getId(), e2.getId());
					assertTrue(emp2.getEmail().equalsIgnoreCase(e2.getEmail()));
				}
			);
	}
	

	@Test
	void testGetEmployee() {
		Employee emp1=new Employee();
		emp1.setId(1);
		emp1.setEmail("thiru@gamil.com");
		emp1.setName("thirumalesu");
		emp1.setCompany_name("globallogic");
		Optional opemp=Optional.of(emp1);
		when(emprpo.findById(1)).thenReturn(opemp);
		Employee getemp=empdao.getEmployee(1);
		//testing the result
		assertNotNull(getemp);
		assertTrue(emp1.getEmail().equalsIgnoreCase(getemp.getEmail()));
		assertEquals(emp1.getName(), getemp.getName());
	}

}
