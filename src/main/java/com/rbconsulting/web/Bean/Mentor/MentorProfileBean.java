package com.rbconsulting.web.Bean.Mentor;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rbconsulting.web.Service.ArrayService;


@Configuration
public class MentorProfileBean {

	private int mentorId;
	private String imageUrl;
	private int gender;
	private String description;
	private List<MentorDegreeBean> mentorDegrees;
	private String username;
	private String lastName;
	private String firstName;
	
	public int getMentorId(){
		return this.mentorId;
	}

	public String getImageUrlWithHost() {
		return "https://s3.eu-central-1.amazonaws.com/siyuanrainbow/img/mentor/img/" + this.imageUrl;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getImageUrl(){
		return this.imageUrl;
	}
	
	public int getGender(){
		return this.gender;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public List<MentorDegreeBean> getMentorDegrees(){
		return this.mentorDegrees;
	}
  	
	public void setMentorId(int mentorId){
		this.mentorId = mentorId;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}
	
	public void setGender(int gender){
		this.gender = gender;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setMentorDegrees(List<MentorDegreeBean> mentorDegrees){
		this.mentorDegrees = mentorDegrees;
	}

	public MentorDegreeBean getMentorHighestDegree(){
		MentorDegreeBean highest = null;
		int highestType = -1;
		for(MentorDegreeBean cur : this.mentorDegrees){
			if (cur.getDegreeType() > highestType){
				highest = cur;
				highestType = cur.getDegreeType();
			}
		}
		return highest;
	}
	
}

//Create table MentorProfile (
//mentor_id int NOT NULL,
//description MEDIUMTEXT,
//gender int NOT NULL DEFAULT 0,
//image_url VARCHAR(255),
//PRIMARY KEY (mentor_id)
//);

//Insert INTO MentorProfile Values  1, "老五喜欢打FIFA，马上要去加拿大买PS4", "1", "images+(1).jpeg");
//Insert INTO MentorProfile Values  2, "王开夫乐不思蜀", "2", "images.jpeg");