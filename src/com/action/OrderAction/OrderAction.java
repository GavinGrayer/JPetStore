package com.action.OrderAction;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.OrderDao.OrderDao;
import com.domain.Cart;
import com.domain.Orders;

public class OrderAction {
	
	private Orders orders;
	private String flag;
	
	private List<Cart> cartList;
	private Double sum;
	
	public String handleOrder(){
		

		System.out.println(flag+"::"+orders.getBilladdr1()+"::"+orders.getAccount().getStatus());
		
		System.out.println(orders.getAccount().getUserid());
		
		if(flag.equals("1")){//不同的送货地址
			
			return "success";
			
		}else{//订购成功
			
			OrderDao dao=new OrderDao();
			dao.success(orders);
			
			HttpServletRequest request=ServletActionContext.getRequest();
			
			HttpSession session=request.getSession();
			
			cartList=(List<Cart>) session.getAttribute("usercartList");
			sum=(Double) session.getAttribute("sum");
			
			return "error";
			
		}
		
		
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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
