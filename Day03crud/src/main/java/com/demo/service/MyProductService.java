package com.demo.service;

import java.util.List;

import com.demo.beans.MyProduct;

public interface MyProductService {

	List<MyProduct> getAllProducts();

	boolean addNewProduct(MyProduct p);

}
