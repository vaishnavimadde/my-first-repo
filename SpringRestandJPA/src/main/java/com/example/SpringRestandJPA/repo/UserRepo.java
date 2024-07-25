package com.example.SpringRestandJPA.repo;

import com.example.SpringRestandJPA.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    User findByUsername(String name);
}
