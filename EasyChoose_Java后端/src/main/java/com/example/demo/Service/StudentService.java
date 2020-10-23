package com.example.demo.Service;

import com.example.demo.DAO.Student_InfDAO;
import com.example.demo.pojo.Student_inf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    Student_InfDAO student_infDAO;

    public Student_inf get(String username, String password) {
        return student_infDAO.findByUsernameAndPassword(username, password);
    }

    public List<Student_inf> list() {
        return student_infDAO.findAll();
    }

    public void addorUpdate(Student_inf student_inf) {
        student_infDAO.save(student_inf);
    }

    public void delete_stu(int id) {
        student_infDAO.deleteById(id);
    }
}
