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
	
	public static Map<Object, Map> fullList = dao.getUniversityFullList();

    @Autowired
    public void setMentorDao(MentorDao dao){
    	UniversityAction.dao = dao;
    }
  

	
//	private Map getUniversityFullList() {
//		return dao.getUniversityFullList();
//	}
	
    @Bean(name = "getUniversityNameZHById")
	public static String getUniversityNameZHById(){
    	int id = 15;
		Map map = fullList.get(id);
		System.out.println(map.keySet().toString());
		return map.get("name_zh").toString();
	}
	
	
	
}
