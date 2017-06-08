package com.action.CartAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.CartDao.CartDao;
import com.domain.Cart;
import com.domain.Item;

public class UpdateCartAction {
	
	private String inStock[]=new String[20];//����
	
	private List<Cart> cartList=new ArrayList<Cart>();//�û����ﳵʹ��
	
	private List<Double> allpriceList=new ArrayList<Double>();//���ܼ۸�ͨ��session����checkoutAction
	
	private List<String> numberList=new ArrayList<String>();//������
	
	public String updateCart(){//�޸��ܼ۸�     
		
		HttpServletRequest request2=ServletActionContext.getRequest();
		
		HttpSession session2=request2.getSession();
		
		String username=(String) session2.getAttribute("username") == null ? null : (String) session2.getAttribute("username");
		
		System.out.println("username::"+username);
		
		if(username==null||username.equals("")){//��ʱ     ��ʱ���ﳵ
			
			System.out.println("��ʱ���ﳵ...");
			
			String allprice;
			String listprice;
			

			System.out.println("number:"+inStock);
			
			HttpServletRequest request=ServletActionContext.getRequest();
			
			HttpSession session=request.getSession();
			
			List<Cart> cartNewList=(List<Cart>) session.getAttribute("cartList");
			
			System.out.println(cartNewList.size());
			
			for(int i=0;i<cartNewList.size();i++){
				
				
				
				System.out.println(cartNewList.get(i).getItem().getAllprice()+"::"+cartNewList.get(i).getItem().getListprice());
				
				allprice=cartNewList.get(i).getItem().getAllprice().toString();
				
				Item item=new Item();
				
				item.setAttr1(cartNewList.get(i).getItem().getAttr1());
				
				item.setItemid(cartNewList.get(i).getItem().getItemid());
				item.setListprice(cartNewList.get(i).getItem().getListprice());
				item.setProduct(cartNewList.get(i).getItem().getProduct());
				
				item.setAllprice(Integer.parseInt(inStock[i])*cartNewList.get(i).getItem().getListprice());
				
				System.out.println(Integer.parseInt(inStock[i])*cartNewList.get(i).getItem().getListprice());
				
				
				cartNewList.get(i).setItem(item);
				
				
			}

			return "success";
		
		
		
		}else{//�û����ﳵ
			
			System.out.println("�û����ﳵ.....");
			CartDao cartDao=new CartDao();	
			
			cartList=cartDao.querycartList();
			
			for(int i=0;i<cartList.size();i++){
				
				Double listprice=cartList.get(i).getItem().getListprice();
				
				cartList.get(i).getItem().setAllprice(listprice*Integer.parseInt(inStock[i]));
				
				numberList.add(inStock[i]);
				
				allpriceList.add(listprice*Integer.parseInt(inStock[i]));
			}
			
			session2.setAttribute("allpriceList", allpriceList);
			session2.setAttribute("numberList", numberList);
			
			return "success";
		}
		
		
		
	}



	
	
































	public List<String> getNumberList() {
		return numberList;
	}





































	public void setNumberList(List<String> numberList) {
		this.numberList = numberList;
	}





































	public List<Double> getAllpriceList() {
		return allpriceList;
	}



















	public void setAllpriceList(List<Double> allpriceList) {
		this.allpriceList = allpriceList;
	}



















	public List<Cart> getCartList() {
		return cartList;
	}






	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}






	public String[] getInStock() {
		return inStock;
	}


	public void setInStock(String[] inStock) {
		this.inStock = inStock;
	}



	
	
}
