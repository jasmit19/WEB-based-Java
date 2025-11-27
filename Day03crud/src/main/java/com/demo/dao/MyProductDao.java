package com.demo.dao;

import java.util.List;

import com.demo.beans.MyProduct;

public interface MyProductDao {

	List<MyProduct> findAllProducts();

	boolean save(MyProduct p);

}
