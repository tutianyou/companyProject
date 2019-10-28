package com.xusage.statics.dao.slaver;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xusage.statics.pojo.User;

@Mapper
public interface UserDao {

	List<User> searchUser(@Param(value="phoneNum") String phoneNum,
						  @Param(value="password") String password);
}
