package com.learn.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot.entity.Department;
import com.learn.springboot.error.DepartmentNotFoundException;
import com.learn.springboot.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	// Create
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Request body = "+department);
		LOGGER.info("Inside saveDepartment() method of DepartmentController class");
		return departmentService.saveDepartment(department);
	}
	
	// Read
	@GetMapping("/departments")
	public List<Department> getAllDepartments() {
		LOGGER.info("Inside getAllDepartments() method of DepartmentController class");
		return departmentService.getAllDepartments();
	}
	
	// Read specific
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		Department department = departmentService.getDepartmentById(departmentId);
		LOGGER.info("Department object = "+department);
		return department;
	}
	
	// Update
	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartmentById(departmentId, department);
	}
	
	// Delete
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted successfully";
	}
	
	@GetMapping("/departments/name/{name}")
	public Department getDepartmentByName(@PathVariable("name") String departmentName) {
		Department department = departmentService.getDepartmentByName(departmentName);
		LOGGER.info("Department object = "+department);
		return department;
	}

}
