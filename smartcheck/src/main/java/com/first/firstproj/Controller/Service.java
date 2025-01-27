package com.first.firstproj.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.first.firstproj.Repos.repo;
import com.first.firstproj.entities.User;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    public repo Repo;
    public User getData(){
        // return Repo.findAll();
        return Repo.getUserByName("username");
    }
}
