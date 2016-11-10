package com.pkg.daoimplementation;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.pkg.beans.Item;

public class ItemRowMapper implements RowMapper<Item>{

	

	@Override
	public Item mapRow(ResultSet resultSet, int arg1) throws SQLException {
		
		ItemExtractor itemExtract= new ItemExtractor();
		return itemExtract.extractData(resultSet);
	
	}

}
