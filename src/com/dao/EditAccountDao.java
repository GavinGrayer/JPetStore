package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Account;
import com.domain.Profile;
import com.domain.Signon;
import com.hibernate.HibernateSessionFactory;

public class EditAccountDao {
	
	
	//����Account
	public void updateAccount(Account account){
		
		Session session=HibernateSessionFactory.getSession();
		Transaction t=session.beginTransaction();
		
		session.update(account);
		
		t.commit();
		session.close();
	}
	
	//����Signon
	public void updateSignon(Signon signon){
		
		Session session=HibernateSessionFactory.getSession();
		Transaction t=session.beginTransaction();
		
		session.update(signon);
		
		t.commit();
		session.close();
	}
	
	//����profile
	public void updateProfile(Profile profile){
		
		Session session=HibernateSessionFactory.getSession();
		Transaction t=session.beginTransaction();
		
		session.update(profile);
		
		t.commit();
		session.close();
	}
}
