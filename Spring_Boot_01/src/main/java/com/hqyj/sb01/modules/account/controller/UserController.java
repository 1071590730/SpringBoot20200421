package com.hqyj.sb01.modules.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	//请求
	@RequestMapping("/User/{userId}")
	public List<User> getUserByUserId(@PathVariable int userId) {
		List<User> user = userService.getUserByUserId(userId);
		System.err.println(user);
		return user;
	}
	
	/*
	 * http://127.0.0.1/api/user
	 */
	//新增@PostMapping
	//json提交数据，@RequestBody接收
	@PostMapping(value="/user", consumes="application/json")
	public Result<User> insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
	
	/*
	 * http://127.0.0.1/api/user
	 * 相同的请求地址：看请求方式@PostMapping（新增）/@PutMapping（修改）
	 */
	//修改@@PostMapping
	//表单提交数据consumes="application/x-www-form-urlencoded"，@ModelAttribute接收
	@PutMapping(value="/user", consumes="application/x-www-form-urlencoded")
	public Result<User> updateUser(@ModelAttribute User user) {
		return userService.updateUser(user);
	}
	
	/*
	 * http://127.0.0.1/api/user
	 */
	//删除
	@DeleteMapping("/user/{user_id}")
	public Result<Object> deleteUser(@PathVariable int user_id) {
		return userService.deleteUser(user_id);
	}
}
