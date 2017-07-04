package com.rbconsulting.web.Bean.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rbconsulting.web.Dao.ServiceDao;

public class ServiceContent {
	private int id;
	private int serviceId;
	private int serviceItemId;
	private int count;
	private String description;
	private ServiceItem serviceItem;
	
	public int getId(){
		return this.id;
	}
	
	public int getServideId(){
		return this.serviceId;
	}
	
	public int getServiceItemId(){
		return this.serviceItemId;
	}
	
	public int getCount(){
		return this.count;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setId(int id){
		this.id = id;
	}
	public void setServideId(int serviceId){
		this.serviceId = serviceId;
	}
	
	public void setServiceItemId(int serviceItemId){
		this.serviceItemId = serviceItemId;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	
	public void setDescription(String description){
		if (description == null) return;
		this.description = description;
	}
	
	public ServiceItem getServiceItem(){
		if (this.serviceItem == null){
			setServiceItem();
		}
		return this.serviceItem;
	}
	
	private void setServiceItem() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("id", this.serviceItemId);
		List<ServiceItem> res = ServiceDao.groupBy("ServiceItem", ServiceItem.class, map);
		if (res.size() > 0) this.serviceItem = res.get(0);
	}
	
}
