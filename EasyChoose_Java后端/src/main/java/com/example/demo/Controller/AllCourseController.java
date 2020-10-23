package com.example.demo.Controller;

import com.example.demo.Service.AllCourseService;
import com.example.demo.pojo.AllCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AllCourseController {
    @Autowired
    AllCourseService allCourseService;

    @CrossOrigin
    @GetMapping("api/all_course")
    @ResponseBody
    public List<AllCourse> list() {
        return allCourseService.list();
    }
}
