package com.rbconsulting.web.Action;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.rbconsulting.web.Dao.MentorDao;

//@Service
public class UniversityAction {
	
	private static MentorDao dao;
	public static String test = "yiyayiyayo";
	
    @Autowired
    public void setMentorDao(MentorDao dao){
    	UniversityAction.dao = dao;
    }
  

	
	
	
}
