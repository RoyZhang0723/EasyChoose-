package com.example.demo.Controller;

import com.example.demo.DAO.AMACourseDAO;
import com.example.demo.Service.AMACourseService;
import com.example.demo.pojo.AMACourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AMACourseController {
    @Autowired
    AMACourseService amaCourseService;

    @CrossOrigin
    @GetMapping("api/AMA")
    @ResponseBody
    public List<AMACourse> list() {
        return amaCourseService.list();
    }
}
