package com.bl.demo.curdoperation.repository;

import com.bl.demo.curdoperation.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDataRepository extends CrudRepository<Student, Long> {
}
