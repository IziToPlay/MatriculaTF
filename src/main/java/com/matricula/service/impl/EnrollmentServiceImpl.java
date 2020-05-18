package com.matricula.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matricula.model.entity.Enrollment;
import com.matricula.model.repository.EnrollmentRepository;
import com.matricula.service.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Override
	public Enrollment findBySemester(Integer semester) {
		return enrollmentRepository.findBySemester(semester);
	}

}
