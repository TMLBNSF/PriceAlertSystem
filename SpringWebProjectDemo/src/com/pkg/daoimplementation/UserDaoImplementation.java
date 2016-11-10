package com.pkg.daoimplementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.pkg.beans.Item;
import com.pkg.beans.Users;
import com.pkg.daointerfaces.UserDao;



@Component
public class UserDaoImplementation  implements UserDao{

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public boolean insertUserInfo(Users user) {
		
		String sql = "INSERT INTO USERS (FIRSTNAME,LASTNAME,PASSWORD,PHONENUMBER,EMAIL,CARRIER) VALUES(?,?,?,?,?,?)";			
		try{
			jdbc.update(sql,new Object[] {user.getFirstname(),user.getLastname(),user.getPassword(),user.getPhonenumber(),user.getEmail(),user.getCarrier()});
		}
		catch(Exception e)
		{
			System.out.println("User already exists");
			return false;
		}
		
			return true;		
	}

	@Override
	public boolean retrieveUserInfo(String email,String password) {
		
		
		Users User= new Users();
		String sql = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ? ";
		try{
		User = jdbc.queryForObject(sql, new Object[] {email,password} , new UserRowMapper());
		}
		catch(Exception e)
		{
			System.out.println("duplicate");
			return false;
		}
		if(User!=null)
		{
			return true;
		}
		else
			return false;		

	}

	@Override
	public Users retrieveAUser(String userEmail) {
		
		Users user = new Users();
		String sql = "SELECT * FROM USERS WHERE EMAIL = ?";
		user = jdbc.queryForObject(sql, new Object[] {userEmail} , new UserRowMapper());
		return user;
		
	}

}

//ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:**/*.spring-dispatcher-servlet.xml");
//JdbcTemplate j = (JdbcTemplate) context.getBean("jdbcTemplate");
//JdbcTemplate j = new JdbcTemplate(dataSource);
//JdbcTemplate jdbc = new JdbcTemplate(dataSource);
//jdbc.setDataSource(dataSource);
//@Autowired
//DataSource dataSource;

/*	@Override
public List<Users> retrieveAllUserInfo() {
	
	List<Users> UserList= new ArrayList<Users>();
	String sql = "SELECT * FROM USERS WHERE EMAIL LIKE 'sri@gmail.com'";
	UserList = jdbc.query(sql, new UserRowMapper());
	
	System.out.println(UserList.size());
	return UserList;
	
	

}*/