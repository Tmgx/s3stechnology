package com.companyname.sampletest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.companyname.sampletest.entity.StudentEntity;
@Service
public interface StudentService {
	public List<StudentEntity> listStudents();

}
