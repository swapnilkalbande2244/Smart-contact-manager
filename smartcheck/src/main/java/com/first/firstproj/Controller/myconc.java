package com.first.firstproj.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.first.firstproj.Repos.repo;
import com.first.firstproj.entities.User;
import com.first.firstproj.helper.Message;

import jakarta.servlet.http.HttpSession;

@Controller
public class myconc {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private repo Repo;

    @GetMapping("/")
    public String ans(){
        return "home";
    }
    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user",new User());
        // Repo.save(user);
        return "signup";
    }

    @GetMapping("/Signin")
    public String login(Model model){
        return "login";
    }

    // @PostMapping("/do_register")
    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user,@RequestParam(value = "checkbox",defaultValue = "false") boolean checkbox, Model model,HttpSession session){
        // System.out.println("Agreement "+checkbox);
        // System.out.println("User "+user);

        try {
            if(!checkbox){
                System.out.println("You have not agreed terms and conditions !");
                throw new Exception("You have not agreed terms and conditions !"); 
            }
            user.setEnabled("true");    
            user.setRole("USER");
            user.setImage("default.png");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            // user.setPassword(user.getPassword());
    
            // Repo.save(user);
            User res = this.Repo.save(user);
            model.addAttribute("user",new User());
            session.setAttribute("message", new Message("Successfully Registered","alert-success"));
            return "signup";
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            model.addAttribute("user",user);
            session.setAttribute("message", new Message("something went wrong !"+e.getMessage(),"alert-danger"));
            return "signup";

        }

        
    }
    
}
