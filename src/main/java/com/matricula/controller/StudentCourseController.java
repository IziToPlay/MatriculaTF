package com.matricula.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matricula.model.entity.Course;
import com.matricula.model.entity.Student;
import com.matricula.model.entity.StudentCourse;
import com.matricula.service.CourseService;
import com.matricula.service.EnrollmentService;
import com.matricula.service.StudentCourseService;
import com.matricula.service.StudentService;
import com.matricula.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/studentCourses")
public class StudentCourseController {
	
	@Autowired
	private StudentCourseService studentCourseService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private EnrollmentService enrollmentService;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private CourseService courseService;
	
	private Course course;
	private Integer actualSemester=202002;
	private Integer searchedSemester;
	private List<StudentCourse> studentCourses;
	
	@GetMapping
	public String showActualRegisteredCourses(Model model) throws Exception {
		try {
			
		//Long id=userServiceImpl.getLoggedUser().getId();
		Long id= 2L;
		model.addAttribute("studentCourses", studentCourseService.fetchStudentCourseBySemester(actualSemester, id));
		} catch(Exception e) {
		model.addAttribute("error",e.getMessage());
	}
		return "studentCourses/listCoursesActualSemester";
	}
		
	@GetMapping("/search")
	public String searchProfessorById(@RequestParam("semester") String semester, Model model) throws Exception {
			
			String url = "studentCourses/list";
			Long id=2L;
			
			if (!semester.isEmpty()) {
				
				Integer searchedSemester = Integer.parseInt(semester); 
				studentCourses= studentCourseService.fetchStudentCourseBySemester(searchedSemester, id);
				if (!studentCourses.isEmpty()) {
					model.addAttribute("studentCourses", studentCourses);
					model.addAttribute("success", "Busqueda realizada correctamente");
					return url;
				} else {
					model.addAttribute("info", "No existen coincidencias");
					model.addAttribute("studentCourses", studentCourses);
					return url;
				}
			} else {
				model.addAttribute("error", "Debe completar el campo de busqueda.");
				model.addAttribute("studentCourses", studentCourses);
				return url;
			}
			//return professors;
		} 
	
	
	//Matricular alumno y restar uno a la cantidad de vacantes disponibles para el curso
	@PostMapping("/save/{id}")
	public String createStudentCourse(@PathVariable("id") Long id, Model model) throws Exception {

		if (studentCourseService.validateCoursesStudentRegistered(courseService.findById(id).getId()).isEmpty()) {
			model.addAttribute("error", "Usted ya se encuentra matriculado en este curso");
				return "redirect:/studentCourses";
			} else {
			StudentCourse studentCourse = new StudentCourse();
			studentCourse.setCourse(course);
			//studentCourse.setStudent(studentService.findStudentByAccount(accountServiceImpl.getLoggedUser().getId()));
			studentCourse.setEnrollment(enrollmentService.findBySemester(actualSemester));
			course.setAmount(course.getAmount()-1);
			studentCourseService.createStudentCourse(studentCourse);
			//Student_Course newStudentCourse = studentCourseService.createStudentCourse(studentCourse);
			return "redirect:/studentCourses"; //+ newStudent.getId();//verificar despues
			}
		}
	
	@GetMapping("/searchSemester")
	public String searchStudentCourseBySemester(Integer semester, Model model) {
		try {
			if (semester!=null) {
				//Long id=userServiceImpl.getLoggedUser().getId();
				Long id=null;
				studentCourses = studentCourseService.fetchStudentCourseBySemester(semester, id);
				if (!studentCourses.isEmpty()) {
					model.addAttribute("info", "Busqueda realizada correctamente");
					model.addAttribute("studentCourses", studentCourses);
					//searchedSemester=semester;
					return "studentCourses/list";
				} else {
					model.addAttribute("info", "No existen coincidencias");
					Long idd=null;
					return "redirect:/studentCourses";
				}
			} else {
				model.addAttribute("error", "Debe completar el campo de busqueda.");
				Long id=null;
				return "redirect:/studentCourses";
			}
		} catch (Exception e) {
			model.addAttribute("Error Student Course:", e.getMessage());
			return "redirect:/studentCourses";
		}
	}

	//Desmatricular alumno y sumar uno a la cantidad de vacantes para curso
	@GetMapping("/delete/{id}")
	public String deleteStudentCourse(@PathVariable("id") Long courseToDeleteId) {
		Course course=courseService.findById(courseToDeleteId);
		course.setAmount(course.getAmount()+1);
		studentCourseService.deleteStudentCourse(courseToDeleteId);
		return "redirect:/studentCourses";
	}	
}
