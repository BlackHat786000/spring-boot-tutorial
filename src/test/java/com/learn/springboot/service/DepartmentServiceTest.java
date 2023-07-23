package com.learn.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.learn.springboot.entity.Department;
import com.learn.springboot.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository repository;

	@BeforeEach
	void setUp() {
		Department department = Department.builder()
				.id(1l)
				.name("IT")
				.address("Mumbai")
				.code("IT-09")
				.build();
		
		Mockito.when(repository.findByNameIgnoreCase("IT")).thenReturn(department);
	}

	@Test
	@DisplayName("find dept on basis of valid dept name")
//	@Disabled
	void whenValidDeptName_ThenDeptShouldFound() {
		String deptName = "IT";
		Department found = departmentService.getDepartmentByName("IT");
		
		assertEquals(deptName, found.getName());
	}

}
