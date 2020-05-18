package com.matricula.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.matricula.model.entity.Professor;

public interface ProfessorService {
	
	List<Professor> getAllProfessors();
	
	Professor createProfessor(Professor professor);
	
	Professor updateProfessor(Long id, Professor professor);
	
	void deleteProfessor(Long professorId);
	
	Professor findById(Long id);
	
	List<Professor> finddById(Long id);

	Professor getLatestEntry();
}
