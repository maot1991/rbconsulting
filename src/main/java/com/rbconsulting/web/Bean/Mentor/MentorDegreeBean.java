package com.rbconsulting.web.Bean.Mentor;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rbconsulting.web.Service.ArrayService;
import com.rbconsulting.web.Bean.Reference.*;

@Configuration
public class MentorDegreeBean {

	private int id;
	private int mentorId;
	private int university;
	private int college;
	private int degreeType;
	private int major;
	private int status;
	
	public int getId(){
		return this.id;
	}
	
	public int getMentorId(){
		return this.mentorId;
	}

	public int getUniversity(){
		return this.university;
	}
	
	public int getCollege(){
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

	public void setUniversity(int university){
		this.university = university;
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
	
//	public void getUniversityName(){
//		System.out.println(University.test123);
//	}
//
	public String getUniversityName() {
		String name = University.getNameZH(this.id);
		return name;

     }
//	
//	public String getDegreeUniversity(){
//		return 
//	}
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