package com.pkg.daoimplementation;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pkg.beans.Alert;

public class AlertRowMapper implements RowMapper<Alert>{

	
	@Override
	public Alert mapRow(ResultSet resultSet, int arg1) throws SQLException {

		AlertExtractor alertExtract= new AlertExtractor();
		return alertExtract.extractData(resultSet);
		
	}

	
}
