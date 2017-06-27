package com.rbconsulting.web.Bean.Reference;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.rbconsulting.web.Action.UniversityAction;
import com.rbconsulting.web.Dao.*;

@Component
@ComponentScan
public class University {
	private static MentorDao dao;
	public static Map<Object, Map> fullList;

	@Autowired
	public void setStaticMembers(MentorDao mentorDao){
		dao = mentorDao;
		fullList = dao.getUniversityFullList();
	}
  
	private int id;
	private String nameEN;
	private String nameZH;
	private String countryCode;
	
	public static Map<Object, Map> getFullList(){
		return fullList;
	}
		
	public int getId() {
		return id;
	}

	public String getNameZH() {
		return this.nameZH;
	}

	public String getNameEN() {
		return this.nameEN;
	}
	
	public String getCountryCode() {
		return this.countryCode;
	}
	
	public void setNameZH(String nameZH) {
		this.nameZH = nameZH;
	}
//
	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public static String getNameZH(int id){
		Map map = fullList.get(id);
		return map.get("name_zh").toString();
	}

}