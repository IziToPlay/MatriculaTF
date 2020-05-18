package com.matricula.controller;

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

import com.matricula.model.entity.Professor;
import com.matricula.service.ProfessorService;

@Controller
@RequestMapping("/professors")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/list")
	public String showAllProfessors(Model model) throws Exception {
		try {
		model.addAttribute("professors", professorService.getAllProfessors());
		} catch(Exception e) {
		model.addAttribute("error",e.getMessage());
	}
		return "courses/list";
	}

	@GetMapping("/new")
	public String newProfessor(Model model) {

		// in case of redirection model will contain article
		if (!model.containsAttribute("professor")) {
			model.addAttribute("professor", new Professor());
			}
		return PROFESSOR_ADD_FORM_VIEW;
	}
	
	@PostMapping("/create")
	public String createProfessor(@Valid Professor professor, BindingResult result, Model model, RedirectAttributes attr) {

		if (result.hasErrors()/* || productService.valid(product) == false*/) {

		
			attr.addFlashAttribute("org.springframework.validation.BindingResult.professor", result);
			attr.addFlashAttribute("professor", professor);
			return "redirect:/professors/new";
		}
		Professor newProfessor = professorService.createProfessor(professor);
		model.addAttribute("professor", newProfessor);

		return "redirect:/professors/" + newProfessor.getId();//verificar despues
	}
	
	@GetMapping("{id}/edit")
	public String editProfessor(@PathVariable(value = "id") Long professorId, Model model) {
		/*
		 * in case of redirection from '/article/{id}/update' model will contain product
		 * with field values
		 */
		if (!model.containsAttribute("professor")) {
			model.addAttribute("professor", professorService.findById(professorId));
			
		}
		return PROFESSOR_EDIT_FORM_VIEW;
	}
	
	@PostMapping(path = "/{id}/update")//revisar
	public String updateProfessor(@PathVariable(value = "id") Long professorId, @Valid Professor professorDetails,
			BindingResult result, Model model, RedirectAttributes attr) {

		if (result.hasErrors()/* || productService.valid(productDetails) == false*/) {//revisar

			/// After the redirect: flash attributes pass attributes to the model
			attr.addFlashAttribute("org.springframework.validation.BindingResult.professor", result);
			attr.addFlashAttribute("professor", professorDetails);

			attr.addFlashAttribute("error", "No se permite esta incidencia");

			return "redirect:/professors/" + professorDetails.getId() + "/edit";
		}

		professorService.updateProfessor(professorId, professorDetails);
		model.addAttribute("professor", professorService.findById(professorId));
		return "redirect:/professors/" + professorId;
	}
	
	@GetMapping(value = "/{id}/delete")
	public String deleteProfessor(@PathVariable("id") Long professorId) {
		professorService.deleteProfessor(professorId);
		return "redirect:/professors";
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
