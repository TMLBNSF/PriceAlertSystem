package com.pkg.daoimplementation;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pkg.beans.Item;
import com.pkg.beans.Users;

public class ItemExtractor implements ResultSetExtractor<Item>{

	

	@Override
	public Item extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		
		Item item = new Item();
		
		item.setItemCategory(resultSet.getString("ITEM_CATEGORY"));
		item.setItemColor(resultSet.getString("ITEM_COLOR"));
		item.setItemId(Integer.parseInt(resultSet.getString("ITEM_ID")));
		item.setItemName(resultSet.getString("ITEM_NAME"));
		item.setItemModel(resultSet.getString("ITEM_MODEL"));
		item.setItemPrice(Double.parseDouble(resultSet.getString("ITEM_PRICE")));
		
		return item;
		
		
	}

}
