package com.matricula.service;

import java.util.List;

import com.matricula.model.entity.StudentCourse;

public interface StudentCourseService {
	
	List<StudentCourse> fetchStudentCourseBySemester(Integer semester, Long id);
	
	StudentCourse createStudentCourse(StudentCourse studentCourse);
	
	StudentCourse updateStudentCourse(Long id, StudentCourse studentCourse);
	
	void deleteStudentCourse(Long studentCourseId);
	
	List<StudentCourse> validateCoursesStudentRegistered(Long idCourse);
	
	//void deleteCourseStudentRegistered(Long idCourse);
	
	StudentCourse findById(Long id);
	
	StudentCourse findByName(String name);

}
