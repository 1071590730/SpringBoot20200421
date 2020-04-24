package com.hqyj.sb01.modules.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;


import com.hqyj.sb01.modules.test.entity.City;

//Dao层注解（到仓库）
//@Repository
//Mapper（Mapper.xml）包含@Repository
@Mapper
public interface CityDao {

	/**
	 * （敏     感）#{countryId} ---- prepared statement, select * from m_city where country_id = ?
	 * （字符串）${countryId} ---- statement, select * from m_city where country_id = 1
	 */
	//注解查询@Select，直接写SQL语句
	@Select("select * from m_city where country_id = #{countryId}")
	List<City> getCitiesByCountryId(int countryId);
	
	//读取cityMapper.xml内方法数据
	List<City> getCitiesByCountryId2(int countryId);
	
	//插入一条分页
	@Insert("insert into m_city (city_name, local_city_name, country_id, date_created) "
			+ "values (#{cityName}, #{localCityName}, #{countryId}, #{dateCreated})")
	@Options(useGeneratedKeys=true, keyColumn="city_id", keyProperty="cityId")
	void insertCity(City city);
}