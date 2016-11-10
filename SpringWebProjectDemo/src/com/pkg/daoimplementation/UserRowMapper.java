package com.pkg.daoimplementation;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pkg.beans.Users;

public class UserRowMapper implements RowMapper<Users>{

	

	@Override
	public Users mapRow(ResultSet resultSet, int arg1) throws SQLException {
		
		
		UserExtractor userExtract= new UserExtractor();
		return userExtract.extractData(resultSet);
		
	}

}
