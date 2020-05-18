package com.matricula.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matricula.model.entity.Student;
import com.matricula.model.repository.StudentRepository;
import com.matricula.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override 
	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().iterator().forEachRemaining(students::add);
		return students;
	}

	/*
	 * @Override public Incident getOneById(Long id) { // TODO Auto-generated method
	 * stub return incidentRepository.findById(id).orElseThrow(() -> new
	 * RuntimeException("Incident not found")); }
	 */

	@Override //
	public Student createStudent(Student student) {
		Student newStudent;
		newStudent = studentRepository.save(student);
		return newStudent;
	}

	@Override
	public Student updateStudent(Long id, Student studentDetails) {
		// TODO Auto-generated method stub
		Student student = findById(id);

		student.setAccount(studentDetails.getAccount());
		student.setCareer(studentDetails.getCareer());
		student.setLastName(studentDetails.getLastName());
		student.setName(studentDetails.getName());
		student.setSemester(studentDetails.getSemester());
		studentRepository.save(student);
		return student;
	}


	@Override
	public void deleteStudent(Long studentId) {
		studentRepository.delete(findById(studentId));
	}

	@Override
	public Student findById(Long id) {
		Optional<Student> student = studentRepository.findById(id);

		/*if (!student.isPresent()) {
			throw new ResourceNotFoundException("There is no Student with ID = " + id);
		}*/
		return student.get();
	}
/**
	@Override
	public boolean valid(Student student) {
		List<Student> students = new ArrayList<>();
		incidentRepository.findByObservations(incident.getObservations()).iterator().forEachRemaining(incidents::add);
		if (!incidents.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}**/

	@Override
	public Student getLatestEntry() {
		List<Student> students = getAllStudent();
		if (students.isEmpty()) {
			return null;
		} else {
			Long latestStudentID = studentRepository.findTopByOrderByIdDesc();
			return findById(latestStudentID);
		}
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	@Override
	public List<Student> finById(Long id) {
		return studentRepository.finById(id);
	}

	/**@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}**/

	/**@Override
	public Student createIncident(Student student) {
		// TODO Auto-generated method stub
		return null;
	}**/
//*
	
	/**@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}**/


	

}
