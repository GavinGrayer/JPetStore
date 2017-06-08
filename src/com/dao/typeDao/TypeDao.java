package com.dao.typeDao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.daoIface.TypeDaoIface;
import com.domain.Product;
import com.hibernate.HibernateSessionFactory;

public class TypeDao implements TypeDaoIface{

	public List<Product> typeShow(String title,int pageSize,int currentPage){
		
		List<Product> fishList=new ArrayList<Product>();
		
		
		//计算起始记录数
		int begin = (currentPage - 1)*pageSize ;
		
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="from Product where category = ?";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, title);
		
		query.setFirstResult(begin);
		
		query.setMaxResults(pageSize);
		
		
		fishList=query.list();
		
		for (Object object : fishList) {
			
			Product product=(Product) object;
			System.out.println(product.getProductid()+"::"+product.getName());
		}
		
		session.close();
		
		
		return fishList;
	}
	
	
	
	//总个数
	public int countTypeShow(String title){
		
		
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="select count(*) from Product where category = ?";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, title);

		
		Integer count=(Integer) query.uniqueResult();
		
		session.close();
		
		
		
		return count;
	}
	

	
	
	//模糊查询
	public List<Product> searchList(String msg,int pageSize,int currentPage){
		
		List<Product> fishList=new ArrayList<Product>();
		
		
		//计算起始记录数
		int begin = (currentPage - 1)*pageSize ;
		
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="from Product where name like ?";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, "%"+msg+"%");
		
		query.setFirstResult(begin);
		
		query.setMaxResults(pageSize);
		
		
		fishList=query.list();
		
		for (Object object : fishList) {
			
			Product product=(Product) object;
			System.out.println(product.getProductid()+"::"+product.getName());
		}
		
		session.close();
		
		
		return fishList;
		
		
	}
	
	//模糊查询总个数
	public int searchCount(String msg){
		
		
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="select count(*) from Product where name like ?";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, "%"+msg+"%");

		
		Integer count=(Integer) query.uniqueResult();
		
		session.close();
		
		
		
		return count;
	}
}
