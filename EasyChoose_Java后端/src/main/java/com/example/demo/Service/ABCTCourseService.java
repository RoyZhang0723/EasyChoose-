package com.example.demo.Service;

import com.example.demo.DAO.ABCTCourseDAO;
import com.example.demo.pojo.ABCTCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ABCTCourseService {
    @Autowired
    ABCTCourseDAO abctCourseDAO;

    public List<ABCTCourse> list() {
        return abctCourseDAO.findAll();
    }
}
