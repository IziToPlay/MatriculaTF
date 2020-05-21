package com.matricula.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matricula.model.entity.Account;
import com.matricula.model.entity.Student;
import com.matricula.model.entity.StudentCourse;
import com.matricula.model.repository.StudentCourseRepository;
import com.matricula.model.repository.StudentRepository;
import com.matricula.service.StudentCourseService;
import com.matricula.service.UserService;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	@Autowired
	private StudentCourseRepository studentCourseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public List<StudentCourse> fetchStudentCourseBySemester(Integer semester) {
		
		Account account=userService.getLoggedUser();
		Student student=studentRepository.findStudentByAccount(account.getId());
		
		//Student student = studentRepository.findStudentByAccount(id);
		return studentCourseRepository.fetchStudentCourseBySemester(semester, student.getId());		
	}
	
	
	@Override
	public StudentCourse createStudentCourse(StudentCourse studentCourse) {
		StudentCourse newStudentCourse;
		newStudentCourse = studentCourseRepository.save(studentCourse);
		return newStudentCourse;
	}

	@Override
	public StudentCourse updateStudentCourse(Long id, StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		
		StudentCourse newStudentCourse = findById(id);
		newStudentCourse.setCourse(studentCourse.getCourse());
		newStudentCourse.setEnrollment(studentCourse.getEnrollment());
		newStudentCourse.setStudent(studentCourse.getStudent());
		studentCourseRepository.save(newStudentCourse);
		return null;
	}
	
	@Override
	public void deleteStudentCourse(Long studentCourseId) {
		studentCourseRepository.deleteById(studentCourseId);
	}
	
	@Override
	public List<StudentCourse> validateCoursesStudentRegistered(Long idCourse) {
		Account account=userService.getLoggedUser();
		Student student=studentRepository.findStudentByAccount(account.getId());
		//Student student = studentRepository.findStudentByAccount(idAccount);
		return studentCourseRepository.CourseStudentRegistered(idCourse, student.getId());
	}
	
	@Override
	public StudentCourse findById(Long id) {
		return studentCourseRepository.fetchById(id);
		
	}

	@Override
	public StudentCourse findByName(String name) {
		return null;
	}

}
