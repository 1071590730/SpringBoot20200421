package com.hqyj.sb01.modules.test.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hqyj.sb01.modules.common.vo.Result;
import com.hqyj.sb01.modules.test.entity.City;

public interface CityService {

	List<City> getCitiesByCountryId(int countryId);
	
	//分页
	PageInfo<City> getCitiesByPage(int currentPage, int pageSize, int countryId);
	
	Result<City> insertCity(City city);
}
