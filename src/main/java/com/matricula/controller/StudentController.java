package com.matricula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.matricula.model.entity.Account;
import com.matricula.model.entity.Professor;
import com.matricula.model.entity.Student;
import com.matricula.service.StudentService;
import com.matricula.service.UserService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService; 
	
	@Autowired
	private UserService userService; 
	
	/**@Autowired
	private AccountService accountService;*/
	
	private Student student; 
	private Account account;
	private List<Student> students; 
	private Long numerator=(long) -1;
	
	@GetMapping("/list")
	public String showAllStudents(Model model) throws Exception{
		
		try {
			model.addAttribute("students", studentService.getAllStudents());
			} catch(Exception e) {
			model.addAttribute("error",e.getMessage());
		}
			return "students/list";
		
	}
	
	@GetMapping("/searchStudent")
	public String searchStudentById(@RequestParam("filterId") String filterId, Model model) {
	
			if (!filterId.isEmpty()) {
				Long id= Long.parseLong(filterId);
				students = studentService.finddById(id);
				if (!students.isEmpty()) {
					model.addAttribute("succes", "Busqueda realizada correctamente");
					model.addAttribute("students", students);
					return "students/list";
				} else {
					model.addAttribute("info", "No existen coincidencias");
					model.addAttribute("students", students);
					return "students/list";
				}
			} else {
				model.addAttribute("students", students);
				model.addAttribute("error", "Debe completar el campo de busqueda.");
				return "students/list";
			}
	
		//return students;
	}
	
	@GetMapping("/new")
	public String newStudent(Model model){
		
		model.addAttribute("student", new Student());
		//account = new Account();
		//List<Account> accounts = accountService.getAllAccounts();
		//model.addAttribute("accounts", accounts);
		return "students/new";
	}
	
	@PostMapping("/save/{id}")
	public String createStudentForm(@PathVariable("id") Long id, Model model) throws Exception {
		numerator++;
		student.setAccount(userService.findById(numerator));
		id=studentService.createStudent(studentService.findById(id)).getId();

		return "students/list";
	}
	
	@GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model) throws Exception {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "students/edit";
    }
	
	@PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, Student student) throws Exception {
        studentService.updateStudent(id, student);
        return "students/new";    
    }
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id, Model model) throws Exception {
		Student student = studentService.findById(id);
		studentService.deleteStudent(id);
		model.addAttribute("success", "Estudiante eliminado correctamente");
		return "redirect:/students/list";
	}
	
}
