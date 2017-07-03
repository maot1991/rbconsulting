package com.rbconsulting.web.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Configurable
public class ServiceDao extends Dao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
}
