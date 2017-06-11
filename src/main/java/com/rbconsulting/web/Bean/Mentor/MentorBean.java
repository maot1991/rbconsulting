package com.rbconsulting.web.Bean.Mentor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rbconsulting.web.Bean.Account;
import com.rbconsulting.web.Service.ArrayService;

@Configuration
public class MentorBean extends Account{
  	  	
	public MentorBean(){
		super();
	}
}

// Create table Mentor (
//     id int NOT NULL AUTO_INCREMENT,
//     role_id int NOT NULL,
//     last_name varchar(255),
//     firt_name varchar(255),
//     username varchar(255),
//     email varchar(255) NOT NULL,
//     phone_number varchar(255) NOT NULL,
//     enabled int DEFAULT 0 NOT NULL,
//     password varchar(255) NOT NULL,
//     PRIMARY KEY (id)
// );