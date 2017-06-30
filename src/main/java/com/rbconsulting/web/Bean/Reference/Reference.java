package com.rbconsulting.web.Bean.Reference;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.rbconsulting.web.Dao.ReferenceDao;

public class Reference {
	
	protected int id;
	protected String nameEN;
	protected String nameZH;
	
	protected static ReferenceDao dao;
//	private static Map<Object, Map> fullList;
	protected String table;
	
	@Autowired
	public void setStaticMembers(ReferenceDao referenceDao){
		dao = referenceDao;
		setFullList();
//		this.fullList = this.dao.getFullList(table);
	}
	
	protected void setFullList(){
		
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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNameZH(String nameZH) {
		this.nameZH = nameZH;
	}
//
	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}
	
	public static String getName(Map<Object, Map> fullList, int id, String lang) {
		Map map = fullList.get(id);
		if (map == null){
			return "";
		}
		Object value = map.get("name_"+lang);
		if (value == null){
			return "";
		}
		return value.toString();
	}
}
