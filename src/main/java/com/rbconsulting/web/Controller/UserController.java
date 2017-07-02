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
import org.springframework.web.bind.annotation.PostMapping;

import com.rbconsulting.web.Action.UserAction;
import com.rbconsulting.web.Bean.*;
import com.rbconsulting.web.Bean.User.UserBean;
import com.rbconsulting.web.Form.*;

@Controller
@Component
public class UserController {
	@Autowired
	UserAction userAction;
	
    @GetMapping("/login")
    public String loginPage(WebRequest request, Model model, Error error) {
	    UserDto userDto = new UserDto();
	    System.out.println(error.toString());
	    model.addAttribute("user", userDto);
	    model.addAttribute("active", "login");
		return "/rlpage";
    }

    @GetMapping("/register")
	public String registerPage(WebRequest request, Model model) {
	    UserDto userDto = new UserDto();
	    model.addAttribute("user", userDto);
	    model.addAttribute("active", "register");
	    return "/rlpage";
	}

	@PostMapping("/register")
	public String registerUserUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result, WebRequest request, Errors errors, Model model) {    
	    UserBean registered = new UserBean();
	    if (!result.hasErrors()) {
	        registered = userAction.registerUser(userDto);
	    } else {
	    }
	    if (registered == null) {
	        result.rejectValue("email", "message.regError");
	    }
        if (result.hasErrors()) {
        	 System.out.println(userDto.toString());
        	 model.addAttribute("user", userDto);
        	 model.addAttribute("active", "register");
        	 model.addAttribute("notice", "Something wrong");
        	 return "rlpage";
        } else {
        	model.addAttribute("user", userDto);
        	model.addAttribute("active", "login");
        	model.addAttribute("notice", "You've registerd, please login");
            return "rlpage";
        }
	}


}