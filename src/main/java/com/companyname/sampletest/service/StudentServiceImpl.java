package com.companyname.sampletest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.sampletest.entity.StudentEntity;
import com.companyname.sampletest.repository.StudentsRepository;

@Component
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentsRepository studentsRepository;
	
	@Override
	public List<StudentEntity> listStudents() {
		List<StudentEntity> students = new ArrayList<>();
		studentsRepository.findAll().forEach(students:: add);
		return students;
	}
	
	

}
