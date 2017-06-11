package com.rbconsulting.web.Bean.User;

public class UserBean {
	private int id;
	private String username;
	private String password;
	private String email;

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	
}

// Create table User (
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