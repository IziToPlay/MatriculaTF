package com.matricula.service;

import java.util.List;
import com.matricula.model.entity.Professor;

public interface ProfessorService {
	public void insert(Professor i);
	public List<Professor> list();
	
}
