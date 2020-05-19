package com.matricula.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matricula.model.entity.Course;
import com.matricula.model.entity.Professor;

@Repository
public interface ProfessorRepository  extends JpaRepository <Professor, Long> {

    @Query("SELECT MAX(id) FROM Professor")
    Long findTopByOrderByIdDesc();

    @Query("SELECT p FROM Professor p WHERE p.id=?1")
    Professor fetchById(Long id);
    
    @Query("SELECT p FROM Professor p WHERE p.id=?1")
    List<Professor> fetchhById(Long id);
}