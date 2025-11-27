package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MyProductDaoImpl implements MyProductDao {
	static Connection conn;
	
	static {
		conn=DBUtil.getMyConnection();
	}

	@Override
	public List<Integer> findAllCategory() {
		
		try {
			PreparedStatement getcat=conn.prepareStatement("select distinct prodid from product");
			ResultSet rs=getcat.executeQuery();
			List<Integer> clist=new ArrayList<>();
			while(rs.next()) {
				clist.add(rs.getInt(1));
			}
			return clist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
