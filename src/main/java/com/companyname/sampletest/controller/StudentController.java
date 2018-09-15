package com.companyname.sampletest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.companyname.sampletest.entity.StudentEntity;
import com.companyname.sampletest.repository.StudentsRepository;

@RestController
public class StudentController {
	
@Autowired
StudentsRepository studentRepository;

@PostMapping("/student")
public StudentEntity createStudent(@Valid @RequestBody StudentEntity student) {
    return studentRepository.save(student);
}
// Get Mapping

@GetMapping("/student/{id}")
public StudentEntity getStudentById(@PathVariable(value = "id") Long studentId) {
	return studentRepository.findById(studentId)
			.orElseThrow((null));
}


}
