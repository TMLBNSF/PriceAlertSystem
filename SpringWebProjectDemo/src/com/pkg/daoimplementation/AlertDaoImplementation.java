package com.pkg.daoimplementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pkg.beans.Alert;
import com.pkg.beans.Item;
import com.pkg.daointerfaces.AlertDao;

@Component
public class AlertDaoImplementation implements AlertDao{

	
	@Autowired
	JdbcTemplate jdbc;
	

	@Override
	public boolean insertUserAlert(int itemId, int userId, String email, String carrier) {

		
		String sql = "INSERT INTO ALERT (ITEMID,EMAIL,USERID,CARRIER) VALUES(?,?,?,?)";			
		try {
			jdbc.update(sql,new Object[] {itemId,email,userId,carrier});	
		} catch (Exception e) {
			System.out.println("Duplicate");
			return false;
		}
			return true;
		
	}


	@Override
	public List<Alert> retrieveAlertList(int itemId) {
		
		
		List<Alert> alertList = new ArrayList<Alert>();
		String sql = "SELECT * FROM ALERT WHERE ITEMID = ?";
		alertList = jdbc.query(sql,new Object[]{itemId}, new AlertRowMapper());
		
		System.out.println(alertList.size());
		
		return alertList;
		
	}

}
