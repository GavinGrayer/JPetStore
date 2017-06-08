package com.dao.CartDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.domain.Cart;
import com.domain.Item;
import com.domain.Product;
import com.hibernate.HibernateSessionFactory;

public class CartDao {
	
	
	public void save(Item item,String qty){
		
		System.out.println("-----------");
		
		Session session=HibernateSessionFactory.getSession();
		
		Transaction t=session.beginTransaction();
		
		Cart cart=new Cart();
		cart.setItem(item);
		cart.setQuantity(Long.valueOf(qty));
		
		session.save(cart);
		
		t.commit();
		
		session.close();
		
	}
	
	public List<Cart> querycartList(){
		
		System.out.println("+++++++++++");
		
		List<Cart> cartList=new ArrayList<Cart>();
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="from Cart ";
		
		Query query=session.createQuery(hql);
		
		
		
		cartList=query.list();
		
		
		session.close();
		
		return cartList;
	}
	
	
	public Product productNameById(String productidString){
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="from Product where productid = ?";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, productidString);
		
		Product product=(Product) query.uniqueResult();
		
		session.close();
		
		return product;
	}
	
	public String mylist(String userid){
		
		String mylistopt=null;
		
		Session session=HibernateSessionFactory.getSession();
		
		String hqlString="select mylistopt from Profile where userid = ?";
		
		
		Query query=session.createQuery(hqlString);
		
		query.setParameter(0, userid);
		
		mylistopt=String.valueOf(query.uniqueResult());
		
		
		
		session.close();
		
		return mylistopt;
	}
}
