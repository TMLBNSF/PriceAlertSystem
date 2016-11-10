package com.pkg.controllers;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;

import com.pkg.beans.Alert;

@Controller
public class EmailController {

	
	public void sendEmail(List<Alert> alertList,String name,double oldPrice,double newPrice) {
		
	// String[] to = {"srikanthvrns@gmail.com","bnswain@gmail.com","shridhar.yadav88@gmail.com"};//change accordingly  
	 InternetAddress[] cc = new InternetAddress[alertList.size()]; 
	 for(int i=0;i<alertList.size();i++){
		 try {
			cc[i] = new InternetAddress(alertList.get(i).getEmail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
  //Get the session object  
  Properties props = new Properties();  
  props.put("mail.smtp.host", "smtp.gmail.com");  
  props.put("mail.smtp.socketFactory.port", "465");  
  props.put("mail.smtp.socketFactory.class",  
            "javax.net.ssl.SSLSocketFactory");  
  props.put("mail.smtp.auth", "true");  
  props.put("mail.smtp.port", "465");  
   
  Session session = Session.getDefaultInstance(props,  
   new javax.mail.Authenticator() {  
   protected PasswordAuthentication getPasswordAuthentication() {  
   return new PasswordAuthentication("productalert9@gmail.com","12345Qwerty");//change accordingly  
   }  
  });  
   
  //compose message  
  try {  
   MimeMessage message = new MimeMessage(session);  
   message.setFrom(new InternetAddress("productalert9@gmail.com"));//change accordingly  
   //message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
   message.addRecipients(Message.RecipientType.BCC, cc);
   message.setSubject("Alert From Shopping Website: PRODUCT NAME - "+name+"\n");  
   message.setText("\n ITEM NAME "+name+" \n OLD PRICE "+oldPrice +" \n NEW PRICE "+newPrice);  
     
   //send message  
   Transport.send(message);  
  
   System.out.println("message sent successfully");  
   
  } catch (MessagingException e) {throw new RuntimeException(e);}  
   
	}
}
