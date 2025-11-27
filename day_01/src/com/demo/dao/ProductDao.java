package com.demo.dao;

import java.util.List;

import com.demo.beans.product;

public interface ProductDao {

	boolean save(product p);

	List<product> findAllProducts();

	boolean removeById(int id);

	boolean updateById(int id, int qty, double price);

	product findById(int id);

	List<product> arrangeByPrice();

	void closeMyConnection();

}
