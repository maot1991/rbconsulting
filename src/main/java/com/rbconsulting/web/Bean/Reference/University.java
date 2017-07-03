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
public class University extends Reference{
	
	private static Map<Object, Map> fullList;
	
	public University(){
		super();
		this.table = "University";
	}
	
	@Override
	protected void setFullList(){
		fullList = dao.getFullList(table);
	}
	
	public static Map<Object, Map> getFullList(){
		return fullList;
	}
	
 
	private String countryCode;
		
	public String getCountryCode(){
		return this.countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}