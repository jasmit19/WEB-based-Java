package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.product;

public class ProductDaoImpl implements ProductDao {
	
	static Connection conn;
	static PreparedStatement insProd,findProd,findById,updateById,deleteById,sortByPrice;
	static {
		
		try {
			conn=DBUtil.getMyConnection();
			insProd=conn.prepareStatement("insert into myproduct values(?,?,?,?,?)");
			findProd=conn.prepareStatement("select * from myproduct");
			findById=conn.prepareStatement("select * from myproduct where pid=?");
			updateById=conn.prepareStatement("update myproduct set qty=? price=? where pid=?");
			deleteById=conn.prepareStatement("delete from myproduct where pid=?");
			sortByPrice=conn.prepareStatement("select * from myproduct order by price");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean save(product p) {
		try {
			insProd.setInt(1, p.getPid());
			insProd.setString(2,p.getPname());
			insProd.setInt(3, p.getQty());
			insProd.setDouble(4, p.getPrice());
			insProd.setDate(5, java.sql.Date.valueOf(p.getLdt()));
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<product> findAllProducts() {
		List<product> plist=new ArrayList<>();
		
		try {
			ResultSet rs=findProd.executeQuery();
			
			while(rs.next()) {
				if(rs.getDate(5)!=null) {
					plist.add(new product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate()));
				}
				else {
					plist.add(new product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),null));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(plist.size()>0) {
			return plist;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean removeById(int id) {
		try {
			deleteById.setInt(1,id);
			int n=deleteById.executeUpdate();
			
			if(n>0)
				return true;
		}
			catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateById(int id, int qty, double price) {
		
		try {
			updateById.setInt(1,qty);
			updateById.setDouble(2, price);
			updateById.setInt(3, id);
			int n=updateById.executeUpdate();
			if(n>0) 
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public product findById(int id) {
		product p=null;
		
		try {
			findById.setInt(1, id);
			ResultSet rs=findById.executeQuery();
			
			while(rs.next()) {
				if(rs.getDate(5)!=null) {
					p=new product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate());
				}
				else {
					p=new product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),null);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<product> arrangeByPrice() {
		List<product> plist=new ArrayList<>();
		
		try {
			ResultSet rs=sortByPrice.executeQuery();
			
			while(rs.next()) {
				if(rs.getDate(5)!=null) {
					plist.add(new product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDate(5).toLocalDate()));
				}
				else {
					plist.add(new product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),null));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(plist.size()>0) {
			return plist;
		}
		return null;
	}

	@Override
	public void closeMyConnection() {
		DBUtil.closeMyConnection();
	}
	
	

}
