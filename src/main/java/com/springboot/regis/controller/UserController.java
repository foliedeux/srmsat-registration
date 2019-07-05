package com.springboot.regis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.regis.model.User;
import com.springboot.regis.service.UserService;
import com.springboot.regis.validator.UserValidator;

@Controller
public class UserController implements WebMvcConfigurer{

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/submit";
	}
	@GetMapping("/submit")
	public String submit(User user) {
		//model.addAttribute("user", new User());
		
		return "submit";
	}
	
	@PostMapping("/submit")
	public String submit(@Valid User user, BindingResult bindingResult) {	
		userValidator.validate(user, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "submit";
		}
		userService.saveUser(user);
		
		return "redirect:/results";
	}
	
}
