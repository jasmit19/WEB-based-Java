package com.demo.service;

import com.demo.beans.MyUser;

public interface MyLoginService {

	MyUser validateUser(String uname, String pass);

}
