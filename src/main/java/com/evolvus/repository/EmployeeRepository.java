package com.evolvus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evolvus.domain.Employee;

@Transactional
@Repository
public class EmployeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public EmployeeRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Employee> findAll() {
		String sql = "select * from employee";
		List<Employee> result = jdbcTemplate.query(sql, (rs, rn) -> {
			Employee employee = new Employee();
			employee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
			employee.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
			employee.setSalary(rs.getInt("SALARY"));
			return employee;
		});
		return result;

	}

	public void save(Employee employee) {
		String sql = "Insert into employee " + "(EMPLOYEE_NAME, SALARY) values(?,?)";
		jdbcTemplate.update(sql, new Object[] { employee.getEmployeeName(), employee.getSalary() });
	}
}
