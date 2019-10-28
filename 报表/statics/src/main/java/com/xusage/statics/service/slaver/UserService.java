package com.xusage.statics.service.slaver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xusage.statics.dao.slaver.UserDao;
import com.xusage.statics.pojo.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> searchUser(String phoneNum,String password){
		return userDao.searchUser(phoneNum, password);
	}
}
