package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.domain.Item;
import com.domain.Product;
import com.hibernate.HibernateSessionFactory;

public class FindItemByIdDao {
	
	//查询商品内容
	public Item itemContext(String itemid){
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="from Item where itemid = ?";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, itemid);
		
		Item item=(Item) query.uniqueResult();
		
		System.out.println(item.getItemid()+"::"+item.getListprice());
		
		session.close();
		
		return item;
	}
	
	
	//查询库存
	public String queryQTY(String itemid){
		
		
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="select qty from Inventory where itemid = ?";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, itemid);
		
		String qty= String.valueOf(query.uniqueResult());
		
		session.close();
		
		return qty;
	}
	
	
	//查询商品的img src路径  product表通过 productid查询********************
	public String queryImgPath(String productid){
		
		String path;
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="from Product where productid = ? ";
		
		Query query=session.createQuery(hql);
		
		query.setParameter(0, productid);
		
		Product product =(Product) query.uniqueResult();
		
		System.out.println("path::"+product.getDescn());
		
		String path1[]=product.getDescn().split(">");
		
		System.out.println(path1[0]+"::::"+path1[1]);
		
		String path2[]=path1[0].split("\"");
		
		System.out.println(path2[0]+"::"+path2[1]);
		
		String path3[]=path2[1].split("/");
		
		System.out.println(path3[1]+path3[2]);
		
		path=path3[1].concat("/".concat(path3[2]));
		
		
		
		path=path.concat(":".concat(path1[1]));
		
		System.out.println(path);
		
		session.close();
		
		
		return path;
	}
	
	
	
	
	public static void main(String[] args) {
		FindItemByIdDao findItemByIdDao=new FindItemByIdDao();
		//findItemByIdDao.itemContext("EST-10");
		
		findItemByIdDao.queryImgPath("FI-SW-01");
	}
}
