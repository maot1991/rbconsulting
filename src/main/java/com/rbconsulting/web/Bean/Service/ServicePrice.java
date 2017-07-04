package com.rbconsulting.web.Bean.Service;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class ServicePrice {
	private int id;
	private int serviceId;
	private int type;
	private String currency;
	private double basePrice;
	private String basePriceCondition;
	private double extraPrice;
	private String extraPriceCondition;
	
	public int getId(){
		return this.id;
	}
	
	public int getServideId(){
		return this.serviceId;
	}
	
	public int getType(){
		return this.type;
	}
	
	public String getCurrency(){
		return this.currency;
	}
	
	public double getBasePrice(){
		return this.basePrice;
	}
	
	public String getBasePriceCondition(){
		return this.basePriceCondition;
	}
	
	public double getExtraPrice(){
		return this.extraPrice;
	}
	
	public String getExtraPriceCondition(){
		return this.extraPriceCondition;
	}
	
	public void setId(int id){
		this.id = id;
	}
	public void setServideId(int serviceId){
		this.serviceId = serviceId;
	}
	
	public void setType(int type){
		this.type = type;
	}
	
	public void setCurrency(String currency){
		this.currency = currency;
	}
	
	public void setBasePrice(double basePrice){
		this.basePrice = basePrice;
	}
	
	public void setBasePriceCondition(String basePriceCondition){
		if (basePriceCondition == null) return;
		this.basePriceCondition = basePriceCondition;
	}
	
	public void setExtraPrice(double extraPrice){
		this.extraPrice = extraPrice;
	}
	
	public void setExtraPriceCondition(String extraPriceCondition){
		if (extraPriceCondition == null) return;
		this.extraPriceCondition = extraPriceCondition;
	}
	
	public String getPriceTypeDisplay(){
		switch (this.type) {
			case 1 :  return "留学生";
			case 2 :  return "本土学生";
			case 3 :  return "助教";
			default : return "标准";
		}
	}
	
	public String getBasePriceDisplay(){
		String valuePart = "";
		if ("USD".equals(this.currency)){
			valuePart += "$"+this.basePrice;
		}else {
			valuePart += currency + this.basePrice;
		}
		if (basePriceCondition != null && basePriceCondition.length() > 0){
			return valuePart + "/" + basePriceCondition;
		}
		return valuePart;
	}
	
	public String getExtraPriceDisplay(){
		if (this.extraPrice <= 0){
			return "";
		}
		String valuePart = "";
		if ("USD".equals(this.currency)){
			valuePart += "$"+this.extraPrice;
		}else {
			valuePart += currency + this.extraPrice;
		}
		if (extraPriceCondition != null && extraPriceCondition.length() > 0){
			return valuePart + "/" + extraPriceCondition;
		}
		return valuePart;
	}
}
