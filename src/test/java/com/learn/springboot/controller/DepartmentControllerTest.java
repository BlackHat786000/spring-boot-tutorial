package com.learn.springboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.learn.springboot.entity.Department;
import com.learn.springboot.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;

	@BeforeEach
	void setUp() {
		department = Department.builder()
				.id(1L)
				.name("ME")
				.address("Ahmedabad")
				.code("ME-08")
				.build();
	}

	@Test
	void testSaveDepartment() throws Exception {
		Department inputDepartment = Department.builder()
				.name("ME")
				.address("Ahmedabad")
				.code("ME-08")
				.build();
		
		Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
		
		mockMvc.perform(post("/departments")
				.contentType(MediaType.APPLICATION_JSON)
				.content(
						"{\r\n"
						+ "  \"name\":\"ME\",\r\n"
						+ "  \"address\":\"Ahmedabad\",\r\n"
						+ "  \"code\":\"ME-08\"\r\n"
						+ "}"
				)
		).andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value("1"));
		
		// Verify that the departmentService.saveDepartment() method is called with the correct department object
//	    Mockito.verify(departmentService).saveDepartment(inputDepartment);
	}

	@Test
	void testGetDepartmentById() throws Exception {
		Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);
		
		mockMvc.perform(get("/departments/1")
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value(department.getName()));
	}

}
