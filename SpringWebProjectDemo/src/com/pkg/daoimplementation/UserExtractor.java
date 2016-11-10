package com.pkg.daoimplementation;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pkg.beans.Users;

public class UserExtractor implements ResultSetExtractor<Users>{

	@Override
	public Users extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		
		Users user = new Users();
		user.setEmail(resultSet.getString("EMAIL"));
		user.setFirstname(resultSet.getString("FIRSTNAME"));
		user.setLastname(resultSet.getString("LASTNAME"));
		user.setPassword(resultSet.getString("PASSWORD"));
		user.setPhonenumber(resultSet.getString("PHONENUMBER"));
		user.setUserid(Integer.parseInt(resultSet.getString("USERID")));
		user.setCarrier(resultSet.getString("CARRIER"));
		return user;
		
	}

	
}
