package com.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.RegisterDao;
import com.domain.Account;
import com.domain.Profile;
import com.domain.Signon;
import com.hibernate.HibernateSessionFactory;

public class RegisterAction {
	
	private Account account;//客户基本信息	
	private Profile profile;//个人爱好	
	private Signon signon;//账户信息
	
	
	private RegisterDao registerDao;
	
	public String print(){
		
		System.out.println("客户基本信息"+account.getAddr1()+account.getAddr2()+account.getCity());
		System.out.println("账户信息"+signon.getUserid()+signon.getPassword());
		
		System.out.println("个人爱好："+profile.getFavcategory()+profile.getLangpref()+"::"+profile.getBanneropt()+"::"+profile.getMylistopt());
		
		
		if(signon.getUserid().equals("")||signon.getPassword().equals("")){
			
			
			return "error";

			
		}else{
			//保存到sigon表
			
			registerDao.saveSigon(signon);
			
			account.setUserid(signon.getUserid());
			registerDao.saveAccount(account);
			
			profile.setUserid(signon.getUserid());
			registerDao.saveProfile(profile);
			
			return "success";
			
		}
		
	}
	
	
	
	/*//将消息分别存入Account，Profile，Signon表中
	
	*//**
	 * 保存账户和密码 -->> sigon表
	 *//*
	public void saveSigon(Signon signon1){
		
		Session session=HibernateSessionFactory.getSession();
		
		Transaction t=session.beginTransaction();
		
		session.save(signon1);
		
		
		t.commit();
		
		session.close();
	}
	
	
	*//**
	 * 保存信息-->> account表
	 * @param account1
	 *//*
	public void saveAccount(Account account1){
		
		Session session=HibernateSessionFactory.getSession();
		
		Transaction t=session.beginTransaction();
		
		session.save(account1);
		
		t.commit();
		
		session.close();
	}
	
	
	*//**
	 * 保存喜好 -->> profile表
	 * @param profile1
	 *//*
	public void saveProfile(Profile profile1){
		
		Session session=HibernateSessionFactory.getSession();
		
		Transaction t=session.beginTransaction();
		
		session.save(profile1);
		
		t.commit();
		
		session.close();
		
		
	}
	*/
	
	
	//-------------------------------------
	public RegisterAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterAction(Account account, Profile profile, Signon signon) {
		super();
		this.account = account;
		this.profile = profile;
		this.signon = signon;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Signon getSignon() {
		return signon;
	}
	public void setSignon(Signon signon) {
		this.signon = signon;
	}
	
	
	
}
