package com.rbconsulting.web.Action;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rbconsulting.web.Service.ArrayService;

import com.rbconsulting.web.Bean.Mentor.*;
import com.rbconsulting.web.Dao.MentorDao;
import com.rbconsulting.web.Dao.UserDao;


@Configuration
public class UniversityAction {
  	
	@Autowired
	private MentorDao dao;
	
	private Map universities = dao.getUniversityFullList();
	
}
