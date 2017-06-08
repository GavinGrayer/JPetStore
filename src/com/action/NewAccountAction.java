package com.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Signon;
import com.hibernate.HibernateSessionFactory;

public class NewAccountAction {
	
	private Signon signon;
	private InputStream ajaxInputStream;

	public NewAccountAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewAccountAction(Signon signon) {
		super();
		this.signon = signon;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}
	
	
	
	public NewAccountAction(Signon signon, InputStream ajaxInputStream) {
		super();
		this.signon = signon;
		this.ajaxInputStream = ajaxInputStream;
	}

	public InputStream getAjaxInputStream() {
		return ajaxInputStream;
	}

	public void setAjaxInputStream(InputStream ajaxInputStream) {
		this.ajaxInputStream = ajaxInputStream;
	}

	public String judge(){
		
		String result=null;
		
		System.out.println("进入ajax-------前台传来的用户名:"+signon.getUserid()+"------");
		
		Session session=HibernateSessionFactory.getSession();
		
		System.out.println("++++++++++++++++++");
		Transaction t=session.beginTransaction();
		
		String hql="select s.password from Signon s where userid=?";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, signon.getUserid());
		
		String password=(String) query.uniqueResult();
		
		if(password!=null){
			
			result="false";
		}else{
			result="true";
		}
		
		t.commit();
		
		session.close();
		ajaxInputStream=new StringBufferInputStream(result);
		
		return "success";
	}
	
	
}
