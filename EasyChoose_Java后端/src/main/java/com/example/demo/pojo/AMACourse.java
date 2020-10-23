package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "amacourse")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class AMACourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;

    String Subject_code;
    String Subject_name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSubject_code() {
        return Subject_code;
    }

    public void setSubject_code(String subject_code) {
        Subject_code = subject_code;
    }

    public String getSubject_name() {
        return Subject_name;
    }

    public void setSubject_name(String subject_name) {
        Subject_name = subject_name;
    }

}
