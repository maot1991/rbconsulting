package com.rbconsulting.web.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rbconsulting.web.Bean.Mentor.MentorProfileBean;

import org.json.JSONObject;
import java.util.*;

public class Dao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static JdbcTemplate jdbcTemplateStatic;
	
	@Autowired 
	public void setJdbcTemplate(JdbcTemplate tmpl){
		jdbcTemplateStatic = tmpl;
	}
	
	public Map<Object, Map> converMapListToMap(List<Map<String, Object>> raw, String pk){
		Map<Object, Map> map = new HashMap<Object, Map>();
		
		for(Map row : raw){
			Object new_pk = row.get(pk);
			map.put(new_pk, row);
		}
		
		return map;
	}
	
	private void createTable(){
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Users("
				+ "id SERIAL, email VARCHAR(255), password VARCHAR(255))");
	};
	
	public Map<Object, Map> getFullList(String table){
		String sql = "SELECT * FROM " + table;
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		Map<Object, Map> map = converMapListToMap(list, "id");
		return map;
	}
	
	public <T> List<T> getFullListForClass(String table, Class<T> c){
		String sql = "SELECT * FROM " + table;

		List<T> fullList  = new ArrayList<T>();
		fullList = jdbcTemplate.query(sql,new BeanPropertyRowMapper(c));
		return fullList;
	}
	
	public static <T> List<T> groupBy(String table, Class<T> c, Map condition){
		String sql = "SELECT * FROM " + table;
		String whereClause = "";
		
		for (Object key : condition.keySet()){
			if (whereClause.length() == 0){
				whereClause += " WHERE ";
			}else {
				whereClause += " AND ";
			}
			whereClause = whereClause + key + " = " + condition.get(key);
		}
		
		sql += whereClause;
		
		List<T> fullList = new ArrayList<T>();
		fullList  = jdbcTemplateStatic.query(sql,new BeanPropertyRowMapper(c));
		return fullList;
	}
	
	
}