package com.action;

import java.util.List;

import com.dao.productToItemDao.ProductToItemDao;
import com.domain.Item;

public class ProductToItemAction {
	
	private String productid;
	
	private List<Item> itemList;
	
	private String title;
	
	
	

	
	public String handle(){
		
		System.out.println("productid:::"+productid);
		System.out.println("title"+"::"+title);
		//通过productid来对item表进行查询
		ProductToItemDao productToItemDao=new ProductToItemDao();
		itemList=productToItemDao.itemList(productid);
		
		return "success";
	}
	
	
	
	
	
	
	//----------------------------------------
	
	
	
	
	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}






	public List<Item> getItemList() {
		return itemList;
	}






	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}






	public String getTitle() {
		return title;
	}






	public void setTitle(String title) {
		this.title = title;
	}

	
}
