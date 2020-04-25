package com.hqyj.sb01.modules.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.sb01.modules.account.dao.RoleDao;
import com.hqyj.sb01.modules.account.entity.Role;
import com.hqyj.sb01.modules.account.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Role getRoleByRoleId(int roleId) {
		return roleDao.getRoleByRoleId(roleId);
	}
}
