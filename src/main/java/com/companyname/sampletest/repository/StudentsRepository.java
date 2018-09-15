package com.companyname.sampletest.repository;

import org.springframework.stereotype.Repository;

import com.companyname.sampletest.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface StudentsRepository extends CrudRepository<StudentEntity, Long> {



	
}
