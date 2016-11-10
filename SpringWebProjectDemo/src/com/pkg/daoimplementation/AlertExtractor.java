package com.pkg.daoimplementation;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pkg.beans.Alert;
import com.pkg.beans.Users;

public class AlertExtractor implements ResultSetExtractor<Alert>{


	@Override
	public Alert extractData(ResultSet resultSet) throws SQLException, DataAccessException {

		Alert alert = new Alert();
		
		alert.setAlertid(Integer.parseInt(resultSet.getString("ALERTID")));
		alert.setEmail(resultSet.getString("EMAIL"));
		alert.setItemId(Integer.parseInt(resultSet.getString("ITEMID")));
		alert.setCarrier(resultSet.getString("CARRIER"));
		//alert.setPhonenumber(Integer.parseInt(resultSet.getString("PHONENUMBER")));
		alert.setUserid(Integer.parseInt(resultSet.getString("USERID")));
		
		return alert;
		
	}

}
