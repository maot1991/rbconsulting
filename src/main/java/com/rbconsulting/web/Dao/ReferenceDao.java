package com.rbconsulting.web.Dao;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.rbconsulting.web.Bean.Mentor.MentorDegreeBean;
import com.rbconsulting.web.Bean.Mentor.MentorProfileBean;
import com.rbconsulting.web.Bean.User.UserBean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class ReferenceDao extends Dao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<Object, Map> getFullList(String table){
		String sql = "SELECT * FROM " + table;
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		Map<Object, Map> map = converMapListToMap(list, "id");
		return map;
	}
	
}