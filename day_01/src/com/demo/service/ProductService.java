package com.demo.service;

import java.util.List;

import com.demo.beans.product;

public interface ProductService {

	boolean addNewProduct();
	
	List<product> getAllProducts();

	boolean deleteById(int id);

	boolean modifyById(int id, int qty, double price);

	product getById(int id);

	List<product> sortByPrice();

	void closeMyConnection();
	


}
