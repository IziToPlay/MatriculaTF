package com.matricula.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matricula.model.entity.Course;
import com.matricula.model.entity.Professor;
import com.matricula.model.entity.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
	
    @Query("SELECT MAX(id) FROM Course")
    Long findTopByOrderByIdDesc();
  
    //Query para el Admin
    @Query("SELECT c FROM Course c WHERE c.name like %?1%")
    List<Course> findByName(String name);

    //Query para el Alumno para ver sus cursos a matricularse
    @Query("SELECT c FROM Course c WHERE c.career like %?1% AND c.semester like %?2% AND c.amount>0")
    List<Course> findCoursesAvailables(String career, String semester);
    
    @Query("SELECT c FROM Course c")
    List<Course> findAllCourses();
    
    @Query("SELECT c FROM Course c WHERE c.id=?1")
    Course fetchById(Long courseId);
    
    @Query("SELECT sc.course FROM StudentCourse sc")
    List<Course> findCoursesOnStudentCourse();
    
    //FindById esta incorporado en el Crud de List
    
  //Query para el Admin
   // List<Course> findAll();
    
 /* //Query para el Admin
    @Query("SELECT c FROM Course c WHERE c.name like %?1%")
    List<Course> findByName(String name);
    
  //Query para el Alumno
    @Query("SELECT c FROM Course c inner join Student s on c.career=s.career WHERE s.career="
    		+ "c.career AND s.semester=c.semester AND c.amount>0")
    List<Course> findCoursesAvailables(@Param("student") Student student);*/

}
