package com.evolvus.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.evolvus.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query("Select * from students")
	List<Student> getAll();

	@Query("Select * from students where gender=:gender")
	List<Student> getByGender(@Param("gender") String gender);

}
