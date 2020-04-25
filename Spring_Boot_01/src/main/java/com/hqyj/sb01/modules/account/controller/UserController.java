package com.hqyj.sb01.modules.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hqyj.sb01.modules.account.entity.User;
import com.hqyj.sb01.modules.account.service.UserService;
import com.hqyj.sb01.modules.common.vo.Result;

//控制器
@RestController
//公共的path路径
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	/*
	 * http://127.0.0.1/api//User/1
	 */
	@RequestMapping("/User/{userId}")
	public List<User> getUserByUserId(@PathVariable int userId) {
		List<User> user = userService.getUserByUserId(userId);
		System.err.println(user);
		return user;
	}
	
	/*
	 * http://127.0.0.1/api/user
	 */
	@PostMapping(value="/user", consumes="application/json")
	public Result<User> insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
}
