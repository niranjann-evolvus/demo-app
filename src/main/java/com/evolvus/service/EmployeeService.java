package com.evolvus.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolvus.domain.Employee;
import com.evolvus.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	public List<Employee> findAll() {

		List<Employee> result = null;
		try {
			result = employeeRepository.findAll();
		} catch (Exception e) {
			LOG.error("Exception fetching employees {}", e);
		}
		return result;
	}

	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

}
