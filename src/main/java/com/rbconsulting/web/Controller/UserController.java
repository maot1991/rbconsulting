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
    public String loginPage() {
		return "/user/login";
    }

  //   @GetMapping("/register")
  //   public String registerPage() {
		// return "/user/register";
  //   }

    @GetMapping("/register")
	public String registerPage(WebRequest request, Model model) {
	    UserDto userDto = new UserDto();
	    model.addAttribute("user", userDto);
	    return "/user/register";
	}

	@PostMapping("/register")
	public String registerUserUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result, WebRequest request, Errors errors) {    
	    UserBean registered = new UserBean();
	    if (!result.hasErrors()) {
	        registered = userAction.registerUser(userDto);
	        System.out.println("11111 ==== \n");
	    }
//	    if (registered == null) {
//	        result.rejectValue("email", "message.regError");
//	        System.out.println("222222 ==== \n");
//	    }
	    System.out.println("333333 ==== \n");
	    // rest of the implementation
	    return "/index";
	}
	// private User createUserUser(UserDto userDto, BindingResult result) {
	//     User registered = null;
	//     try {
	//         registered = service.registerNewUserUser(userDto);
	//     } catch (EmailExistsException e) {
	//         return null;
	//     }    
	//     return registered;
	// }


}