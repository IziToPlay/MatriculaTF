
package com.matricula.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.matricula.model.entity.Account;
import com.matricula.model.entity.Student;

public interface StudentService {

	List<Student> getAllStudent();
	Student createStudent(Student student);
	Student updateStudent(Long id, Student student);
	void deleteStudent(Long incidentId);
	Student findById(Long id);
	Student getLatestEntry();
    List<Student> findAll();
 /*Encontrar cuenta de estudiante*/Student findStudentByAccount(Account account);
    List<Student> finById(Long Id);
	/*
	Incident getLatestEntry();
	*/
	//boolean valid(Student student);
	

}