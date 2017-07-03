package com.rbconsulting.web.Bean.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.rbconsulting.web.Dao.ServiceDao;

public class Service {
	
	protected int id;
	protected int type;
	protected String nameEn;
	protected String nameZh;
	protected String description;
	protected int period;
	protected int iteration;
	protected String depth;
	
	protected static ServiceDao dao;
	private static Map<Object, Map> fullList;
	protected String table;
	
	@Autowired
	public void setStaticMembers(ServiceDao serviceDao){
		dao = serviceDao;
		this.table = "Service";
	}
	
	protected void setFullList(){
		fullList = dao.getFullList(table);
	}
	
	public int getId() {
		return id;
	}

	public String getNameZh() {
		return this.nameZh;
	}

	public String getNameEn() {
		return this.nameEn;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}
//
	public void setNameEN(String nameEN) {
		this.nameEn = nameEn;
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
	
//	public List<Service> getServiceItems() {
//		return dao.groupBy("ServiceContent", this.getClass(), null);
//	}
}
