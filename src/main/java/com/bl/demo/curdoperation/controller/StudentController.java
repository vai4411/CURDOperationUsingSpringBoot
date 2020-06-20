package com.bl.demo.curdoperation.controller;

import com.bl.demo.curdoperation.model.Student;
import com.bl.demo.curdoperation.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(path= "/addStudent", consumes = "application/json", produces = "application/json")
    public ResponseEntity addStudent(@RequestBody Student student) {
        return studentService.insertStudent(student);
    }

   @GetMapping(path= "/getStudent", consumes = "application/json", produces = "application/json")
    public ResponseEntity getStudent(@RequestHeader long id) {
            return studentService.getStudent(id);
    }

    @PutMapping(path= "/updateStudent", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateStudent(@RequestBody Student student,@RequestHeader long id) {
            return studentService.updateStudent(id,student);
    }

    @DeleteMapping(path= "/deleteStudent", consumes = "application/json", produces = "application/json")
    public ResponseEntity deleteStudent(@RequestHeader long id) {
            return studentService.deleteStudent(id);
    }
}
