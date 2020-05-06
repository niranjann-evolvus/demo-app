package com.evolvus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evolvus.domain.Student;

@Transactional
@Repository
public class StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public StudentDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Student> getAll() {
		String sql = "select * from students";
		List<Student> result = jdbcTemplate.query(sql, (rs, rn) -> {
			Student student = new Student();
			student.setStudentId(rs.getInt("STUDENT_ID"));
			student.setName(rs.getString("NAME"));
			student.setMarks(rs.getInt("MARKS"));
			student.setGender(rs.getString("GENDER"));
			return student;
		});
		return result;

	}
}
