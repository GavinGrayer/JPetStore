package com.action.CartAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.domain.Cart;

public class RemoveCartAction {
	
	private String itemid;
	
	private Cart cartflag;
	
	public String remove(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		HttpSession session=request.getSession();

		List<Cart> cartNewList=(List<Cart>) session.getAttribute("cartList");
		
		System.out.println(itemid);
		


			for(Cart cart:cartNewList){
				
				System.out.println(cart.getItem().getItemid());
				
				System.out.println(cart.getId());
				
				if(cart.getItem().getItemid().equals(itemid)){

//					cartNewList.remove(cart);
//					
//					session.setAttribute("cartList", cartNewList);
					cartflag=cart;
					
				}
				
				
			}

		/**
		 * ConcurrentModificationException::
		 * 不可在遍历里面进行增加或删除，否则会报错
		 */
		cartNewList.remove(cartflag);
	//	session.setAttribute("cartList", cartNewList);
		
		
		
		
		return "success";
	}


	public String getItemid() {
		return itemid;
	}


	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	
	
	
	
}
