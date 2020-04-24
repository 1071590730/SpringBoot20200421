package com.hqyj.sb01.modules.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.sb01.modules.common.vo.Result;
import com.hqyj.sb01.modules.common.vo.Result.ResultEnum;
import com.hqyj.sb01.modules.test.dao.CityDao;
import com.hqyj.sb01.modules.test.entity.City;
import com.hqyj.sb01.modules.test.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityDao cityDao;

	@Override
	public List<City> getCitiesByCountryId(int countryId) {
		List<City> cities = cityDao.getCitiesByCountryId2(countryId);
		return cities;
	}

	@Override
	public PageInfo<City> getCitiesByPage(int currentPage, int pageSize, int countryId) {
		//分页方法
		PageHelper.startPage(currentPage, pageSize);
		//准备数据
		List<City> cities = cityDao.getCitiesByCountryId(countryId);
		return new PageInfo<City>(cities);
	}

	@Override
	public Result<City> insertCity(City city) {
		Result<City> result = new Result<>(ResultEnum.SUCCESS.status, "Insert success.");
		
		try {
			cityDao.insertCity(city);
			result.setObject(city);
		} catch (Exception e) {
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		
		return result;
	}

}
