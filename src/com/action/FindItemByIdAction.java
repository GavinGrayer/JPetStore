package com.action;

import java.io.UnsupportedEncodingException;

import com.dao.FindItemByIdDao;
import com.domain.Item;

public class FindItemByIdAction {
		
	private String itemid;
	
	private Item item;
	
	private String productname;

	private String qty;
	
	private String listprice;
	
	private String productid; 
	
	private String path;//图片路径
	
	private String inforMsg;
	
	private String title;
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInforMsg() {
		return inforMsg;
	}

	public void setInforMsg(String inforMsg) {
		this.inforMsg = inforMsg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getListprice() {
		return listprice;
	}

	public void setListprice(String listprice) {
		this.listprice = listprice;
	}



	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getItemid() {
		
		System.out.println("get...");
		return itemid;
		
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
		System.out.println("set...");
	}
	
	public String itemContext(){
		
		FindItemByIdDao findItemByIdDao=new FindItemByIdDao();
		
		
		
		try {
			productname=new String(productname.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("productname::"+productname+"itemid::"+itemid);
		
		item=findItemByIdDao.itemContext(itemid);
		
		//库存
		qty=findItemByIdDao.queryQTY(itemid);
		
		//在FindItemByIdDao里写一个方法，查询img src***********************
		String path1=findItemByIdDao.queryImgPath(productid);
		
		String pathAndContext[]=path1.split(":");
		
		path=pathAndContext[0];
		
		inforMsg=pathAndContext[1];
		
		System.out.println("title"+title);
		
		return "success";
	}
	

	
}
