package com.pkg.controllers;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@Controller
public class RdirectController {

	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String redirectToIndexPage()
	{
		return "AngularJSLoginForm";
	}

	
	@RequestMapping(value="/Home.html",method=RequestMethod.GET)
	public String redirectToHomePage()
	{
		return "Home";
	}
	
	@RequestMapping(value="/Clothes.html",method=RequestMethod.GET)
	public String redirectToClothesPage()
	{
		return "Clothes";
	}
	
	@RequestMapping(value="/Trouser.html",method=RequestMethod.GET)
	public String redirectToTrouserPage()
	{
		return "Trouser";
	}
	
	@RequestMapping(value="/Shirt.html",method=RequestMethod.GET)
	public String redirectToShirtPage()
	{
		return "Shirt";
	}
	
	@RequestMapping(value="/Gadgets.html",method=RequestMethod.GET)
	public String redirectToGadgetsPage()
	{
		return "Gadgets";
	}
	
	@RequestMapping(value="/Laptop.html",method=RequestMethod.GET)
	public String redirectToLaptopPage()
	{
		return "Laptop";
	}
	
	@RequestMapping(value="/CellPhone.html",method=RequestMethod.GET)
	public String redirectToCellphonePage()
	{
		return "Cellphone";
	}
	
	
	@RequestMapping(value="/Contact.html",method=RequestMethod.GET)
	public String redirectToAboutPage()
	{
		return "Contact";
	}
	
	@RequestMapping(value="/About.html",method=RequestMethod.GET)
	public String redirectToContactPage()
	{
		return "About";
	}
	
	@RequestMapping(value="/registration",method=RequestMethod.GET)
	public String redirectToRegistrationPage()
	{
		return "AngularJSRegistrationForm";
	}
	
}
