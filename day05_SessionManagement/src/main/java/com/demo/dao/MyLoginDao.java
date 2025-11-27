package com.demo.dao;

import com.demo.beans.MyUser;

public interface MyLoginDao {

	MyUser checkUser(String uname, String pass);

}
