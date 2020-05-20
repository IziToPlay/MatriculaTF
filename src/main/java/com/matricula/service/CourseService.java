package com.matricula.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.matricula.model.entity.Course;
import com.matricula.model.entity.Professor;

public interface CourseService {

	List<Course> getAllCourses();
	
	List<Course> findCourseOnStudentCourses();
		
	//List<String> getAllCoursesToSearch();
	
	Course createCourse(Course course);
	
	Course updateCourse(Long id, Course course);
	
	void deleteCourse(Long courseId);
	
	Course findById(Long id);
	
	Course getLatestEntry();

    //List<Course> findByName(String name);
	
	List<Course> findByName(String name);
    
    List<Course> findCoursesAvailables();
          
    //Page<Course> findCoursesAvailables(Pageable pageable);

}
