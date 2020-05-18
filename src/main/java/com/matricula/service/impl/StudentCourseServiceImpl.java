package com.matricula.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.matricula.model.entity.StudentCourse;
import com.matricula.model.repository.StudentCourseRepository;
import com.matricula.service.StudentCourseService;

public class StudentCourseServiceImpl implements StudentCourseService {

	@Autowired
	private StudentCourseRepository studentCourseRepository;
	
	@Override
	public List<StudentCourse> fetchStudentCourseBySemester(Integer semester, Long id) {
		return studentCourseRepository.fetchStudentCourseBySemester(semester, id);		
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
	public StudentCourse findById(Long id) {
		return null;
		
	}

	@Override
	public StudentCourse findByName(String name) {
		return null;
	}
/*as*/
}
