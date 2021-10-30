package com.example.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int student_id;

	public StudentNotFoundException(int student_id) {
		super("No record found for the Student id: " + student_id);
		this.student_id = student_id;
	}
	
	public int getStudent_id() {
		return student_id;
	}
	
	

}
