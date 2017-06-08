package com.rbconsulting.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

// import com.rbconsulting.web.Greeting;

@Controller
public class LandingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/")
	public String landingPage(Model model) {
		return "/index";
	}

	@RequestMapping("/index")
	public String indexPage(Model model) {
		return "/index";
	}

	@RequestMapping("/staff")

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }


}
