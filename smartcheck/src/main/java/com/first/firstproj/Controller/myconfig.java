package com.first.firstproj.Controller;

import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import com.mysql.cj.protocol.AuthenticationProvider;

@Configuration
@EnableWebSecurity
public class myconfig {
    
    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        // daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
        authenticationProvider.setUserDetailsService(getUserDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }


//     // public CustomUserDetailService implements UserDetailsService{

//     // }



//     // @Override
//     // protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//     //     auth.authenticationProvider(authenticationProvider());
//     // } 
//     // @Bean
//     // public DaoAuthenticationProvider daoAuthenticationProvider(){
//     //     DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//     //     provider.set
//     // }

//     // @Override
//     // protected void configure(HttpSecurity http) throws Exception{
//     //     http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER")
//     //     .antMatchers("/**").permitAll().and().formLogin().and().csrf().disable();
//     // }
    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity httpSecurity) throws Exception{
        httpSecurity
        .csrf().disable()
        
        // .requestMatchers("/admin/**")
        // .hasRole("ADMIN")
        // .requestMatchers("/user/**")
        // .hasRole("USER")
        
        .authorizeHttpRequests()
        // .requestMatchers("/user/dashboard")
        .requestMatchers("/user/**")
        .authenticated()
        .and()
        .authorizeHttpRequests()
        // .requestMatchers("/")
        // .permitAll()
        // .requestMatchers("/signup")
        // .permitAll()
        // .requestMatchers("/Signin")
        // .permitAll()
        .anyRequest()
        .permitAll()
        // .permitAll()
        .and()
        .formLogin()
        .loginPage("/Signin").loginProcessingUrl("/dologin").defaultSuccessUrl("/user/dashboard")
        .failureUrl("/login-failed");
        // DefaultSecurityFilterChain defaultSecurityFilterChain= httpSecurity.build();
//         httpSecurity.authenticationProvider(authenticationProvider());
        return httpSecurity.build();
//         // return new UserDetailsServiceImpl();
    }


}
