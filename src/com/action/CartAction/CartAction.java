package com.action.CartAction;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.FindItemByIdDao;
import com.dao.CartDao.CartDao;
import com.domain.Cart;
import com.domain.Item;
import com.domain.Product;

public class CartAction {
	
	private String attr1;
	private String name;
	private String listprice;
	private String itemid;
	private String productid;
	private String qty=null;
	
	
	
	private List<Cart> cartList=new ArrayList<Cart>();
	private List<Double> allpriceList=new ArrayList<Double>();//���ܼ۸�ͨ��session����checkoutAction
	
	private List<String> numberList=new ArrayList<String>();//������

	
	private String mylistopt;
	
	public String cart(){
		
		
		if(name!=null&&attr1!=null){
			
		
			try {
				name=new String(name.getBytes("ISO8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				attr1=new String(attr1.getBytes("ISO8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		HttpSession session=request.getSession();
		
		String username=(String) session.getAttribute("username") == null ? null : (String) session.getAttribute("username");
		
		System.out.println("username::"+username);
		
		//���
		FindItemByIdDao findItemByIdDao=new FindItemByIdDao();
		qty=findItemByIdDao.queryQTY(itemid);

		
		//��ѯprofile��mylist
		CartDao dao=new CartDao();
		mylistopt=dao.mylist(username);
		
		session.setAttribute("mylistopt", mylistopt);
		
		
		
		
		if(username==null &&itemid!=null&&listprice!=null){//δ��¼״̬  ��ʱ���ﳵ***
			
			
				
				
			
			System.out.println("-----------------------------");
			//��ʱ���ﳵ***********************************8
			Cart cart=new Cart();
			
			Item item=new Item();
			item.setItemid(itemid);
			item.setAttr1(attr1);
			item.setListprice(Double.valueOf(listprice));
			item.setAllprice(Double.valueOf(listprice));
			
			Product product=new Product();
			product.setName(name);
			product.setProductid(productid);
			
			item.setProduct(product);
			

			cart.setItem(item);
			cart.setQuantity(Long.valueOf(qty));
			
			System.out.println(cart.getItem().getAttr1());
			
			
			
			
			List<Cart> cartNewList=(List<Cart>) session.getAttribute("cartList");
			

			
			if(cartNewList!=null){
				
				cartNewList=(List<Cart>) session.getAttribute("cartList");
				cartNewList.add(cart);
				
			}else{
				
				cartNewList=new ArrayList<Cart>();
				cartNewList.add(cart);
			}

			
			session.setAttribute("cartList", cartNewList);
			

			
			
			
		}else{//��½���ﳵ*********************************
			
			if(itemid!=null){//��½��δ��ӵ�һ�ν��빺�ﳵ��ֹ��ָ��
				
				
			
			//����cart��
			Item item=new Item();
			item.setItemid(itemid);

			System.out.println(itemid);
			//��item��qty�浽cart����
			CartDao cartDao=new CartDao();
			//����ѡ����Ʒ����Cart����
			cartDao.save(item, qty);
			
			cartList=cartDao.querycartList();
			
			}else{
				CartDao cartDao=new CartDao();	
				
				cartList=cartDao.querycartList();
			}
			
			
			//ͨ��ÿһ�α����ó���itemid����ȥѰ����Ӧ����Ʒ�ɱ��ۣ��滻���ܼ۸���
			for(int i=0;i<cartList.size();i++){
				
				String itemid=cartList.get(i).getItem().getItemid();
				
				FindItemByIdDao findItemByIdDao2=new FindItemByIdDao();

				Item item2=findItemByIdDao2.itemContext(itemid);

				String listpriceString=item2.getListprice().toString();

				cartList.get(i).getItem().setAllprice(Double.valueOf(listpriceString));
				
				numberList.add("1");
				allpriceList.add(Double.valueOf(listpriceString));
				
			}
			
			session.setAttribute("allpriceList", allpriceList);
			session.setAttribute("numberList", numberList);
			
		}
		
		
		
		
		

		
		
		
		
		return "success";
	}




	//------------------------------

	
	
	
	
	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getListprice() {
		return listprice;
	}

	public void setListprice(String listprice) {
		this.listprice = listprice;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}




	public List<Double> getAllpriceList() {
		return allpriceList;
	}




	public void setAllpriceList(List<Double> allpriceList) {
		this.allpriceList = allpriceList;
	}




	public List<String> getNumberList() {
		return numberList;
	}




	public void setNumberList(List<String> numberList) {
		this.numberList = numberList;
	}




	public String getMylistopt() {
		return mylistopt;
	}




	public void setMylistopt(String mylistopt) {
		this.mylistopt = mylistopt;
	}






	

}
