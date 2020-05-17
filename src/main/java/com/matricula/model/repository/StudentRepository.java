package com.matricula.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matricula.model.entity.Student;


@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
	
	/**
     * @return newest articleId
     */
	@Query(value = "SELECT MAX(id) FROM Incident")
    Long findTopByOrderByIdDesc();
	
	
	/**
     * @param pageable
     * @return          a page of entities that fulfill the restrictions
     *                  specified by the Pageable object
     */
	Page<Student> findAll(Pageable pageable);

	@Query("SELECT s FROM Student s WHERE s.id like %?1%")
	Page<Student> finById(String id,Pageable pageable);
}