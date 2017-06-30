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
public class DegreeType extends Reference{

	private static Map<Object, Map> fullList;
	
	public DegreeType(){
		this.table = "DegreeType";
	}
	
	@Override
	protected void setFullList(){
		fullList = dao.getFullList(table);
	}
	
	public static Map<Object, Map> getFullList(){
		return fullList;
	}
	
}