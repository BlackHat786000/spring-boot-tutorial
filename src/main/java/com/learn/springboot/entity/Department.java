package com.learn.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Please add department name")
	@Length(min=1, max=10, message="Departmant name should be between 1 and 10 characters")
//	@Size(min=1, max=10) // same as length
//	@Email
//	@Positive
//	@Negative
//	@PositiveOrZero
//	@NegativeOrZero
//	@Future
//	@FutureOrPresent
//	@Past
//	@PastOrPresent
	private String name;
	private String address;
	private String code;
	
	/* public Department() {
		
	}

	public Department(Long id, String name, String address, String code) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", address=" + address + ", code=" + code + "]";
	} */

}
