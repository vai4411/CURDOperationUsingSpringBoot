package com.bl.demo.curdoperation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @PostMapping(path= "/addStudent", consumes = "application/json", produces = "application/json")
    public ResponseEntity addStudent() {
        return null;
    }

    @GetMapping(path= "/getStudent", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> getStudent() {
       return null;
    }

    @PutMapping(path= "/updateStudent", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateStudent() {
      return null;
    }

    @DeleteMapping(path= "/deleteStudent", consumes = "application/json", produces = "application/json")
    public ResponseEntity deleteStudent() {
        return null;
    }
}
