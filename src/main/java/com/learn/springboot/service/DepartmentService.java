package com.learn.springboot.service;

import java.util.List;

import com.learn.springboot.entity.Department;
import com.learn.springboot.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> getAllDepartments();

	public Department getDepartmentById(Long id) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long id);

	public Department updateDepartmentById(Long id, Department department);

	public Department getDepartmentByName(String name);

}
