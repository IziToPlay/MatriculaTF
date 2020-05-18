package com.matricula.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matricula.model.entity.Student;
import com.matricula.model.entity.StudentCourse;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
	
	
<<<<<<< HEAD
	@Query("select sc from StudentCourse sc where sc.enrollment.semester=?1 AND sc.student.id=student.id")
	List<StudentCourse> fetchStudentCourseBySemester(Integer semester,@Param ("student")Student student);
=======
	@Query("select sc from StudentCourse sc where sc.enrollment.semester =?1 and sc.student.id =?2")
	List<StudentCourse> fetchStudentCourseBySemester(Integer semester, Long id);
>>>>>>> fb006e2fefed77b4078c7f831fa86bb0d1dbf6cc
	
		
}
