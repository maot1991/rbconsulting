package com.rbconsulting.web.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rbconsulting.web.Service.ArrayService;

import com.rbconsulting.web.Bean.Mentor.*;
import com.rbconsulting.web.Bean.Mentor.MentorProfileBean;
import com.rbconsulting.web.Dao.Dao;
import com.rbconsulting.web.Dao.MentorDao;
import com.rbconsulting.web.Dao.UserDao;

@Configuration
public class MentorsAction {
  	
	@Autowired
	private MentorDao dao;
	
  	@Bean(name = "allMentors")
    public Object[] getAllMentors() {
//  		String[] mentors = {"wkf", "zyd"};

  		List<MentorProfileBean> objs = dao.getAllMentorProfiles();
  		for (MentorProfileBean obj : objs){
  			List<MentorDegreeBean> degrees = dao.getMentorDegrees(obj.getMentorId());
  			obj.setMentorDegrees(degrees);
  		}
  		
  		return objs.toArray();
//  		System.out.println("asdasdgdfhjhkghjkghjkhjkhj \n");
//        return mentors;
    }
  	
  	public static List<MentorDegreeBean> getMentorDegrees(int id){
  		Map<Object,Object> map = new HashMap<Object,Object>();
  		map.put("mentor_id", id);
  		List<MentorDegreeBean> degrees = MentorDao.groupBy("MentorDegree", MentorDegreeBean.class, map);
  		return degrees;
  	}
  	
  	@Bean(name = "getPromotedMentors")
    public Object[] getPromotedMentors() {
//  		String[] mentors = {"wkf", "zyd"};

  		List<MentorProfileBean> objs = dao.getPromotedMentorProfiles();
  		for (MentorProfileBean obj : objs){
  			List<MentorDegreeBean> degrees = dao.getMentorDegrees(obj.getMentorId());
  			obj.setMentorDegrees(degrees);
  		}
  		
  		return objs.toArray();
//  		System.out.println("asdasdgdfhjhkghjkghjkhjkhj \n");
//        return mentors;
    }
  	
  	public static MentorProfileBean getMentorsById(int id){
  		MentorProfileBean mentor = MentorDao.queryByColumn("MentorProfile", MentorProfileBean.class,"mentor_id", id);
  		mentor.setMentorDegrees(getMentorDegrees(id));
  		return mentor;
  	}
  	
//  	public Object[] getPromotedMentors()	{
//  		
//  		
//  		return 
//  	}
}
