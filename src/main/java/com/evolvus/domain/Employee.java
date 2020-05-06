package com.evolvus.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Employee {

	@Id
	private int employeeId;
	private String employeeName;
	private long salary;
}
