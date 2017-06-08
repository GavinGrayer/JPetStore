package com.dao.productToItemDao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.daoIface.ProductToItemDaoIface;
import com.domain.Item;
import com.hibernate.HibernateSessionFactory;

public class ProductToItemDao implements ProductToItemDaoIface{
	
	public List<Item> itemList(String productid) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		
		
		String hql="from Item where productid = ?";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, productid);
		
		List<Item> itemList=query.list();
		
		for (Object o : itemList) {
			
			Item item=(Item) o;
			System.out.println(item.getItemid()+"::"+item.getProduct().getName());
			
		}
		
		
		session.close();
		
		
		return itemList;
	}


	
	
	
}
