package com.bl.demo.curdoperation.service;

import com.bl.demo.curdoperation.repository.StudentDataRepository;
import com.bl.demo.curdoperation.model.Result;
import com.bl.demo.curdoperation.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentDataRepository studentDAO;

    public  ResponseEntity<Result>  insertStudent(Student student) {
        Result result = new Result();
        Student n = studentDAO.save(student);
        if (n == null) {
            result.setResultCode("-1");
            result.setResultDescription("Unable to add student record");
        }
        else {
            result.setResultCode("0");
            result.setResultDescription("Student record added successfully");
        }
        return new ResponseEntity (result, HttpStatus.OK);
    }

    public ResponseEntity<Student> getStudent(long id) {
        Result result = new Result();
        Optional<Student> student1= studentDAO.findById(id);
        if (student1 == null) {
            result.setResultCode("-1");
            result.setResultDescription("No record found");
            return new ResponseEntity (result, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity (student1, HttpStatus.OK);

    }

    public ResponseEntity<Student> updateStudent(long id, Student student) {
        Optional<Student> student1 = studentDAO.findById(id);
        Result result = new Result();
        if (student1 != null) {
            Student student2 = student1.get();
            student2.setName(student.getName());
            student2.setEmail(student.getEmail());
            student2.setContactNumber(student.getContactNumber());
            studentDAO.save(student2);
            result.setResultCode("0");
            result.setResultDescription("Student record updated successfully");
            return new ResponseEntity (result, HttpStatus.OK);
        }
        else {
            result.setResultCode("-1");
            result.setResultDescription("Unable to update student record");
            return new ResponseEntity (result, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Student> deleteStudent(long id) {
        Result result = new Result();
        if (studentDAO.findById(id) != null) {
            studentDAO.deleteById(id);
            result.setResultCode("0");
            result.setResultDescription("Student record deleted successfully");
            return new ResponseEntity (result, HttpStatus.OK);
        }
        else {
            result.setResultCode("1");
            result.setResultDescription("Student record not deleted successfully");
            return new ResponseEntity (result, HttpStatus.OK);
        }
    }
}
