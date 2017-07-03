package com.rbconsulting.web.Bean.Reference;

import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class College extends Reference{
	
	private static Map<Object, Map> fullList;
	
	public College(){
		this.table = "College";
	}
	
	@Override
	protected void setFullList(){
		fullList = dao.getFullList(this.table);
	}
	
	public static Map<Object, Map> getFullList(){
		return fullList;
	}
}
