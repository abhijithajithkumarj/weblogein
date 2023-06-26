package com.weblogein.weblogein;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class Security {



   @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("anoop")
                .password("{noop}abhijith123")
                .roles("USER")
                .and()
                .withUser("Abhijith")
                .password("{noop}abhijith123")
                .roles("USER")
                .and()
                .withUser("veena")
                .password("{noop}abhijith123")
                .roles("USER")
                .and()
                .withUser("Aravind")
                .password("{noop}abhijith123")
                .roles("USER")
                .and()
                .withUser("Arya")
                .password("{noop}abhijith123")
                .roles("USER")
                .and()
                .withUser("lisa")
                .password("{noop}abhijith123")
                .roles("USER");


    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home",true)
                .permitAll();
        return http.build();

    }



}
