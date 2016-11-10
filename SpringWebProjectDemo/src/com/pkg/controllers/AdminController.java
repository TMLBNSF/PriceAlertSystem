package com.pkg.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pkg.beans.Alert;
import com.pkg.beans.Item;
import com.pkg.beans.Users;
import com.pkg.daointerfaces.AlertDao;
import com.pkg.daointerfaces.ItemDao;
import com.pkg.daointerfaces.UserDao;
import com.pkg.spring.Student;

@Component
@Controller
public class AdminController {

	
	@Autowired
	ItemDao itemDaoImplementation;
	
	@Autowired
	AlertDao alertDaoImplementation;
	
	
	@RequestMapping(value="/admin.html",method=RequestMethod.GET)
	public ModelAndView getAdmissionForm()
	{
		ModelAndView modelAndView = new ModelAndView("AdminForm");
		List<Item> itemList = itemDaoImplementation.retrieveItem();
		modelAndView.addObject("itemList", itemList );
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/updatePrice.html",method=RequestMethod.POST)
	public ModelAndView UpdateItemObject(@RequestParam("itemId") String itemId , @RequestParam("itemPrice") String price ) throws AddressException
	{
		
		int itemid = Integer.parseInt(itemId);
		Double itemPrice = Double.parseDouble(price);
		Item item = itemDaoImplementation.retrieveAnItem(itemid);
		double oldItemPrice = item.getItemPrice();
		itemDaoImplementation.updateItemPrice(itemid, itemPrice);
		Item newItem = itemDaoImplementation.retrieveAnItem(itemid);
		double newItemPrice = newItem.getItemPrice();
		String name = item.getItemName();
		ModelAndView model = new ModelAndView("AdminForm");
		
		// Write Alert Logic to Email and Phone Number
		List<Alert> alertList = alertDaoImplementation.retrieveAlertList(itemid);
		
		if(!alertList.isEmpty())
		{
			EmailController EC = new EmailController();
			EC.sendEmail(alertList,name,oldItemPrice,newItemPrice);
			PhoneController PC = new PhoneController();
			PC.sendMessages(alertList, name, oldItemPrice, newItemPrice);
		}

		List<Item> itemList = itemDaoImplementation.retrieveItem();
		model.addObject("success", "Successful Update");
		model.addObject("itemList", itemList);
		return model;
	
	}
	

}