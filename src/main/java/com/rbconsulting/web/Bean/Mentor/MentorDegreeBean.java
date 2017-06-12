package com.rbconsulting.web.Bean.Mentor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rbconsulting.web.Service.ArrayService;

@Configuration
public class MentorDegreeBean {

	private int id;
	private int mentorId;
	private int college;
	private int degreeType;
	private int major;
	private int status;
	
	public int getId(){
		return this.id;
	}
	
	public int getCollege(){
		return this.mentorId;
	}
	
	public int getMentorId(){
		return this.college;
	}
	
	public int getDegreeType(){
		return this.degreeType;
	}
	
	public int getMajor(){
		return this.major;
	}
	
	public int getStatus(){
		return this.status;
	}
	
	public void setId(int id){
		this.id = id ;
	}
	
	public void setMentorId(int mentorId){
		this.mentorId = mentorId;
	}
	
	public void setCollege(int college){
		this.college = college;
	}
	
	public void setDegreeType(int degreeType){
		this.degreeType = degreeType;
	}
	
	public void setMajor(int major){
		this.major = major;
	}
	
	public void setStatus(int status){
		this.status = status;
	}
}

//Create table MentorDegree (
//id int NOT NULL AUTO_INCREMENT,
//mentor_id int NOT NULL,
//college int DEFAULT 0,
//degree_type int DEFAUL 0,
//major int NOT NULL,
//status int NOT NULL DEFAULT 0,
//PRIMARY KEY (id)
//);