package com.hqyj.sb01.modules.account.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hqyj.sb01.modules.account.entity.Role;

//Dao层注解（到仓库）
//@Repository
//Mapper（Mapper.xml）包含@Repository
@Mapper
public interface RoleDao {

	@Select("select * from role where role_id = #{roleId}")
	Role getRoleByRoleId(int roleId);
}
