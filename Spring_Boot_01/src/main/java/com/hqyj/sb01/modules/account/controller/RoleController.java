package com.hqyj.sb01.modules.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hqyj.sb01.modules.account.entity.Role;
import com.hqyj.sb01.modules.account.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	/*
	 * http://127.0.0.1/api/role/{roleId}
	 */
	@RequestMapping("/role/{roleId}")
	public Role getRoleByRoleId(@PathVariable int roleId) {
		return roleService.getRoleByRoleId(roleId);
	}
}
