package com.demo.service;

import com.demo.beans.MyUser;
import com.demo.dao.MyLoginDao;
import com.demo.dao.MyLoginDaoImpl;

public class MyLoginServiceimpl implements MyLoginService {
	private MyLoginDao ldao;
	

	public MyLoginServiceimpl() {
		ldao=new MyLoginDaoImpl();
	}


	@Override
	public MyUser validateUser(String uname, String pass) {
		return ldao.checkUser(uname,pass);
	}

}
