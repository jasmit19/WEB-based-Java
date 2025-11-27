package com.demo.service;

import java.util.List;

import com.demo.dao.MyProductDao;
import com.demo.dao.MyProductDaoImpl;

public class MyProductServiceImpl implements MyProductSerive {
	private MyProductDao pdao;
	
	

	public MyProductServiceImpl() {
		pdao=new MyProductDaoImpl();
	}



	@Override
	public List<Integer> getAllCategory() {
		return pdao.findAllCategory();
	}

}
