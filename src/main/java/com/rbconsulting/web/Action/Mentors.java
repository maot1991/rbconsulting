package com.rbconsulting.web.Action;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rbconsulting.web.Service.ArrayService;

@Configuration
public class Mentors {
  	
  	@Bean(name = "allMentors")
    public String[] getAllMentors() {
  		String[] mentors = {"wkf", "zyd"};
        return mentors;
    }
  	
}
