package com.evolvus.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolvus.domain.Student;
import com.evolvus.repository.StudentRepository;

@Service
public class StudentService {

	private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAll() {
		List<Student> result = null;
		try {
			result = studentRepository.getAll();
		} catch (final Exception e) {
			StudentService.LOG.error("Exception fetching students", e);
		}
		return result;

	}

	public List<Student> getByGender(final String gender) {
		List<Student> result = null;
		try {
			result = studentRepository.getByGender(gender);
		} catch (final Exception e) {
			StudentService.LOG.error("Exception fetching students based on genTder", e);
		}
		return result;
	}

	public void save(final Student student) {
		studentRepository.save(student);
	}
}
