package com.first.firstproj.Repos;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.first.firstproj.entities.User;

public interface repo extends JpaRepository<User,Integer>{
    @Bean
    // // @Query("select * from User where Email = 'email'")
    @Query("select u from User u where u.email = :Email")
    public User getUserByName(@Param("Email") String Email);
    // @Query("select u from User u where u.Email = :email")
    // public Optional<User> findByEmail(String username);
}
