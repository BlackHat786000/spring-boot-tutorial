package com.learn.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.springboot.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	public Department findByNameIgnoreCase(String name);

}
