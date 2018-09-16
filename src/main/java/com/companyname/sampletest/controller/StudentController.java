package com.companyname.sampletest.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

@DeleteMapping("/student/{id}")
public void deleteStudent(@PathVariable(value="id") Long studentId) {
	studentRepository.deleteById(studentId);
}

//@PutMapping("/student/{id}")
//public StudentEntity updateStudent(@RequestBody StudentEntity student,@PathVariable(value="id") Long StudentId) {
//	Optional<StudentEntity> student1= studentRepository.findById(StudentId);
//	if (student1.isPresent()) {
//		student.setId(StudentId);
//		return studentRepository.save(student);
//	}
//	return new StudentEntity();
//}


@PutMapping("/student/{id}")
public ResponseEntity<Object> updateStudent1(@RequestBody StudentEntity student,@PathVariable(value="id") Long StudentId) {
	Optional<StudentEntity> student1= studentRepository.findById(StudentId);
	if (!student1.isPresent()) {
		return ResponseEntity.badRequest().build();
	}
	student.setId(StudentId);
	StudentEntity studentUpdated =studentRepository.save(student);
	return ResponseEntity.ok().body(studentUpdated);
}








}
