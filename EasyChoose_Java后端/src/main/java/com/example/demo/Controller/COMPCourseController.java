package com.example.demo.Controller;

import com.example.demo.Service.COMPCourseServise;
import com.example.demo.pojo.COMPCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class COMPCourseController {
    @Autowired
    COMPCourseServise compCourseServise;

    @CrossOrigin
    @GetMapping("api/COMP")
    @ResponseBody
    public List<COMPCourse> list() {
        return compCourseServise.list();
    }
}
