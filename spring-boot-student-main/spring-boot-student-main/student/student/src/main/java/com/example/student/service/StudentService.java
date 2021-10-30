package com.example.student.service;

import java.util.List;

import com.example.student.entity.Student;

public interface StudentService {
	
	Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(int id);
	Student updateStudent(Student student, int id);
	void deleteStudent(int id);

}
