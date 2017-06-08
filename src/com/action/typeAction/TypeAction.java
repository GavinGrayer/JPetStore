package com.action.typeAction;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.dao.typeDao.TypeDao;
import com.domain.Product;

public class TypeAction {


	
	private String title;//category显示的头名
	
	private String currentPage;//获取当前页
	
	
	
	public List<Product> productList=null;
	
	
	private String keyword;
	

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String typeShow(){
		
		System.out.println("前台传来的值：-->>:"+title);
		
		TypeDao typeDao=new TypeDao();
		
		
		//每页记录数
		int pageSize = 3;//每页记录数
		
		
		System.out.println("currentpage::"+currentPage);
		
		
		int currentPageInt = (currentPage != null && !currentPage.equals("")) ? Integer.parseInt(currentPage) : 1;
		
		
		System.out.println("currentpageint::"+currentPageInt);
		
		System.out.println("keyword::"+keyword);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("keyword", keyword);
		
		
		//总个数
		
		if(keyword==null){
			
			
		

				int count=typeDao.countTypeShow(title);
				
				
				
				System.out.println("总个数::"+count);
				
				int pages = 0;//总页数
				
				if(count % pageSize == 0){//计算总页数
					pages = count / pageSize;//总记录数能被每页记录数整除
				}else{
					
					pages = count / pageSize + 1; 
				}
				
				System.out.println("总页数::"+pages);
				
				//控制当前页数
				if(currentPageInt > pages){
				System.out.println("2222222222");
					currentPageInt = pages;
					
				
				}else if(currentPageInt < 1){
					System.out.println("11111111111");
					currentPageInt = 1;
					
				
				}
				
				currentPage=String.valueOf(currentPageInt);
				
				System.out.println("currentpageint"+currentPageInt);
				
				productList=typeDao.typeShow(title,pageSize,currentPageInt);
	
		}else{
			
			search();
			
			
		}
		
		//title=fish;
		return "success";
	}
	
	
	
	//搜索按钮
	public String search(){
		
		System.out.println("---------------------");
		
		
		try {
			keyword=new String(keyword.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("keyword::"+keyword);
		
		TypeDao typeDao=new TypeDao();
		
		
		//每页记录数
		int pageSize = 3;//每页记录数
		
		
		System.out.println("currentpage::"+currentPage);
		
		
		int currentPageInt = (currentPage != null && !currentPage.equals("")) ? Integer.parseInt(currentPage) : 1;
		
		
		System.out.println("currentpageint::"+currentPageInt);
		
		
		
		
		//总个数
		int count=typeDao.searchCount(keyword);
		System.out.println("总个数::"+count);
		
		int pages = 0;//总页数
		
		if(count % pageSize == 0){//计算总页数
			pages = count / pageSize;//总记录数能被每页记录数整除
		}else{
			
			pages = count / pageSize + 1; 
		}
		
		System.out.println("总页数::"+pages);
		
		//控制当前页数
		if(currentPageInt > pages){
		System.out.println("2222222222");
			currentPageInt = pages;
			
		
		}else if(currentPageInt < 1){
			System.out.println("11111111111");
			currentPageInt = 1;
			
		
		}
		
		currentPage=String.valueOf(currentPageInt);
		
		System.out.println("currentpageint"+currentPageInt);
		
		productList=typeDao.searchList(keyword, pageSize, currentPageInt);
		
		
		
		return "success";
	}
	
	
	
	
}
