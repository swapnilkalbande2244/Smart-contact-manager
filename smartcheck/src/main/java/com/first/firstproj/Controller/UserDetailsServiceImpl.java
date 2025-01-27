package com.first.firstproj.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.first.firstproj.Repos.repo;
// import com.first.firstproj.entities.User;
// import com.first.firstproj.entities.User;
import com.first.firstproj.entities.User;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private repo Repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = Repo.getUserByName(username);
        if(user==null){
            throw new UsernameNotFoundException("Could not found User !!!");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        return customUserDetails;
        // Optional<User> user = Repo.findByEmail(username);
        // return user.map(CustomUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("Username not found !"+ username) );
        // orElseThrow(()->UsernameNotFoundException("Username not found !"+ username));
    }
    
}
