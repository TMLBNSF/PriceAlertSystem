package com.pkg.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.pkg.beans.Users;
import com.pkg.daointerfaces.UserDao;

@Component
@Controller
@SessionAttributes("user1")
public class UserLoginController {

	@Autowired
	UserDao userDaoImplementation;
	//DataSource dataSource;
		
	@RequestMapping(value="/signup.html",method=RequestMethod.GET)
	public ModelAndView getAdmissionForm()
	{
		ModelAndView modelAndView = new ModelAndView("AngularJSRegistrationForm");
		return modelAndView;
		
	}

	@RequestMapping(value="/signin.html",method=RequestMethod.GET)
	public ModelAndView getSignInForm()
	{
		ModelAndView modelAndView = new ModelAndView("AngularJSLoginForm");
		return modelAndView;
		
	}
	
	/*@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/signin.html?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
*/
	/*@RequestMapping(value="/logout",method = RequestMethod.POST)
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/signin.html";
    }*/
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String page4(WebRequest request, SessionStatus status) 
	{   
		System.out.println("IN lOGOUT");
	    status.setComplete();
	    request.removeAttribute("user1", WebRequest.SCOPE_SESSION);
	    return "AngularJSLoginForm";
	}
	
	
	@RequestMapping(value="/submituser.html",method=RequestMethod.POST)
	public ModelAndView DisplayStudentObject(@Valid @ModelAttribute("user") Users user,BindingResult result) throws ClassNotFoundException, SQLException
	{
		// Used to redirect ; if there are any errors ...........!
		if(result.hasErrors())
		{
			ModelAndView modelAndView = new ModelAndView("AngularJSRegistrationForm");		
			return modelAndView;
		}
		
		//DaoImplementation Layer
		boolean checkNewUser = userDaoImplementation.insertUserInfo(user);
		if(checkNewUser==false)
		{
			ModelAndView modelAndView = new ModelAndView("AngularJSRegistrationForm");		
			modelAndView.addObject("errorRegistration", "User already exists");
			return modelAndView;			
		}
		
		
		Users user1 = userDaoImplementation.retrieveAUser(user.getEmail());
		//System.out.println("USER ID: "+user1.getUserid()+user1.getEmail()+user1.getFirstname());
		ModelAndView modelAndView = new ModelAndView("Home");	
		
		modelAndView.addObject("user1", user1);
		return modelAndView;
		 
	}
	
	@RequestMapping(value="/checkLogin.html",method= RequestMethod.POST )
	public ModelAndView login(@Valid @ModelAttribute("user") Users user)
	{
		
		boolean checklogin = userDaoImplementation.retrieveUserInfo(user.getEmail(), user.getPassword());
		
		if(checklogin == true)
		{
			Users user1 = userDaoImplementation.retrieveAUser(user.getEmail());
			ModelAndView model = new ModelAndView("Home");
			model.addObject("user1", user1);
			return model;
		}
		else
		{
			
			ModelAndView model = new ModelAndView("AngularJSLoginForm");
			model.addObject("error", "Wrong email/password");
			return model;
		}
	}
	
}

/*
String sql = "INSERT INTO USERS (FIRSTNAME,LASTNAME,PASSWORD,PHONENUMBER,EMAIL) VALUES(?,?,?,?,?)";

JdbcTemplate j = new JdbcTemplate(dataSource);

j.update(sql,new Object[] {user.getFirstname(),user.getLastname(),user.getPassword(),user.getPhonenumber(),user.getEmail()});
*/

//UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
//System.out.println(student2.getStudentName());
//System.out.println(user.getFirstname());
//List<Users> userList = userDaoImplementation.retrieveAllUserInfo();
//	System.out.println(userList);
//modelAndView.addObject("userList", userList );

//@RequestParam("email") String email, @RequestParam("password") String password