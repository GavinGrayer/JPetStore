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


	
	private String title;//category��ʾ��ͷ��
	
	private String currentPage;//��ȡ��ǰҳ
	
	
	
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
		
		System.out.println("ǰ̨������ֵ��-->>:"+title);
		
		TypeDao typeDao=new TypeDao();
		
		
		//ÿҳ��¼��
		int pageSize = 3;//ÿҳ��¼��
		
		
		System.out.println("currentpage::"+currentPage);
		
		
		int currentPageInt = (currentPage != null && !currentPage.equals("")) ? Integer.parseInt(currentPage) : 1;
		
		
		System.out.println("currentpageint::"+currentPageInt);
		
		System.out.println("keyword::"+keyword);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("keyword", keyword);
		
		
		//�ܸ���
		
		if(keyword==null){
			
			
		

				int count=typeDao.countTypeShow(title);
				
				
				
				System.out.println("�ܸ���::"+count);
				
				int pages = 0;//��ҳ��
				
				if(count % pageSize == 0){//������ҳ��
					pages = count / pageSize;//�ܼ�¼���ܱ�ÿҳ��¼������
				}else{
					
					pages = count / pageSize + 1; 
				}
				
				System.out.println("��ҳ��::"+pages);
				
				//���Ƶ�ǰҳ��
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
	
	
	
	//������ť
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
		
		
		//ÿҳ��¼��
		int pageSize = 3;//ÿҳ��¼��
		
		
		System.out.println("currentpage::"+currentPage);
		
		
		int currentPageInt = (currentPage != null && !currentPage.equals("")) ? Integer.parseInt(currentPage) : 1;
		
		
		System.out.println("currentpageint::"+currentPageInt);
		
		
		
		
		//�ܸ���
		int count=typeDao.searchCount(keyword);
		System.out.println("�ܸ���::"+count);
		
		int pages = 0;//��ҳ��
		
		if(count % pageSize == 0){//������ҳ��
			pages = count / pageSize;//�ܼ�¼���ܱ�ÿҳ��¼������
		}else{
			
			pages = count / pageSize + 1; 
		}
		
		System.out.println("��ҳ��::"+pages);
		
		//���Ƶ�ǰҳ��
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
