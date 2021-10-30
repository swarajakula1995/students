package com.example.student.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.entity.Student;
import com.example.student.exception.StudentNotFoundException;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepo;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
//		Optional<Student> student = studentRepo.findById(id);
//		
//		if(student.isPresent()) {
//			return student.get();
//		}
//		else {
//			throw new StudentNotFoundException(id);
//		}
		
		return studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException(id)); //lambda expression
		
	}

	@Override
	public Student updateStudent(Student student, int id) {
		
		// first we have to check if the student with the given id is present in the database.
		Student existingStudent = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		
		existingStudent.setName(student.getName());
		existingStudent.setCollege(student.getCollege());
		existingStudent.setCourse(student.getCourse());
		existingStudent.setDegree(student.getDegree());
		existingStudent.setRoll(student.getRoll());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setYear(student.getYear());
		
		// now save existing data to the database
		studentRepo.save(existingStudent);
		return existingStudent;
	}

	@Override
	public void deleteStudent(int id) {
		
		//check if the student with the given id is present in the database
		Student existingStudent = studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		
		studentRepo.deleteById(id);
	}

}
