package com.rbconsulting.web.Action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rbconsulting.web.Service.ArrayService;

import com.rbconsulting.web.Bean.Mentor.*;
import com.rbconsulting.web.Dao.MentorDao;
import com.rbconsulting.web.Dao.UserDao;

@Configuration
public class MentorsAction {
  	
	@Autowired
	private MentorDao dao;
	
  	@Bean(name = "allMentors")
    public Object[] getAllMentors() {
//  		String[] mentors = {"wkf", "zyd"};
  		System.out.println("asdasdasdasdasd \n");

  		List<MentorProfileBean> objs = dao.getAllMentorProfiles();
  		for (MentorProfileBean obj : objs){
  			List<MentorDegreeBean> degrees = dao.getMentorDegrees(obj.getMentorId());
  			obj.setMentorDegrees(degrees);
  		}
  		
  		return objs.toArray();
//  		System.out.println("asdasdgdfhjhkghjkghjkhjkhj \n");
//        return mentors;
    }
  	
  	public void getMentorsBy(){
  		
  	}
  	
//  	public Object[] getPromotedMentors()	{
//  		
//  		
//  		return 
//  	}
}
