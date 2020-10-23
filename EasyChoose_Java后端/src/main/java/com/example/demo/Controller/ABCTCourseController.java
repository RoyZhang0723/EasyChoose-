package com.example.demo.Controller;

import com.example.demo.Service.ABCTCourseService;
import com.example.demo.pojo.ABCTCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ABCTCourseController {
    @Autowired
    ABCTCourseService abctCourseService;

    @CrossOrigin
    @GetMapping("/api/ABCT")
    @ResponseBody
    public List<ABCTCourse> list() {
        return abctCourseService.list();
    }
}
