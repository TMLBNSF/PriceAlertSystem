package com.pkg.spring;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Component
@Controller
public class StudentAdmissionController {

	
	@Autowired
	DataSource dataSource;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		//binder.setDisallowedFields(new String[] {"studentMobile"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.mm.dd");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat,false));
	}
	
	
	@RequestMapping(value="/admissionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmissionForm()
	{
		ModelAndView modelAndView = new ModelAndView("AdmissionForm");
		return modelAndView;
		
	}
	
	//This is the first method to be executed....!
	@ModelAttribute
	public void addModelObject(Model model)
	{
		model.addAttribute("headerMessage", "Student Admission");
	}
	
	//ModelAttribute Will create bean object and pass all values here
	@RequestMapping(value="/submitNewInfo.html",method=RequestMethod.POST)
	public ModelAndView DisplayStudentObject(@Valid @ModelAttribute("student1") Student student1,BindingResult result)
	{
		// Used to redirect ; if there are any errors ...........!
		if(result.hasErrors())
		{
			ModelAndView modelAndView = new ModelAndView("AdmissionForm");		
			//System.out.println(student2.getStudentName());
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("ApplicationSuccess");		
		System.out.println(student1.getStudentName());
		return modelAndView;
		 
	}
	
	@RequestMapping(value="/submitInfo.html",method=RequestMethod.POST)
	public ModelAndView DisplayAdmissionForm(@RequestParam(value="studentName",defaultValue="OM") String sName , @RequestParam("studentHobby") String sHobby)
	{
		ModelAndView modelAndView = new ModelAndView("ApplicationSuccess");
			
		Student student1 = new Student();
		student1.setStudentName(sName);
		student1.setStudentHobby(sHobby);
		
		modelAndView.addObject("message",student1);
		
		
		return modelAndView;
		 
	}
	
	
	
	@RequestMapping(value="/personInfo",method=RequestMethod.GET)
	public ModelAndView getPersonForm()
	{
		ModelAndView modelAndView = new ModelAndView("personInfo");
		return modelAndView;
		
	}
	
	
	@RequestMapping(value="/submitPersonInfo.html",method=RequestMethod.POST)
	public ModelAndView DisplayPersonObject(@Valid @ModelAttribute("person1") Person person1,BindingResult result)
	{
		
		
		
		// Used to redirect ; if there are any errors ...........!
		if(result.hasErrors())
		{
			ModelAndView modelAndView = new ModelAndView("personInfo");		
			//System.out.println(student2.getStudentName());
			return modelAndView;
		}
		
		String sql = "INSERT INTO STUDENT (ID,NAME,AGE) VALUES(?,?,?)";
		
		JdbcTemplate j = new JdbcTemplate(dataSource);
		
		ModelAndView modelAndView = new ModelAndView("displayPerson");		
		
		j.update(sql,new Object[] {person1.getId(),person1.getName(),person1.getAge()});
		
		System.out.println(person1.getName());
		return modelAndView;
		 
	}
	
	
}
