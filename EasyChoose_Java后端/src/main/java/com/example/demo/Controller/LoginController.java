package com.example.demo.Controller;

import com.example.demo.DAO.AdministerDAO;
import com.example.demo.Service.AdministerService;
import com.example.demo.Service.StudentService;
import com.example.demo.pojo.Administer;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.Student_inf;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    StudentService studentService;

    @Autowired
    AdministerService administerService;

    @CrossOrigin
    @PostMapping("/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestStu) {
        String username = requestStu.getUsername();
        String password = requestStu.getPassword();
        Student_inf student_inf = studentService.get(username, password);
        if (student_inf == null) {
            return new Result(400);
        } else {
            return new Result(200);
        }
    }

    @CrossOrigin
    @PostMapping("/api/login1")
    @ResponseBody
    public Result login1(@RequestBody Administer administer) {
        String username = administer.getUsername();
        String password = administer.getPassword();
        Administer administer1 = administerService.get(username,password);
        if (administer1 == null) {
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
