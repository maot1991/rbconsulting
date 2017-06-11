package com.rbconsulting.web.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.rbconsulting.web.Bean.User.UserBean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class UserDao extends Dao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private void createTable(){
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Users("
				+ "id SERIAL, email VARCHAR(255), password VARCHAR(255))");
	};
	
	private boolean checkExist(){
		return false;
	}
	
	private boolean updateTable(UserBean user){
		
		List<Object> columns = new ArrayList<Object>();
		
		columns.add(user.getEmail());
		columns.add("mtang");
		columns.add("13880695108");
		columns.add(1);
		
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		columns.add(passwordEncoder.encode(user.getPassword()));
		System.out.println("the final steps =========== xxxxxxx \n");
		jdbcTemplate.update("INSERT INTO User(email, username, phone_number, role_id, password) VALUES (?,?,?,?,?)", columns.toArray());
		
		return true;
	}
	
	public void registerUser(UserBean user){
		if (checkExist()){
			return;
		}
		
		createTable();
		
		updateTable(user);
		
		
	}
	
	public void test(){
		
	}
	
	
	
}