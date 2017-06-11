package com.rbconsulting.web.Action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import com.rbconsulting.web.Bean.User.UserBean;

import com.rbconsulting.web.Dao.UserDao;
import com.rbconsulting.web.Form.UserDto;

@Component
@Configurable
public class UserAction {
	@Autowired
	private UserDao dao;
	
	public UserBean registerUser(UserDto userForm){
		UserBean user = new UserBean();
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		
		dao.registerUser(user);;
		return user;
	}
}