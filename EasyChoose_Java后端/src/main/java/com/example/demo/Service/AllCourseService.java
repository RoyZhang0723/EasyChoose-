package com.example.demo.Service;

import com.example.demo.DAO.AllCourseDAO;
import com.example.demo.pojo.AllCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllCourseService {
    @Autowired
    AllCourseDAO allCourseDAO;

    public List<AllCourse> list() {
        return allCourseDAO.findAll();
    }
}
