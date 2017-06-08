package com.daoIface;

import java.util.List;

import com.domain.Product;

public interface TypeDaoIface {
	

	public List<Product> typeShow(String title,int pageSize,int currentPage);
	
	
	
}
