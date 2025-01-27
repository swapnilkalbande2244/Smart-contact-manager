package com.first.firstproj.Controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.first.firstproj.entities.User;

public class CustomUserDetails implements UserDetails {


    // private String name;
    // private String email;
    // private String Password;
    // private String about;
    // private String role;
    // private List<GrantedAuthority> authrities;

    // public CustomUserDetails( User user) {
    //     // name=user.getName();
    //     email=user.getemail();
    //     Password = user.getPassword();
    //     // about=user.getAbout();
    //     // role= user.getRole();
    //     authrities=Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());


    // }

    private User user;
    

    public CustomUserDetails(User user) {
        super();
        this.user = user;
    }

    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());
        return List.of(simpleGrantedAuthority);
        // return authrities;
    }

    

    @Override
    public String getPassword() {
        // return user.getPassword();
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // return user.getEmail();
        return user.getemail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
