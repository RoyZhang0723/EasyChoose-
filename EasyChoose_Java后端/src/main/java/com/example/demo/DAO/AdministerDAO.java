package com.example.demo.DAO;

import com.example.demo.pojo.Administer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministerDAO extends JpaRepository<Administer,Integer> {
    Administer findByUsernameAndPassword(String username, String password);
}
