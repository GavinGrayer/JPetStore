package com.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

import com.domain.Profile;
import com.hibernate.HibernateSessionFactory;

public class MyProfileDao {
	
	public void profile(){
		

		
		String username=null;

		HttpServletRequest request=ServletActionContext.getRequest();
		
		HttpSession session1=request.getSession();
		
		username=(String) session1.getAttribute("username");
		
		
		
		System.out.println("suername::"+username);
		
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="from Profile where userid = ?";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, username);
		
		Profile profile=(Profile) query.uniqueResult();
		
		System.out.println(profile.getUserid()+"::"+profile.getFavcategory()+"::"+profile.getBanneropt());

		
		session.close();
		
		System.out.println("========111=======");
		String favcategroy=String.valueOf(profile.getFavcategory());
		System.out.println("===================");
		session1.setAttribute("favcategroy", favcategroy);
		String banneropt=String.valueOf(profile.getBanneropt());
		session1.setAttribute("banneropt", banneropt);
		
		
	}

	
	public static void main(String[] args) {
		MyProfileDao myProfileDao=new MyProfileDao();
		myProfileDao.profile();
	}
	
}
