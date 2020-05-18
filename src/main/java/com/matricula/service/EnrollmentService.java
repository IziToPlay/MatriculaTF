package com.matricula.service;

import com.matricula.model.entity.Enrollment;

public interface EnrollmentService {

	Enrollment findBySemester(Integer semester);
}
