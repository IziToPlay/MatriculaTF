package com.matricula.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matricula.model.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
	
	@Query("SELECT e FROM Enrollment e WHERE e.semester=?1")
	Enrollment findBySemester(Integer semester);
}

