package com.xusage.statics.controller.slaver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xusage.statics.pojo.User;
import com.xusage.statics.service.slaver.UserService;
import com.xusage.statics.util.Md5;


@RestController
@RequestMapping("/statics")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/searchUser")
	public List<User> searchUser(String phoneNum,String password){
		
		String passwordConfim = null;

		if ((phoneNum != null) && (password != null)) {
			passwordConfim = Md5.getMD5(password);
		}
		return userService.searchUser(phoneNum, passwordConfim);

	}
}
