package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Cart;
import com.hibernate.HibernateSessionFactory;

public class DelCartByItemIdDao {
	
	public void delCart(String id){
		
		Session session=HibernateSessionFactory.getSession();
		
		Transaction t=session.beginTransaction();
		
/*		String hqlString="delete from Cart where id = ? ";
		
		Query query=session.createQuery(hqlString);
		
		query.setParameter(0, id);*/
		
		Cart cart=(Cart) session.get(Cart.class, Long.valueOf(id));
		
		session.delete(cart);
		
		System.out.println("----------");
		
		t.commit();
		
		session.close();
	}
	
	public Long queryId(String itemid){
		
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="select id from Cart where itemid = ?";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, itemid);
		
		Long id= (Long) query.uniqueResult();
		
		session.close();
		
		return id;
	}
	
}
