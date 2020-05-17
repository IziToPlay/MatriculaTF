package com.matricula.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matricula.model.entity.StudentCourse;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
	
	
	@Query("select sc from StudentCourse sc where sc.enrollment.semester like %?1%")
	List<StudentCourse> fetchStudentCourseBySemester(Integer semester);
	
}
