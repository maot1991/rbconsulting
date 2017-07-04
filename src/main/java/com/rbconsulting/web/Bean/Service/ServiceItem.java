package com.rbconsulting.web.Bean.Service;

public class ServiceItem {
	private int id;
	private String nameZh;
	private String nameEn;
	private String shortName;
	
	public int getId() {
		return id;
	}

	public String getNameZh() {
		return this.nameZh;
	}

	public String getNameEn() {
		return this.nameEn;
	}
	
	public String getShortName() {
		return this.shortName;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}
//
	public void setNameEn(String nameEn) {
		if (nameEn == null) return;
		this.nameEn = nameEn;
	}
	
	public void setShortName(String shortName) {
		if (shortName == null) return;
		this.shortName = shortName;
	}
	
	
}
