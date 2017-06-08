package com.daoIface;

import java.util.List;

import com.domain.Item;

public interface ProductToItemDaoIface {
	
	public List<Item> itemList(String productid);
	
}
