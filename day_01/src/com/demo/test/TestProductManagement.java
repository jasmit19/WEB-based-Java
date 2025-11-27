package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestProductManagement {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int choice=0;
		ProductService pservice=new ProductServiceImpl();
		
		do {
			System.out.println("1. add new product\n2. delete product\n3. modify product");
			System.out.println("4.find by Id\n5. display all\n6. display in sorted order\n7. exit");
			System.out.println("Choice:");
			
			choice=sc.nextInt();
			switch(choice) {
			//add new product
			//insert product
			case 1->{
				//variable status of Data Type boolean
				//it will contain True/False return from addNewProduct function 
				boolean status=pservice.addNewProduct();
				
				//status is True
				if(status) {
					System.out.println("Product added successfully");
				}
				else {
					System.out.println("not added");
				}
			}
			
			//delete product by id
			case 2->{
				System.out.println("Enter id:");
				int id=sc.nextInt();
				
				boolean status=pservice.deleteById(id);
				
				if(status) {
					System.out.println("Deleted successfully");
				}
				else {
					System.out.println("Not deleted");
				}
			}
			
			
			//modify product
			case 3->{
				System.out.println("Enter id:");
				int id=sc.nextInt();
				System.out.println("Enter quantity:");
				int qty=sc.nextInt();
				System.out.println("Enter price:");
				double price=sc.nextDouble();
				
				boolean status=pservice.modifyById(id,qty,price);
				if(status) {
					System.out.println("Product updated successfully");
				}
				else {
					System.out.println("Not updated");
				}
			}
			
			//find product by id
			case 4->{
				System.out.println("Enter id:");
				int id=sc.nextInt();
				
				product p=pservice.getById(id);
				
				if(p==null) {
					System.out.println("not found");
				}else {
					System.out.println(p);
				}
				
			}
			
			
			case 5->{
				List<product> plst=pservice.getAllProducts();
				plst.forEach(System.out::println);
			}
			
			case 6->{
				List<product> plst=pservice.sortByPrice();
				plst.forEach(System.out::println);
			}
			
			case 7->{
				System.out.println("Thank You for visiting....!!");
				sc.close();
				pservice.closeMyConnection();
			}
			
			}
		}
		while(choice!=7);
	}

}
