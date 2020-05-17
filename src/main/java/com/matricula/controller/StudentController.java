package com.matricula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matricula.model.entity.Course;
import com.matricula.model.entity.Professor;
import com.matricula.model.entity.Student;
import com.matricula.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService; 
	
	private Student student; 
	private List<Student> students; 
	
	public String showAllStudents(Model model) throws Exception{
		
		try {
			model.addAttribute("students", studentService.getAllStudent());
			} catch(Exception e) {
			model.addAttribute("error",e.getMessage());
		}
			return "courses/list";
		
	}
	
	@GetMapping("/searchStudent")
	public List<Student> searchCourseById(Long id, Model model) {
		try {
			if (id!=null) {
				students = studentService.finById(id);
				if (!students.isEmpty()) {
					model.addAttribute("info", "Busqueda realizada correctamente");
					model.addAttribute("courses", students);
				} else {
					model.addAttribute("info", "No existen coincidencias");
					model.addAttribute("courses", studentService.getAllStudent());
				}
			} else {
				model.addAttribute("error", "Debe completar el campo de búsqueda.");
				model.addAttribute("courses", studentService.getAllStudent());
			}
		} catch (Exception e) {
			model.addAttribute("Error Course:", e.getMessage());
		}
		return students;
	}
	
	@GetMapping("/new")
	public String newStudent(Model model){
		
		model.addAttribute("student", new Student());
		return "courses/new";
	}
	
	@PostMapping("/save")
	public String createStudentForm(Student student, Model model) throws Exception {
		long id;
		id=studentService.createStudent(student).getId();
		return "students/list";
	}
	
	@GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable("id") long id, Model model) throws Exception {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "students/edit";
    }
	
	@PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") long id, Student student) throws Exception {
        studentService.updateStudent(id, student);
        return "students/new";    
    }
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) throws Exception {
		Student student = studentService.findById(id);
		studentService.deleteStudent(id);
		model.addAttribute("success", "Estudiante eliminado correctamente");
		return "redirect:/students/list";
	}
	
}
