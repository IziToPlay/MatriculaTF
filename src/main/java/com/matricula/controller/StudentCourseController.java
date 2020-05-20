package com.matricula.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
	
	public Course course=new Course();
	private Integer actualSemester=202002;
	private String actualSemesterr="202002";
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
	public String searchStudentCourseBySemester(@RequestParam("semester") String semester, Model model) throws Exception {
			
			String url = "studentCourses/list";
			Long id=2L;
			
			if (!semester.isEmpty()) {
				searchedSemester = Integer.parseInt(semester); 
				studentCourses= studentCourseService.fetchStudentCourseBySemester(searchedSemester, id);
				if (!studentCourses.isEmpty()) {
					if(searchedSemester==Integer.parseInt(actualSemesterr)) {
					model.addAttribute("studentCourses", studentCourses);
					model.addAttribute("success", "Busqueda realizadaa correctamente");
					return "studentCourses/listCoursesActualSemester";
					} else {
					model.addAttribute("studentCourses", studentCourses);
					model.addAttribute("success", "Busqueda realizada correctamente");
					return url;
					}
				} else {
					model.addAttribute("info", "No existen coincidencias");
					model.addAttribute("studentCourses", studentCourseService.fetchStudentCourseBySemester(actualSemester, id));
					return "studentCourses/listCoursesActualSemester";
				}
			} else {
				model.addAttribute("error", "Debe completar el campo de busqueda.");
				model.addAttribute("studentCourses", studentCourseService.fetchStudentCourseBySemester(actualSemester, id));
				return "studentCourses/listCoursesActualSemester";
			}
			//return professors;
		} 
	
	//Obtener Curso para la matricula
	@GetMapping("/connectCourse/{id}")
	public String connectCourseToRegister(@PathVariable("id") Long id, Model model) throws Exception {
		Long idd = courseService.findById(id).getId();
		return "courses/confirmCourse";
	}
	
	//Matricular alumno y restar uno a la cantidad de vacantes disponibles para el curso
	@GetMapping("/register/{id}")
	public String createStudentCourse(@PathVariable("id") Long id, Model model) throws Exception {

		if (studentCourseService.validateCoursesStudentRegistered(courseService.findById(id).getId()).isEmpty()==false) {
			model.addAttribute("error", "Usted ya se encuentra matriculado en este curso");
			model.addAttribute("courses", courseService.findCoursesAvailables());
			return "courses/listCoursesAvailables";
			} else {
			StudentCourse studentCourse = new StudentCourse();
			studentCourse.setStudent(studentService.findById((long)2));
			studentCourse.setEnrollment(enrollmentService.findBySemester(actualSemester));
			studentCourse.setCourse(courseService.findById(id));
			studentCourseService.createStudentCourse(studentCourse);
			//studentCourse.setStudent(studentService.findStudentByAccount(accountServiceImpl.getLoggedUser().getId()));
			course=courseService.findById(id);
			course.setAmount(course.getAmount()-1);
			
			model.addAttribute("success", "Matricula realizada correctamente");
			model.addAttribute("courses", courseService.findCoursesAvailables());
			return "courses/listCoursesAvailables";
			}
		}
	
	//Desmatricular alumno y sumar uno a la cantidad de vacantes para curso 
	@GetMapping("/delete/{id}")
	public String deleteStudentCourse(@PathVariable("id") Long courseToDeleteId, Model model) {
		Course course=courseService.findById(courseToDeleteId);
		course.setAmount(course.getAmount()+1);
		studentCourseService.deleteStudentCourse(courseToDeleteId);
		model.addAttribute("sucess","Matricula de curso eliminada correctamente");
		return "redirect:/studentCourses";
	}
 
	public StudentCourseService getStudentCourseService() {
		return studentCourseService;
	}

	public void setStudentCourseService(StudentCourseService studentCourseService) {
		this.studentCourseService = studentCourseService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public EnrollmentService getEnrollmentService() {
		return enrollmentService;
	}

	public void setEnrollmentService(EnrollmentService enrollmentService) {
		this.enrollmentService = enrollmentService;
	}

	public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getActualSemester() {
		return actualSemester;
	}

	public void setActualSemester(Integer actualSemester) {
		this.actualSemester = actualSemester;
	}

	public Integer getSearchedSemester() {
		return searchedSemester;
	}

	public void setSearchedSemester(Integer searchedSemester) {
		this.searchedSemester = searchedSemester;
	}

	public List<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}	
}
