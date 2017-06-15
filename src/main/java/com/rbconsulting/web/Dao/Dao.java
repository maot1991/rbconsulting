package com.rbconsulting.web.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.json.JSONObject;
import java.util.*;

public class Dao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<Object, Map> converMapListToMap(List<Map<String, Object>> raw, String pk){
		Map<Object, Map> map = new HashMap<Object, Map>();
		
		for(Map row : raw){
			Object new_pk = row.get(pk);
			map.put(new_pk, row);
		}
		
		return map;
	}
	
	
}