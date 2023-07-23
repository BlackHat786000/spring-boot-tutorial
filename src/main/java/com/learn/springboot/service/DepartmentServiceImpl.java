package com.learn.springboot.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springboot.entity.Department;
import com.learn.springboot.error.DepartmentNotFoundException;
import com.learn.springboot.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;

	@Override
	public Department saveDepartment(Department department) {
		return repository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		return repository.findAll();
	}

	@Override
	public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
		Optional<Department> department = repository.findById(id);
		
		if(department.isEmpty()) {
			throw new DepartmentNotFoundException("Department is not available");
		}
		
		return department.get();
	}

	@Override
	public void deleteDepartmentById(Long id) {
		repository.deleteById(id);
	}

	// get the department object by id, set this department object with new values and save()
	@Override
	public Department updateDepartmentById(Long id, Department department) {
		Department dep = repository.findById(id).get();
		
		if(Objects.nonNull(department.getName()) && !(department.getName().equals(""))) {
			dep.setName(department.getName());
		}
		
		if(Objects.nonNull(department.getAddress()) && !(department.getAddress().equals(""))) {
			dep.setAddress(department.getAddress());
		}
		
		if(Objects.nonNull(department.getCode()) && !(department.getCode().equals(""))) {
			dep.setCode(department.getCode());
		}
		
		// save() is used for both insert and update
		// If an Id is non existing then it will considered an insert if Id is existing it will be considered update
		return repository.save(dep);
	}

	@Override
	public Department getDepartmentByName(String name) {
		return repository.findByNameIgnoreCase(name);
	}

}
