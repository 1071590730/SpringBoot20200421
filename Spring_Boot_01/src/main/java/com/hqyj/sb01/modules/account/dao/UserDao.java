package com.hqyj.sb01.modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.hqyj.sb01.modules.account.entity.User;

//Dao层注解（到仓库）
//@Repository
//Mapper（Mapper.xml）包含@Repository
@Mapper
public interface UserDao {
	
	//查询
	@Select("select * from user where user_id = #{userId}")
	List<User> getUserByUserId(int userId);
	
	//增加
	@Insert("INSERT into user(user_name,password) VALUES(#{userName},#{password})")
	//增加后 返回user_id
	@Options(useGeneratedKeys=true,keyColumn="user_id",keyProperty="userId")
	void insertUser(User user);
}
