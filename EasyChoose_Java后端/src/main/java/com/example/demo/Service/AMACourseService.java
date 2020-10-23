package com.example.demo.Service;

import com.example.demo.DAO.AMACourseDAO;
import com.example.demo.pojo.AMACourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AMACourseService {
    @Autowired
    AMACourseDAO amaCourseDAO;
    public List<AMACourse> list() {
        return amaCourseDAO.findAll();
    }
}
