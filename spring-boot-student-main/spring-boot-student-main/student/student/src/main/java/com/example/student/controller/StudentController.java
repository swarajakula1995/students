package com.example.student.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// create student REST Api
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}
	
	// get all student REST api
	@GetMapping("/getStudents")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	// get student by id REST api
	// http://localhost:8080/getStudentById/1
	@GetMapping("/getStudentById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
		return new ResponseEntity<Student>(studentService.getStudentById(id), HttpStatus.OK);
	}
	
	// update student REST Api
	@PutMapping("/updateStudent/{id}")
	public  ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}
	
	// delete student REST Api
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
		
		// delete student from the database
		studentService.deleteStudent(id);
		
		return new ResponseEntity<String>("Student record deleted succussfully !", HttpStatus.OK);
	}

}
