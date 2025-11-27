package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDao pdao;

	public ProductServiceImpl() {
		pdao=new ProductDaoImpl();
	}

	@Override
	public boolean addNewProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter product id:");
		int pid=sc.nextInt();
		System.out.println("Enter product name:");
		String pname=sc.next();
		System.out.println("Enter quantity:");
		int qty=sc.nextInt();
		System.out.println("Enter price:");
		double price=sc.nextDouble();
		System.out.println("Enter manufacturing date:");
		String dt=sc.next();
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("dd/mm/yyyy"));
		product p=new product(pid,pname,qty,price,ldt);
		
		return pdao.save(p);
		
		
	}

	@Override
	public List<product> getAllProducts() {
		return pdao.findAllProducts();
	}

	@Override
	public boolean deleteById(int id) {
		return pdao.removeById(id);
	}

	@Override
	public boolean modifyById(int id, int qty, double price) {
		return pdao.updateById(id,qty,price);
	}

	@Override
	public product getById(int id) {
		return pdao.findById(id);
	}

	@Override
	public List<product> sortByPrice() {
		return pdao.arrangeByPrice();
	}

	@Override
	public void closeMyConnection() {
		pdao.closeMyConnection();
		
	}
	
	
	

}
