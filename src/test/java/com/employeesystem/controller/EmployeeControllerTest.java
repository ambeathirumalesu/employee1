package com.employeesystem.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;

import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.employeesystem.controller.EmployeeController;
import com.employeesystem.dao.EmployeeDao;
import com.employeesystem.employeesystem.EmployeesystemApplication;
import com.employeesystem.models.Employee;
import com.employeesystem.repositories.EmployeeRepository;
import com.employeesystem.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minidev.json.JSONObject;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {com.employeesystem.controller.EmployeeController.class})
class EmployeeControllerTest {
	
	@InjectMocks
	EmployeeController empcontroller;
	@Mock
	EmployeeService empservice;
	@Mock
	EmployeeRepository emprpo;
	
	private MockMvc mockmvc;
	
	
	@BeforeEach
	public void init() {
		
		MockitoAnnotations.initMocks(this);
		EmployeeController employeeController=new EmployeeController(empservice);
		mockmvc=MockMvcBuilders.standaloneSetup(employeeController).build();			
	}
	
	@Test
	void getAllEmployee() throws Exception {
		//EmployeeControllerTest empt=new EmployeeControllerTest();
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
		//when
		when(empservice.getAllEmployee()).thenReturn(emplist);
		//Calling service method
		List<Employee> empcolist=empservice.getAllEmployee();
		System.out.println(empcolist.toString());
		//when
		//when(empcontroller.getAllEmployees()).thenReturn(empcolist);
		
		//calling Restcontroller method
		RequestBuilder request=MockMvcRequestBuilders.get("/getallemployees").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockmvc.perform(request).andExpect(status().isOk()).andReturn();
		Gson g=new Gson();
		//assertEquals(emplist.size(), );
		String  strresult=result.getResponse().getContentAsString();
		
		List list=g.fromJson(strresult, List.class);
		
		assertAll("e1",
				()->{
					
					Employee e1=g.fromJson(list.get(0).toString(),Employee.class);
					assertNotNull(e1);
					assertTrue(emp1.getId()==e1.getId());
					assertEquals(emp1.getEmail(),e1.getEmail());
					assertTrue(emp1.getCompany_name().equalsIgnoreCase(e1.getCompany_name()));
				},
				()->{
					
					Employee e2=g.fromJson(list.get(1).toString(),Employee.class);
					assertNotNull(e2);
					assertTrue(emp2.getId()==e2.getId());
					assertEquals(emp2.getEmail(),e2.getEmail());
					assertTrue(emp2.getCompany_name().equalsIgnoreCase(e2.getCompany_name()));
				}
		);	
		
	}
	@Test
	public void getEmployee() throws Exception {
		Employee emp=new Employee();
		emp.setId(7);
		emp.setName("priya kumari");
		emp.setEmail("priya@gmail.com");
		emp.setCompany_name("globallogic");
		when(empservice.getEmployee(7)).thenReturn(emp);
		RequestBuilder request=MockMvcRequestBuilders.get("/getemployee").param("id","7").accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockmvc.perform(request).andExpect(status().isOk()).andReturn();
		String strresult=result.getResponse().getContentAsString();
		Gson g=new Gson();
		Employee expected=g.fromJson(strresult, Employee.class);
		
		//test
		assertAll("expected",
				()->{assertNotNull(expected);},
				()->{assertEquals(expected.getEmail(), emp.getEmail());},
				()->{assertEquals(expected.getCompany_name(), emp.getCompany_name());}
		);
	}
	//Test case for the postEmployee using requestbody josn object 
	@Test
	void postEmployee() throws Exception {
		
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> e98d030e731edc1c483f653c8ed8cc75504c9ce4
		Employee empSaved=new Employee();
		empSaved.setName("priya kumari");
		empSaved.setEmail("priya@gmail.com");
		empSaved.setCompany_name("globallogic");
		empSaved.setId(7);
		
<<<<<<< HEAD
=======
=======
		Employee emp=new Employee();
		emp.setId(7);
		emp.setName("priya kumari");
		emp.setEmail("priya@gmail.com");
		emp.setCompany_name("globallogic");
		Gson g=new Gson();
		String jsons=g.toJson(emp);
		when(empservice.postEmployee(emp)).thenReturn(emp);
>>>>>>> 13410f3b72eee15241386d28bdc81dcd61735e5b
>>>>>>> e98d030e731edc1c483f653c8ed8cc75504c9ce4
		
		//System.out.println(jsons);
		/* ObjectMapper mapper = new ObjectMapper();
		    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		    String requestJson=ow.writeValueAsString(emp);*/
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> e98d030e731edc1c483f653c8ed8cc75504c9ce4
		when(empservice.postEmployee(Mockito.any(Employee.class))).thenReturn(empSaved);

		RequestBuilder request=MockMvcRequestBuilders.post("/posthello").contentType(MediaType.APPLICATION_JSON).content(asJsonString(empSaved));
		MvcResult result=mockmvc.perform(request).andExpect(status().isCreated()).andReturn();
		String stresult=result.getResponse().getContentAsString();
		Gson g=new Gson();
		Employee expected=g.fromJson(stresult, Employee.class);
		
	
		assertAll("acuval",
				()->{assertNotNull(expected);},
				()->{assertEquals(expected.getEmail(),empSaved.getEmail());},
				()->{assertTrue(expected.getId()==empSaved.getId());},
				()->{assertTrue(expected.getCompany_name().equalsIgnoreCase(empSaved.getCompany_name()));}
		
				);
	}
	
	private String asJsonString(final Object obj) {
		try {
		return new ObjectMapper().writeValueAsString(obj);
		}
		catch(Exception e) {
			throw  new RuntimeException(e);
		}
	}
<<<<<<< HEAD
	//test case for the putemployee method employee controller class
	@Test
	public void putEmployee()throws Exception{
		Employee emp=new Employee();
		emp.setId(7);
		emp.setName("priya kumari");
		emp.setEmail("priya@gmail.com");
		emp.setCompany_name("globallogic");
		when(empservice.putEmployee(Mockito.any(Employee.class))).thenReturn(emp);
		RequestBuilder request=MockMvcRequestBuilders.put("/putemployee").content(asJsonString(emp)).contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockmvc.perform(request).andExpect(status().isOk()).andReturn();
		Gson g=new Gson();
		Employee expected=g.fromJson(result.getResponse().getContentAsString(), Employee.class);
		
		assertNotNull(expected);
		assertAll("expected",
				
				()->{assertTrue(expected.getId()==emp.getId());},
				()->{assertEquals(expected.getEmail(), emp.getEmail());}
				
				);
		
	}

	@Test
	public void helloworld() throws Exception{
		
=======

=======
		
		RequestBuilder request=MockMvcRequestBuilders.post("/posthello").contentType(MediaType.APPLICATION_JSON).content(jsons);
		MvcResult result=mockmvc.perform(request).andExpect(status().isOk()).andReturn();
		String stresult=result.getResponse().getContentAsString();
		
		System.out.println(g.fromJson(stresult, Employee.class));
		
		Employee acuval=g.fromJson(stresult, Employee.class);
		System.out.println(acuval);
	/*	assertAll("acuval",
				()->{assertNotNull(acuval);},
				()->{assertEquals(acuval.getEmail(),emp.getEmail());},
				()->{assertTrue(acuval.getId()==emp.getId());},
				()->{assertTrue(acuval.getCompany_name().equalsIgnoreCase(emp.getCompany_name()));}
		
				
				);
		*/
		
		
	}
	
>>>>>>> 13410f3b72eee15241386d28bdc81dcd61735e5b
	@Test
	public void helloworld() throws Exception{
		

//		RequestBuilder request=mock.get("/helloworld").accept(MediaType.APPLICATION_JSON);
//		MvcResult result=mockmvc.perform(request).andReturn();
//		assertEquals("hello world", result.getResponse().getContentAsString());
>>>>>>> e98d030e731edc1c483f653c8ed8cc75504c9ce4
		MvcResult result= mockmvc.perform(MockMvcRequestBuilders.get("/helloworld")).andReturn();
		assertEquals("hello world", result.getResponse().getContentAsString());
		
	}
	
	

}
