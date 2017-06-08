package com.action.CartAction;

import java.util.ArrayList;
import java.util.List;

import com.dao.DelCartByItemIdDao;
import com.dao.FindItemByIdDao;
import com.dao.CartDao.CartDao;
import com.domain.Cart;
import com.domain.Item;

public class DelCartByItemIdAction {
	
	private String itemid;
	
	private List<Cart> cartList=new ArrayList<Cart>();
	
	
	public String delCart(){
		
		DelCartByItemIdDao dao=new DelCartByItemIdDao();
		
		System.out.println("itemid::"+itemid);
		
		Integer id=Integer.parseInt(dao.queryId(itemid).toString());
		
		dao.delCart(id.toString());
		
		System.out.println(id);
		//将item和qty存到cart表中
		CartDao cartDao=new CartDao();

		
		cartList=cartDao.querycartList();
		
		//通过每一次遍历得出的itemid重新去寻找相应的商品成本价，替换到总价格里
		for(int i=0;i<cartList.size();i++){
			
			String itemid=cartList.get(i).getItem().getItemid();
			
			FindItemByIdDao findItemByIdDao2=new FindItemByIdDao();

			Item item2=findItemByIdDao2.itemContext(itemid);

			String listpriceString=item2.getListprice().toString();

			cartList.get(i).getItem().setAllprice(Double.valueOf(listpriceString));
			
		}
		
		
		return "success";
	}
	
	
	
//-------------------------------
	
	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}



	public List<Cart> getCartList() {
		return cartList;
	}



	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}
	
	
	
	
}
