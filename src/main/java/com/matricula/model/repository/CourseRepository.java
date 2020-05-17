package com.matricula.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matricula.model.entity.Course;
import com.matricula.model.entity.Student;


public interface CourseRepository extends JpaRepository<Course, Long>{
	
    @Query(value = "SELECT MAX(id) FROM Course")
    Long findTopByOrderByIdDesc();
  
    //Query para el Admin
    @Query("SELECT c FROM Course c WHERE c.name=:name")
    Course findByName(@Param("name") String name);

    //Query para el Alumno para ver sus cursos a matricularse
    @Query("SELECT c FROM Course c inner join Student s on c.career=s.career WHERE s.career="
    		+ "c.career AND s.semester=c.semester AND c.amount>0")
    List<Course> findCoursesAvailables(@Param("student") Student student);
        
    //FindById esta incorporado en el Crud de List
    
  //Query para el Admin
    List<Course> findAll();
    
  //Query para el Admin
    @Query("SELECT c FROM Course c WHERE c.name like %?1%")
    List<Course> finByName(String name);
    
  //Query para el Alumno
    @Query("SELECT c FROM Course c inner join Student s on c.career=s.career WHERE s.career="
    		+ "c.career AND s.semester=c.semester AND c.amount>0")
    List<Course> findCoursesAvailables(@Param("student") Student student);

}
