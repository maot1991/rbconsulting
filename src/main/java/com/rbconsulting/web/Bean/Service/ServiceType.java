package com.rbconsulting.web.Bean.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.rbconsulting.web.Dao.ServiceDao;

@Component
@ComponentScan
public class ServiceType {
	private static String tableName;
	private int id;
	private String nameZh;
	private String nameEn;
	private String description;
	private static List<ServiceType> fullList;
	
	@Autowired
	private ServiceDao dao;
	
	@Autowired
	public void setFullList(){
		tableName = "ServiceType";
		fullList = (List<ServiceType>) dao.getFullListForClass(tableName, this.getClass());
	}
	
	public static List<ServiceType> getFullList(){
		return fullList;
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
	
	public String getDescription(){
		return this.description;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
//
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	
	public List<Service> getAllTypeService(){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("type", this.id);
//		if (dao == null){
//			System.out.println("servicedao null\n");
//			dao = new ServiceDao();
//		}
		return (List<Service>) ServiceDao.groupBy("Service", Service.class, map);
	}
	
}