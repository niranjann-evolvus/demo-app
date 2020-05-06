package com.evolvus.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table("STUDENTS")
@Data
public class Student {

	@Id
	private int studentId;
	private String name;
	private String gender;
	private int marks;
}
