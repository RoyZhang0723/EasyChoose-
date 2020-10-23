package com.example.demo.Service;

import com.example.demo.DAO.COMPCourseDAO;
import com.example.demo.pojo.COMPCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class COMPCourseServise {
    @Autowired
    COMPCourseDAO compCourseDAO;

    public List<COMPCourse> list() {
        return compCourseDAO.findAll();
    }
}
