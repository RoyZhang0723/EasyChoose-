package com.example.demo.Controller;

import com.example.demo.Service.StudentService;
import com.example.demo.pojo.ID;
import com.example.demo.pojo.Result;
import com.example.demo.pojo.Student_inf;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @CrossOrigin
    @GetMapping("api/stu_inf")
    public List<Student_inf> list() throws Exception {
        return studentService.list();
    }

    @CrossOrigin
    @PostMapping("api/a_student")
    public Result add_student(@RequestBody Student_inf student_inf) throws Exception {
        int id = student_inf.getID();
        student_inf.setUsername("student"+id);
        student_inf.setPassword("123");
        if (student_inf == null){
            return new Result(400);
        }
        studentService.addorUpdate(student_inf);
        return new Result(200);
    }

    @CrossOrigin
    @PostMapping("api/register_course")
    public void r_course(@RequestBody Student_inf reqStudent_inf) throws Exception {
        Student_inf student_inf = studentService.get(reqStudent_inf.getUsername(),reqStudent_inf.getPassword());
        student_inf.setCourse1(reqStudent_inf.getCourse1());
        student_inf.setCourse2(reqStudent_inf.getCourse2());
        student_inf.setCourse3(reqStudent_inf.getCourse3());
        student_inf.setCourse4(reqStudent_inf.getCourse4());
        student_inf.setCourse5(reqStudent_inf.getCourse5());
        student_inf.setCourse6(reqStudent_inf.getCourse6());
        student_inf.setCourse7(reqStudent_inf.getCourse7());
        studentService.addorUpdate(student_inf);
    }

    @CrossOrigin
    @PostMapping("api/d_student")
    public void delete_student(@RequestBody ID id) throws Exception {
        studentService.delete_stu(id.getId());
    }

    @CrossOrigin
    @PostMapping("api/my_course")
    public List<Student_inf> list_inf(@RequestBody User reqUser) {
        String username = reqUser.getUsername();
        String password = reqUser.getPassword();
        Student_inf student_inf = studentService.get(username,password);
        List<Student_inf> l = new ArrayList<>();
        l.add(student_inf);
        return l;
    }
}
