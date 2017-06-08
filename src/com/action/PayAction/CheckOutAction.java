package com.action.PayAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.CartDao.CartDao;
import com.domain.Cart;

public class CheckOutAction {
	
	private List<Cart> cartList;
	private String errMsg;
	private List<String> numberList;
	private Double sum;
	
	
	public String check(){

		HttpServletRequest request=ServletActionContext.getRequest();
		
		HttpSession session=request.getSession();
		
		String username=(String) session.getAttribute("username") == null ? null : (String) session.getAttribute("username");
		
		if(username!=null&&!username.equals("")){
			
			//重新查找
			CartDao cartDao=new CartDao();	
			
			cartList=cartDao.querycartList();
			
			List<Double> allpriceList=(List<Double>) session.getAttribute("allpriceList");
			
			numberList=(List<String>) session.getAttribute("numberList");
			
			sum=0.0;
			
			for(int i=0;i<cartList.size();i++){
				
				cartList.get(i).getItem().setNumber(numberList.get(i));
				cartList.get(i).getItem().setAllprice(allpriceList.get(i));
				sum+=allpriceList.get(i);
			}
			
			System.out.println(sum);
			
			session.setAttribute("sum", sum);
			
			session.setAttribute("usercartList", cartList);
			
			
			return "success";
		}else{
			
			errMsg="请登录后再付款";
			
			return "error";
		}
		
	}
	
	
	
	






	public Double getSum() {
		return sum;
	}










	public void setSum(Double sum) {
		this.sum = sum;
	}










	public List<String> getNumberList() {
		return numberList;
	}





	public void setNumberList(List<String> numberList) {
		this.numberList = numberList;
	}





	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}



	public String getErrMsg() {
		return errMsg;
	}





	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	
	
	
	
}
