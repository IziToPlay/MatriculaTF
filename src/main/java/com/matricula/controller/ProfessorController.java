package com.matricula.controller;

import java.util.List;
import java.util.Optional;

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
import com.matricula.model.entity.Student;
import com.matricula.service.ProfessorService;

@Controller
@RequestMapping("/professors")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	private List<Professor> professors;
	
	@GetMapping("/list")
	public String showAllProfessors(Model model) throws Exception {
		try {
		model.addAttribute("professors", professorService.getAllProfessors());
		} catch(Exception e) {
		model.addAttribute("error",e.getMessage());
	}
		return "courses/list";
	}
	
	@GetMapping("/search")
	public List<Professor> searchProfessorById(Long id, Model model) {
		try {
			if (id!=null) {
				professors=professorService.finddById(id);
				if (!professors.isEmpty()) {
					model.addAttribute("info", "Busqueda realizada correctamente");
					model.addAttribute("professors", professors);
				} else {
					model.addAttribute("info", "No existen coincidencias");
					model.addAttribute("professors", professorService.getAllProfessors());
				}
			} else {
				model.addAttribute("error", "Debe completar el campo de busqueda.");
				model.addAttribute("professors", professorService.getAllProfessors());
			}
		} catch (Exception e) {
			model.addAttribute("Error Professor:", e.getMessage());
		}
		return professors;
	}

	@GetMapping("/new")
	public String newProfessor(Model model){
		
		model.addAttribute("professor", new Professor());
		return "professors/new";
	}
	
	@PostMapping("/save")
	public String createProfessorForm(Professor professor, Model model) throws Exception {
		long id;
		id=professorService.createProfessor(professor).getId();
		return "professors/list";
	}
	
	@GetMapping("/edit/{id}")
    public String editProfessorForm(@PathVariable("id") long id, Model model) throws Exception {
        Professor professor = professorService.findById(id);
        model.addAttribute("professor", professor);
        return "professors/edit";
    }
	
	@PostMapping("/update/{id}")
    public String updateProfessor(@PathVariable("id") long id, Professor professor) throws Exception {
        professorService.updateProfessor(id, professor);
        return "professors/new";    
    }
	
	@GetMapping("/delete/{id}")
	public String deleteProfessor(@PathVariable("id") long id, Model model) throws Exception {
		professorService.deleteProfessor(professorService.findById(id).getId());
		model.addAttribute("success", "Profesor eliminado correctamente");
		return "redirect:/professors/list";
	}
	
	/*@GetMapping("/querysProfessors")
	public ModelAndView listAllProffesor(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pageInitPaginationProfessor.initPagination(pageSize, page, PROFESSOR_QUERYS);
		return modelAndView;
	}
	*/
	/*
	@GetMapping("/search")
	public ModelAndView searchByName(@RequestParam("name") String gravity,
							    @RequestParam("pageSize") Optional<Integer> pageSize,
							    @RequestParam("page")Optional<Integer> page) throws Exception{
		
		ModelAndView modelAndView ;
		
		if(!gravity.isEmpty())
		{
			if(!this.pageInitPagination.initPaginationSearch(pageSize,page, PRODUCT_PAGE_VIEW, gravity).isEmpty())
			{
				modelAndView=this.pageInitPagination.initPaginationSearch(pageSize, page, PRODUCT_QUERYS, gravity);
			}else
			{
				modelAndView=this.pageInitPagination.initPagination(pageSize, page, PRODUCT_QUERYS);

			}
		}
		else
		{
			modelAndView=this.pageInitPagination.initPagination(pageSize, page, PRODUCT_QUERYS);

		}

		
		return modelAndView;
	}*/
}
