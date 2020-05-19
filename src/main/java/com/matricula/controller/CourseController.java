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
	public String searchCourseByName(@RequestParam("name") String name, Model model) throws Exception {
		try {
			if (!name.isEmpty()) {
				List<Course> courses = courseService.findByName(name);
				if (!courses.isEmpty()) {
					model.addAttribute("info", "Busqueda realizada correctamente");
					model.addAttribute("courses", courses);
					return "courses/list";
				} else {
					model.addAttribute("info", "No existen coincidencias");
					return "redirect:/courses/list";
				}
			} else {
				model.addAttribute("error", "Debe completar el campo de búsqueda.");
				return "redirect:/courses/list";
			}
		} catch (Exception e) {
			model.addAttribute("Error Course:", e.getMessage());
			return "redirect:/courses";
		}
		//return courses;
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
        model.addAttribute("professors", professorService.getAllProfessors());
        return "courses/edit";
    }
	
	@PostMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") long id, Course course) throws Exception {
        courseService.updateCourse(id, course);
        return "redirect:/courses/list";    
    }
	
	@GetMapping("/delete/{id}")
	public String deleteCourse(@PathVariable("id") long id, Model model) throws Exception {
		courseService.deleteCourse(courseService.findById(id).getId());
		model.addAttribute("success", "Curso eliminado correctamente");
		return "redirect:/courses/list";
	}
}
