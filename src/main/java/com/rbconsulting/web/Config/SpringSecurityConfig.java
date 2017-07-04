package com.rbconsulting.web.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.util.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    Connection dbConnection = null;
	PreparedStatement p = null;

    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.
            authorizeRequests()
				.antMatchers("/", "/home", "/about", "/register", "/mentors","/service","/recruit").permitAll()
				.antMatchers("/admin/**").hasAnyRole("ADMIN")
				.antMatchers("/user/**").hasAnyRole("USER")
				.anyRequest().authenticated()
            .and()
            .formLogin()
				.loginPage("/login")
				.successHandler(successHandler())
				.permitAll()
				.and()
            .logout()
				.permitAll()
				.logoutSuccessHandler(logoutHandler())
				.and()
            .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    // create two users, admin and user
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    }

    @Autowired
    DataSource dataSource;
    
    
//
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    	
	    auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
	      .usersByUsernameQuery("select username,password,id from User where email = ?" )
	      .authoritiesByUsernameQuery("select A.username, R.type_name from Role R left join User A on A.role_id = R.id where A.username = ? ");
        
    }
    
    @Bean
    public AuthenticationSuccessHandler successHandler() {
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        handler.setUseReferer(true);
        return handler;
    }
    
    @Bean
    public LogoutSuccessHandler logoutHandler() {
    	SimpleUrlLogoutSuccessHandler handler = new SimpleUrlLogoutSuccessHandler();
        handler.setUseReferer(true);
        return handler;
    }
}