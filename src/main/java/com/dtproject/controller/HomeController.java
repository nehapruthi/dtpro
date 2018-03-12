package com.dtproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dtproject.model.User;
import com.dtproject.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/","home"})
	public String home(HttpServletRequest request) {
		System.out.println("home controller");
		
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		//User user=(User) session.getAttribute("activeUser");
		System.out.println(username);
		if(username!=null && !username.equals("anonymousUser") )
		{
			HttpSession session=request.getSession();
			User user=userService.findUserByName(username);
			System.out.println(user.getuName()+"  "+user.getCartId());
			session.setAttribute("activeUser", user);
		}
		
		
		return "home";
	}

}
