package com.matricula.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
import com.matricula.model.entity.Professor;
import com.matricula.service.CourseService;
import com.matricula.service.ProfessorService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ProfessorService professorService;
	
	private Course course;
	private Professor professor;
	private List<Course> courses;
	private List<String> careers;
	private List<Integer> semesters;
	
	@GetMapping("/list")
	public String showAllCourses(Model model) throws Exception {
		try {
		model.addAttribute("courses", courseService.getAllCourses());
		} catch(Exception e) {
		model.addAttribute("error",e.getMessage());
	}
		return "courses/list";
	}
	
	@GetMapping("/listCoursesAvailables")
	public String showAllCoursesAvailables(Model model) throws Exception {
		try {
		model.addAttribute("courses", courseService.findCoursesAvailables());
		} catch(Exception e) {
		model.addAttribute("error",e.getMessage());
	}
		return "courses/listCoursesAvailables";
	}
	
	@GetMapping("/searchCourse")
	public List<Course> searchCourseByName(String name, Model model) {
		try {
			if (!name.isEmpty()) {
				courses = courseService.findByName(name);
				if (!courses.isEmpty()) {
					model.addAttribute("info", "Busqueda realizada correctamente");
					model.addAttribute("courses", courses);
				} else {
					model.addAttribute("info", "No existen coincidencias");
					model.addAttribute("courses", courseService.getAllCourses());
				}
			} else {
				model.addAttribute("error", "Debe completar el campo de búsqueda.");
				model.addAttribute("courses", courseService.getAllCourses());
			}
		} catch (Exception e) {
			model.addAttribute("Error Course:", e.getMessage());
		}
		return courses;
	}
	
	@GetMapping("/new")
	public String newCoursetForm(Model model){
		
		model.addAttribute("course", new Course());
		professor = new Professor();
		List<Professor> professors = professorService.getAllProfessors();
		model.addAttribute("professors", professors);
		
		return "courses/new";
	}
	
	@PostMapping("/save")
	public String saveNewCourse(Course course, Model model) throws Exception {
		long id=courseService.createCourse(course).getId();
		return "courses/list";
	}
	
	@GetMapping("/edit/{id}")
    public String editCourseForm(@PathVariable("id") long id, Model model) throws Exception {
        Course course = courseService.findById(id);
        model.addAttribute("course", course);
        return "courses/edit";
    }
	
	@PostMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Course course) throws Exception {
        courseService.updateCourse(id, course);
        return "courses/new";    
    }
	
	@GetMapping("/delete/{id}")
	public String deleteCourse(@PathVariable("id") long id, Model model) throws Exception {
		Course course = courseService.findById(id);
		courseService.deleteCourse(id);
		model.addAttribute("success", "Ticket eliminado correctamente");
		return "redirect:/tickets/list";
	}
	
	public void getAllCareers() {
		careers.add(0, "Ingenieria de Sistemas");
		careers.add(1, "Ingenieria de Software");
		careers.add(2, "Ingenieria Industrial");
		careers.add(3, "Economia");
		careers.add(4, "Administracion");
		careers.add(5, "Ingenieria Civil");
	}
	
	public void getAllSemesters() {
		semesters.add(0, 201702);
		semesters.add(1, 201801);
		semesters.add(2, 201802);
		semesters.add(3, 201901);
		semesters.add(4, 201902);
		semesters.add(5, 202001);
	}


}
