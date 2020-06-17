package com.bl.demo.curdoperation.entity;

import com.bl.demo.curdoperation.model.Student;
import com.bl.demo.curdoperation.utility.DBConnectionProvider;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class StudentDAO {

    public int insertStudent(Student student) {
        int status = 0;
        try {
            Connection connection = DBConnectionProvider.getConnection();
            PreparedStatement ps;
            ps = connection.prepareStatement("insert into student (id,name ,email,contact) values (?,?,?,?)");
            ps.setString(1,student.getId());
            ps.setString(2,student.getName());
            ps.setString(3,student.getEmail());
            ps.setString(4,student.getContactNumber());
            status = ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public Student getStudent(String id) {
        Student student =null;
        try {
            Connection connection = DBConnectionProvider.getConnection();
            PreparedStatement ps;
            ps = connection.prepareStatement("select * from student where id = ?");
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getString(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                student.setContactNumber(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public int updateStudent(String id, Student student) {
        int status = 0;
        try {
            Connection connection = DBConnectionProvider.getConnection();
            PreparedStatement ps;
            ps = connection.prepareStatement("update student set name = ?, email = ?, contact = ? where id = ?");
            ps.setString(4,student.getId());
            ps.setString(1,student.getName());
            ps.setString(2,student.getEmail());
            ps.setString(3,student.getContactNumber());
            status = ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int deleteStudent(String id) {
        int status = 0;
        try {
            Connection connection = DBConnectionProvider.getConnection();
            PreparedStatement ps;
            ps = connection.prepareStatement("delete from student where id = ?");
            ps.setString(1,id);
            status = ps.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
