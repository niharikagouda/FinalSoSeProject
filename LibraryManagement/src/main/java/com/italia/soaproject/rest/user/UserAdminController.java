package com.italia.soaproject.rest.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.italia.soaproject.rest.user.database.UserDatabase;
import com.italia.soaproject.rest.user.database.UserDatabaseImpl;
import com.italia.soaproject.rest.user.model.Login;

@Controller
public class UserAdminController {

	//make object of userdatabase(ehere all functions declaration are there)
	private UserDatabase udb = new UserDatabaseImpl();
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("loginForm") Login login,  HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("index");
		
		System.out.println(login.getLoginId());
		System.out.println(login.getPassword());
		
		//calling of isValidUser()
		Login login1 = udb.isValidUser(login);
		//if no data stay in login page...if data is there then go to admin and home page.
		if(login1 == null) {
			return mav;
		} else {
			if(login1.isAdmin()) {
				ModelAndView mv = new ModelAndView("admin");
				
				//using the variables in jsp pages for like which username or userid issued the book or loged in.
				mv.addObject("userName", login1.getUsername());
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("home");
				mv.addObject("userId", login.getLoginId());
				mv.addObject("userName", login1.getUsername());
				return mv;
			}
		}
		
	}
	
	
	
	

}
