package com.example.demo.Service;

import com.example.demo.DAO.AdministerDAO;
import com.example.demo.pojo.Administer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministerService {
    @Autowired
    AdministerDAO administerDAO;


    public Administer get(String username, String password) {
        return administerDAO.findByUsernameAndPassword(username,password);
    }
}
