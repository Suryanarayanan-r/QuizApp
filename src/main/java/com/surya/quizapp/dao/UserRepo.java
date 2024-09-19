package com.surya.quizapp.dao;

import com.surya.quizapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserRepo extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
