package com.hqyj.sb01.modules.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.hqyj.sb01.modules.test.entity.Country;

//Dao层注解（到仓库）
//@Repository
//Mapper（Mapper.xml）包含@Repository
@Mapper
public interface CountryDao {

	@Select("select * from m_country where country_id = #{countryId}")
	//封装结果集   @Results共享
	@Results(id="countryResult", value={
		//将column="country_id" 列 映射到  property="countryId" 属性
		@Result(column="country_id", property="countryId"),
		@Result(column="country_id",property="cities",
				//设置属性类型List
				javaType=List.class,
				//单个@One、多个@Many
				many=@Many(select="com.hqyj.sb01.modules.test.dao.CityDao.getCitiesByCountryId"))
	})
	Country getCountryById(int countryId);
	
	@Select("select * from m_country where country_name = #{countryName}")
	//引用countryResult结果集
	@ResultMap(value="countryResult")
	Country getCountryByName(String countryName);
}