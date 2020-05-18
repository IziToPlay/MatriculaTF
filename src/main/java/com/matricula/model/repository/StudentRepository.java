package com.matricula.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matricula.model.entity.Account;
import com.matricula.model.entity.Course;
import com.matricula.model.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	/**
     * @return newest articleId
     */
	@Query(value = "SELECT MAX(id) FROM Student")
    Long findTopByOrderByIdDesc();
	
	
	/**
     * @param pageable
     * @return          a page of entities that fulfill the restrictions
     *                  specified by the Pageable object
     */
	List<Student> findAll();

	@Query("SELECT s FROM Student s WHERE s.id=?1")
	Student fetchById(Long id);
	
	@Query("SELECT s FROM Student s WHERE s.id=?1")
	List<Student> fetchhById(Long id);
	
	 @Query("SELECT s FROM Student s WHERE s.account.id=?1")
	 Student findStudentByAccount(Long accountId);
}