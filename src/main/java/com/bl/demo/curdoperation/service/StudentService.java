package com.bl.demo.curdoperation.service;

import com.bl.demo.curdoperation.entity.StudentDAO;
import com.bl.demo.curdoperation.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    public int insertStudent(Student student) {
        int result = 0;
        if (student.getName() != null && student.getEmail() != null
                && student.getId() != null && student.getContactNumber() != null) {
            result = studentDAO.insertStudent(student);
        }
        return result;
    }

    public Student getStudent(String id) {
        Student student = null;
        if (id != null)
            student = studentDAO.getStudent(id);
        return student;
    }

    public int updateStudent(String id, Student student) {
        int result = 0;
        if (id.equals(student.getId()) && student.getName() != null && student.getEmail() != null
                && student.getId() != null && student.getContactNumber() != null) {
            result = studentDAO.updateStudent(id, student);
        }
        return result;
    }

    public int deleteStudent(String id) {
        int result = 0;
        if (id != null)
            result = studentDAO.deleteStudent(id);
        return result;
    }
}
