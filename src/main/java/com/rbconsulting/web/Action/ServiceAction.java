package com.rbconsulting.web.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.rbconsulting.web.Bean.Service.*;
import com.rbconsulting.web.Dao.ServiceDao;

@Configuration
public class ServiceAction {
	
	@Autowired
	private ServiceDao dao;
	
	@Bean(name = "getAllServiceType")
	public static List<ServiceType> getAllServiceType(){
		return ServiceType.getFullList();
	}
	
	@Bean(name = "getAllTypeService")
	public List<Service> getAllTypeService(){
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("type", 2);
		if (dao == null){
			System.out.println(1111);
			
		}
		return (List<Service>) dao.groupBy("Service", Service.class, map);
	}
	
}
