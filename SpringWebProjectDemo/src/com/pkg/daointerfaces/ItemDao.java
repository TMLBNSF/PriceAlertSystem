package com.pkg.daointerfaces;

import java.util.List;

import com.pkg.beans.Item;


public interface ItemDao {

	public List<Item> retrieveItem();
	public void updateItemPrice(int itemId,double itemPrice);
	public Item retrieveAnItem(int itemId);
}
