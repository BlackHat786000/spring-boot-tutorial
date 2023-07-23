package com.learn.springboot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.learn.springboot.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() {
		Department department = Department.builder()
				.name("Mechanical Engineering")
				.address("Ahmedabad")
				.code("ME-04")
				.build();
		entityManager.persist(department);
	}

	@Test
	void whenFindById_ThenReturnDepartment() {
		Department department = repository.findById(1L).get();
		assertEquals("Mechanical Engineering", department.getName());
	}

}
