package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.daoIface.RegisterDaoIface;
import com.domain.Account;
import com.domain.Profile;
import com.domain.Signon;
import com.hibernate.HibernateSessionFactory;

public class RegisterDao implements RegisterDaoIface{
	
	/**
	 * �����˻������� -->> Sigon��
	 */
	public void saveSigon(Signon signon1){
		
		Session session=HibernateSessionFactory.getSession();
		
		Transaction t=session.beginTransaction();
		
		session.save(signon1);
		
		
		t.commit();
		
		session.close();
	}
	
	
	/**
	 * ������Ϣ-->> account��
	 * @param account1
	 */
	public void saveAccount(Account account1){
		
		Session session=HibernateSessionFactory.getSession();
		
		Transaction t=session.beginTransaction();
		
		session.save(account1);
		
		t.commit();
		
		session.close();
	}
	
	
	/**
	 * ����ϲ�� -->> profile��
	 * @param profile1
	 */
	public void saveProfile(Profile profile1){
		
		Session session=HibernateSessionFactory.getSession();
		
		Transaction t=session.beginTransaction();
		
		session.save(profile1);
		
		t.commit();
		
		session.close();
		
		
	}
	
	
}
