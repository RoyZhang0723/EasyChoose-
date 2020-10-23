package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "administer")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Administer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;

    String username;
    String password;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
