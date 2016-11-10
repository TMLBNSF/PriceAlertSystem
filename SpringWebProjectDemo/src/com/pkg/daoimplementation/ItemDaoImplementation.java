package com.pkg.daoimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pkg.beans.Item;
import com.pkg.beans.Users;
import com.pkg.daointerfaces.ItemDao;

@Component
public class ItemDaoImplementation implements ItemDao{

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<Item> retrieveItem() {
		
		
		List<Item> ItemList= new ArrayList<Item>();
		String sql = "SELECT * FROM item";
		ItemList = jdbc.query(sql, new ItemRowMapper());
		
		System.out.println(ItemList.size());
		return ItemList;
		
	}

	@Override
	public void updateItemPrice(int itemId, double itemPrice) {
		
		String sql = "UPDATE ITEM SET ITEM_PRICE = ? WHERE ITEM_ID = ?";			
		
		jdbc.update(sql,new Object[] {itemPrice,itemId});

	}

	@Override
	public Item retrieveAnItem(int itemId) {
		
		Item ItemList= new Item();
		String sql = "SELECT * FROM ITEM WHERE ITEM_ID = ?";
		ItemList = jdbc.queryForObject(sql, new Object[] {itemId}, new ItemRowMapper());
		
		//System.out.println(ItemList.size());
		return ItemList;
		
	}

}
