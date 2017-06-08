package com.action.ListOrdersAction;

import java.util.List;

import com.dao.ListOrdersDao.ListOrdersDao;
import com.domain.Orders;

public class ListOrdersAction {
	
	private List<Orders> ordersList;
	
	public String query(){
		
		ListOrdersDao dao=new ListOrdersDao();
		
		ordersList=dao.findOrderList();
		
		
		
		return "success";
	}

	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	
	
	
}
