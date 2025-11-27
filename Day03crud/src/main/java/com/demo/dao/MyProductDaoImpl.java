package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.demo.beans.MyProduct;

public class MyProductDaoImpl implements MyProductDao {
	
	static Connection conn;
	static PreparedStatement selectProd,insertProd,selectById,updateById,deleteById;
	
	static {
		conn=MyDBUtil.getMyConnection();
		
		try {
			selectProd=conn.prepareStatement("select * from product1");
			insertProd=conn.prepareStatement("insert into product1 values(?,?,?,?,?,?)");
			selectById=conn.prepareStatement("select * from product1 where pid=?");
			updateById=conn.prepareStatement("update product1 set pname=?,qty=?,price=?,expdate=?,cid=? where pid=?");
			deleteById=conn.prepareStatement("delete from product1 where pid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MyProduct> findAllProducts() {
		List<MyProduct> plist=new ArrayList<>();
		
		try {
			ResultSet rs=selectProd.executeQuery();
			
			while(rs.next()) {
				plist.add(new MyProduct(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate(),rs.getInt(6)));
				}
			return plist;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean save(MyProduct p) {
		try {
			insertProd.setInt(1, p.getPid());
			insertProd.setString(2, p.getPname());
			insertProd.setInt(3, p.getQty());
			insertProd.setDouble(4, p.getQty());
			insertProd.setDate(5, java.sql.Date.valueOf(p.getExpdate()));
			insertProd.setInt(6, p.getCid());
			int n=insertProd.executeUpdate();
			
			return n>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
