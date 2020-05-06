package com.evolvus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.evolvus.domain.Student;
import com.evolvus.service.LookupService;
import com.evolvus.service.StudentService;

@Controller
public class StudentController {

	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentService studentService;

	@Autowired
	private LookupService lookupService;

	@GetMapping("/form")
	public String form(final Model model) {
		StudentController.LOG.info("Begin form()  studentcontroller");
		final var genderList = lookupService.getByType("GENDER");
		model.addAttribute("genderList", genderList);
		final var students = studentService.getAll();
		model.addAttribute("students", students);
		StudentController.LOG.info("End form()  studentcontroller");
		return "student-form";
	}

	@GetMapping("/list/{gendertype}")
	public String form(final Model model, @PathVariable("gendertype") final String gendertype) {
		StudentController.LOG.info("Begin form()  studentcontroller");
		final var studentListBasedOnGender = studentService.getByGender(gendertype);
		model.addAttribute("studentListBasedOnGender", studentListBasedOnGender);
		model.addAttribute("gender", gendertype);
		StudentController.LOG.info("End form()  studentcontroller");
		return "student-data";
	}

	@PostMapping("/form/save")
	public String studentform(final Model model, @RequestParam("name") final String name,
			@RequestParam("gender") final String gender, @RequestParam("marks") final int marks) {
		StudentController.LOG.info("Begin studentform()  studentcontroller");
		final var genderList = lookupService.getByType("GENDER");
		model.addAttribute("genderList", genderList);
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		final Student su = new Student();
		su.setName(name);
		su.setGender(gender);
		su.setMarks(marks);
		studentService.save(su);
		StudentController.LOG.info("End studentform()  studentcontroller");
		return "redirect:/form";
	}
}
