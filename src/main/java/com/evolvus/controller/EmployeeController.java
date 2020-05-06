package com.evolvus.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.evolvus.domain.Employee;
import com.evolvus.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping("/employee-list")
	public String employees(Model model) {
		LOG.info("Employee Controller ");
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		LOG.info("Employee Controller ", employees);
		return "employee-data";

	}

	@PostMapping("/employee-form/save")
	public String studentform(final Model model, @RequestParam("employeeName") final String employeeName,
			@RequestParam("salary") final String salary) {
		EmployeeController.LOG.info("Begin employeeform() ----> employeeController");
		final Employee employee = new Employee();
		employee.setEmployeeName(employeeName);
		employee.setSalary(Long.parseLong(salary));
		employeeService.save(employee);
		EmployeeController.LOG.info("End employeeform() ----> employeeController");
		return "redirect:/employee-list";
	}

}
