package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.daoIface.LoginDaoIface;
import com.domain.Signon;
import com.hibernate.HibernateSessionFactory;

public class LoginDao implements LoginDaoIface{
	
	
	public String judge(Signon signon){
		
		
		System.out.println("---------");
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="select password from Signon where userid=?";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, signon.getUserid());
		
		String password=(String) query.uniqueResult();
		
		System.out.println("通过帐号查询出的密码："+password);

		session.close();
		
		return password;
	}
	
	
}
