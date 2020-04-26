package com.hqyj.sb01.modules.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hqyj.sb01.modules.account.dao.UserDao;
import com.hqyj.sb01.modules.account.entity.User;
import com.hqyj.sb01.modules.account.service.UserService;
import com.hqyj.sb01.modules.common.vo.Result;
import com.hqyj.sb01.modules.common.vo.Result.ResultEnum;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUserByUserId(int userId) {
		List<User> user = userDao.getUserByUserId(userId);
		return user;
	}

	@Override
	public Result<User> insertUser(User user) {
		Result<User> result = new Result<>(ResultEnum.SUCCESS.status, "Insert success.");
		try {
			userDao.insertUser(user);
			result.setObject(user);
		} catch (Exception e) {
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	//事务
	@Transactional
	public Result<User> updateUser(User user) {
		Result<User> result = new Result<>(ResultEnum.SUCCESS.status, "Update success.");
		try {
			userDao.updateUser(user);
			result.setObject(user);
		} catch (Exception e) {
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	@Override
	public Result<Object> deleteUser(int user_id) {
		Result<Object> result = new Result<>(ResultEnum.SUCCESS.status, "Delete success.");
		try {
			userDao.deleteUser(user_id);
		} catch (Exception e) {
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}
}
