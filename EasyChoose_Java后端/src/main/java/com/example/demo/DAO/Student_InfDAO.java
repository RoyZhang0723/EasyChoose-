package com.example.demo.DAO;

import com.example.demo.pojo.Student_inf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Student_InfDAO extends JpaRepository<Student_inf,Integer> {
    Student_inf findByUsernameAndPassword(String username, String password);
}
