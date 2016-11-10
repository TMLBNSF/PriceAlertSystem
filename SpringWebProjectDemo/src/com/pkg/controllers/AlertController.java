package com.pkg.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pkg.daoimplementation.AlertDaoImplementation;

@Controller
@Component
public class AlertController {

	
	@Autowired
	AlertDaoImplementation alertDaoImplementation;


	@RequestMapping(value="/setAlert.html",method=RequestMethod.POST)
	public ModelAndView setAlert(@RequestParam("itemId") String itemId, @RequestParam("email") String email,@RequestParam("userId") String userId,@RequestParam("carrier") String carrier ) throws SQLException
	{
		ModelAndView modelAndView;
		int userid;
		int itemid = Integer.parseInt(itemId);
		try{
				userid = Integer.parseInt(userId);
			}
		catch(Exception e){
			modelAndView = new ModelAndView("AngularJSLoginForm");
			modelAndView.addObject("sessionexpire", "SESSION EXPIRED.. Please Login");
			return modelAndView;
		}
		modelAndView = new ModelAndView("Display");
		boolean checkAlert = alertDaoImplementation.insertUserAlert(itemid, userid, email,carrier);
		
		if (checkAlert == false)
		{
			modelAndView.addObject("alertError", "Alert Already Exists");
		}
		else
		{
			modelAndView.addObject("alertError", "Alert Set Succesfully");
		}
	
		return modelAndView; 
	}
	

}
