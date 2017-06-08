package com.dao.OrderDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.domain.Account;
import com.domain.Orders;
import com.hibernate.HibernateSessionFactory;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDao {
	
	
	public void success(Orders orders){
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		HttpSession session1=request.getSession();
		
		Double sum=(Double) session1.getAttribute("sum");
		
		
		OrderDao dao=new OrderDao();
		String timeString=dao.caltime();
		
		SimpleDateFormat s=new SimpleDateFormat("yyyy/MM/dd h:m:s");
		
		Date time=null;
		try {
			time = s.parse(timeString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		orders.setOrderdate(time);//1		
		System.out.println("userid::"+orders.getAccount().getUserid());		
		//Account account=dao.query(orders.getAccount().getUserid());		
		//orders.setAccount(account);//2		
		orders.setShipcity(orders.getBillcity());//3		
		orders.setShipcountry(orders.getBillcountry());//4		
		orders.setCourier("中国邮政");//5
		
		
		
		orders.setTotalprice(sum);//6
		
		orders.setBilltofirstname(orders.getAccount().getUserid());//7
		
		orders.setShiptofirstname(orders.getAccount().getUserid());//8
		
		
		
		
		Session session=HibernateSessionFactory.getSession();
		
		Transaction t=session.beginTransaction();
		
		session.save(orders);
		
		
		t.commit();
		
		session.close();
		
	}
	public Account query(String userid){//查找userid的相关内容，防止存入order时出现not null
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="from Account where userid = ?";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, userid);
		
		Account account=(Account) query.uniqueResult();
		
		System.out.println("------"+account.getUserid()+account.getAddr1());
		
		session.close();
		return account;
	} 
	
	
	
	public String caltime(){
		
		Date d=new Date();
		
		String year=String.valueOf(d.getYear()+1900);
		
		int month1=d.getMonth();
		String month=String.valueOf(month1);
		int date1=d.getDate();
		String date=String.valueOf(date1);
		int hour1=d.getHours();
		String hour=String.valueOf(hour1);
		int minute1=d.getMinutes();
		String minute=String.valueOf(minute1);
		int second1=d.getSeconds();
		String second=String.valueOf(second1);
		
		String time=year.concat("/".concat(month.concat("/".concat(date.concat(" ".concat(hour.concat(":".concat(minute.concat(":".concat(second))))))))));
	
		return time;
	}
	
}
