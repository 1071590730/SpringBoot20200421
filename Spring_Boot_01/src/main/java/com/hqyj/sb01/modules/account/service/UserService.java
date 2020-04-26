package com.hqyj.sb01.modules.account.service;

import java.util.List;

import com.hqyj.sb01.modules.account.entity.User;
import com.hqyj.sb01.modules.common.vo.Result;

public interface UserService {

	List<User> getUserByUserId(int userId);
	
	Result<User> insertUser(User user);
	
	Result<User> updateUser(User user);
	
	Result<Object> deleteUser(int user_id);
}
