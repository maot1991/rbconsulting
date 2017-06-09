package com.rbconsulting.web.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rbconsulting.web.Service.ArrayService;

@Configuration
public class MentorBean {
  	
  	@Bean(name = "allMentors")
    public String[] getAllMentors() {
  		String[] mentors = {"wkf", "zyd"};
        return mentors;
    }
}
  	