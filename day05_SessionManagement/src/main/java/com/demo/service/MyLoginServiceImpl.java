package com.demo.service;

import com.demo.beans.MyUser;
import com.demo.dao.MyLoginDao;
import com.demo.dao.MyLoginDaoImpl;

public class MyLoginServiceImpl implements MyLoginService {
	
	private MyLoginDao ldao;

	

	public MyLoginServiceImpl() {
		ldao=new MyLoginDaoImpl();
	}



	@Override
	public MyUser validateUse(String uname, String pass) {
		return ldao.checkUser(uname,pass);
	}

}
