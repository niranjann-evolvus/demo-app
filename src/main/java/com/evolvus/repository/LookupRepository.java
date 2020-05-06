package com.evolvus.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.evolvus.domain.Lookup;

@Repository
public interface LookupRepository extends CrudRepository<Lookup, Integer> {

	@Query("Select * from lookup where lookup_type=:lookupType")
	List<Lookup> getByType(@Param("lookupType") String lookupType);
}
