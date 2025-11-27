package com.demo.service;

import java.util.List;

import com.demo.beans.MyProduct;
import com.demo.dao.MyProductDao;
import com.demo.dao.MyProductDaoImpl;

public class MyProductServiceImpl implements MyProductService {
	private MyProductDao pdao;

	public MyProductServiceImpl() {
		pdao=new MyProductDaoImpl();
	}





	@Override
	public List<MyProduct> getAllProducts() {
		return pdao.findAllProducts();
	}





	@Override
	public boolean addNewProduct(MyProduct p) {
		return pdao.save(p);
	}




	}

}
