package com.action.OrderAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.OrderDao.OrderDao;
import com.domain.Cart;
import com.domain.Orders;

public class ShippingFormAction {
	
	private Orders orders;
	private List<Cart> cartList;
	private Double sum;
	
	public String handle(){//¶©¹º³É¹¦
		
		
		OrderDao dao=new OrderDao();
		
		//System.out.println("111111"+orders.getCreditcard());
		
		dao.success(orders);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		HttpSession session=request.getSession();
		
		cartList=(List<Cart>) session.getAttribute("usercartList");
		sum=(Double) session.getAttribute("sum");
		
		
		return "success";
	}


	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}


	public List<Cart> getCartList() {
		return cartList;
	}


	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}


	public Double getSum() {
		return sum;
	}


	public void setSum(Double sum) {
		this.sum = sum;
	}
	
	
}
