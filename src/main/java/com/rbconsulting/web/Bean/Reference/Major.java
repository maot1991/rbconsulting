package com.rbconsulting.web.Bean.Reference;

import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class Major extends Reference {

	private static Map<Object, Map> fullList;
	
	public Major(){
		this.table = "Major";
	}
	
	@Override
	protected void setFullList(){
		fullList = dao.getFullList(table);
	}
	
	public static Map<Object, Map> getFullList(){
		return fullList;
	}
}
