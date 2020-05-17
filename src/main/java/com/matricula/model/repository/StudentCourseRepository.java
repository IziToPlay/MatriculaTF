package com.matricula.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matricula.model.entity.StudentCourse;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
	/*
	@Query("select t from Trip t where t.dptDeparture.name like %?1% and t.dptArrival.name like %?2% and t.startDate like %?3%")
	List<Trip> fetchTripByDpt(String dptDeparture,String dptArrival, String startDate);
	
	@Query("select t from Trip t where t.dptArrival like %?1%")
	List<Trip> fetchTripByDptArrival(String dptArrival);
	*/
	
	@Query("select sc from StudentCourse sc where sc.enrollment.semester like %?1%")
	List<StudentCourse> fetchStudentCourseBySemester(Integer semester);
	
}
