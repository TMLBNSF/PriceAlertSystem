package com.pkg.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.pkg.beans.Alert;
import com.pkg.beans.Item;
import com.pkg.beans.Users;
import com.pkg.daointerfaces.ItemDao;
import com.pkg.daointerfaces.UserDao;

@Component
@Controller
@SessionAttributes("itemList")
public class ItemSelectionController {

	@Autowired
	ItemDao itemDaoImplementation;
	
	@Autowired
	UserDao userDaoImplementation;
	
	
	
	@RequestMapping(value="/Detail.html",method=RequestMethod.POST)
	public ModelAndView ItemDisplay(@RequestParam("itemId") String itemId)
	{
		
		
		int itemid = Integer.parseInt(itemId);
		//int userid = Integer.parseInt(userId);
		
		ModelAndView modelAndView = new ModelAndView("Display");
		Item itemList = itemDaoImplementation.retrieveAnItem(itemid);
	
		modelAndView.addObject("itemList", itemList );
	
		//System.out.println(itemId+userId+email);
		
		return modelAndView;
		
		
	}
	


}
//Users userList = userDaoImplementation.retrieveAUser(userid);
//@Valid @ModelAttribute("alert") Alert alert
//modelAndView.addObject("userList", userList );
//int itemId = alert.getItemId();