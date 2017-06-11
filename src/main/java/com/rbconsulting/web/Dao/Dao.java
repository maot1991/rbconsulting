package com.rbconsulting.web.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class Dao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
}