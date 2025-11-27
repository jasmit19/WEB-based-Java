package com.demo.service;

import com.demo.beans.MyUser;

public interface MyLoginService {

	MyUser validateUse(String uname, String pass);

}
