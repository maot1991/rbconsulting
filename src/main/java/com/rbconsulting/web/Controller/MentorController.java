package com.rbconsulting.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rbconsulting.web.Action.MentorsAction;
import com.rbconsulting.web.Action.UserAction;
import com.rbconsulting.web.Bean.*;
import com.rbconsulting.web.Bean.Mentor.MentorProfileBean;
import com.rbconsulting.web.Bean.User.UserBean;
import com.rbconsulting.web.Form.*;

@Controller
@Component
public class MentorController {
	
    @GetMapping("/mentor/{id}")
    public String getMentor(WebRequest request, Model model, Error error, @PathVariable("id") int id) {
	    MentorProfileBean mentor = MentorsAction.getMentorsById(id);
	    if (mentor == null){
	    	return "/";
	    }
	    model.addAttribute("mentor",mentor);
	    return "mentors/mentor";
    }
}