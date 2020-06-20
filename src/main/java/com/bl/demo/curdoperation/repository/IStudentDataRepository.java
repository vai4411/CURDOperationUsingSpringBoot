package com.bl.demo.curdoperation.repository;

import com.bl.demo.curdoperation.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentDataRepository extends CrudRepository<Student, Long> {
}
