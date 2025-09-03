package com.debasish.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	private Long id;
	private String name;
	private String email;
	private double age;
	private String department;
}
