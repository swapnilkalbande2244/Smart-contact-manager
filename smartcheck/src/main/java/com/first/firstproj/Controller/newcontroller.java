package com.first.firstproj.Controller;

import com.first.firstproj.Repos.repo;
import com.first.firstproj.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class newcontroller {
    @Autowired
    private repo userRepository;

    @GetMapping("/testing")
    public String test(){

        User User =new User();
        User.setemail("sp@gmail.com");
        User.setName("Swapnil");
        userRepository.save(User);
        return "working Fine";
    }
    // @GetMapping("/form")
    // @ResponseBody
    // public String ans(){
    //     return "home";
    // }
}
