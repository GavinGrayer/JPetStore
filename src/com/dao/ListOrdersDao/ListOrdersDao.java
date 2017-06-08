package com.dao.ListOrdersDao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.domain.Orders;
import com.hibernate.HibernateSessionFactory;

public class ListOrdersDao {
	
	
	public List<Orders> findOrderList(){
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="from Orders";
		
		Query query=session.createQuery(hql);
		
		List<Orders> ordersList=query.list();
		
		
		
		session.close();
		
		return ordersList;
	}
}
