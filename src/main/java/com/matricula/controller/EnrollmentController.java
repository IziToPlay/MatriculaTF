package com.matricula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matricula.service.CourseService;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/list")
	public String showAllCoursesAvailables(Model model) throws Exception {
		try {
		model.addAttribute("courses", courseService.findCoursesAvailables());
		} catch(Exception e) {
		model.addAttribute("error",e.getMessage());
	}
		return "enrollments/list";
	}
	
}
