package com.bl.demo.curdoperation.model;

import javax.persistence.*;

@Entity
@Table
public class Student {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String email;
    private String contactNumber;
    @Id
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
