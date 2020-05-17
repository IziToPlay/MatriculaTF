package com.matricula.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.matricula.model.repository.ProfessorRepository;
import com.matricula.model.entity.Professor;
import com.matricula.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService  {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Override
	public List<Professor> getAllProfessors() {
		List<Professor> professors = new ArrayList<>();
		professorRepository.findAll().iterator().forEachRemaining(professors::add);
		return professors;
	}

	@Override
	public Professor createProfessor(Professor professor) {
		Professor newProfessor=professorRepository.save(professor);
		return newProfessor;
	}

	@Override
	public Professor updateProfessor(Long id, Professor professorDetails) {
		Professor professor=findById(id);
		professor.setName(professorDetails.getName());
		professor.setLastName(professorDetails.getLastName());
		professorRepository.save(professor);
		return professor;
	}

	@Override
	public void deleteProfessor(Long professorId) {
		professorRepository.deleteById(professorId);
		
	}

	@Override
	public Professor findById(Long id) {
	Optional<Professor> professor=professorRepository.findById(id);
		
		if(!professor.isPresent()) {
			/*throw new ResourceNotFoundException("There is no Professor with ID = " + id);*/
		}
		return professor.get();
	}

	@Override
	public Professor getLatestEntry() {
		List<Professor> professors = getAllProfessors();
		if (professors.isEmpty()) {
			return null;
		} else {
			Long latestProfessorID = professorRepository.findTopByOrderByIdDesc();
			return findById(latestProfessorID);
		}
	}

	/*@Override
	public Page<Professor> findByLastName(String lastName, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
