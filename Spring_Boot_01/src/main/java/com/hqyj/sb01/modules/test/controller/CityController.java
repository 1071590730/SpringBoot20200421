package com.hqyj.sb01.modules.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.hqyj.sb01.modules.common.vo.Result;
import com.hqyj.sb01.modules.test.entity.City;
import com.hqyj.sb01.modules.test.service.CityService;

//控制器
@RestController
//公共的path路径
@RequestMapping("/api")
public class CityController {
	
	//注入Service
	@Autowired
	private CityService cityService;

	//请求路径
	@RequestMapping("/cities/{countryId}")
	//@PathVariable后形式参数  与  @RequestMapping("/cities/{countryId}")内获取到的参数一致
	//@PathVariable获取	@RequestMapping("/cities/{countryId}")内的参数
	public List<City> getCitiesByCountryId(@PathVariable int countryId) {
		return cityService.getCitiesByCountryId(countryId);
	}
	
	/**
	 * 127.0.0.1/api/cities?currentPage=1&pageSize=10&countryId=522
	 */
	@RequestMapping("/cities")
	public PageInfo<City> getCitiesByPage(@RequestParam int currentPage, 
			@RequestParam int pageSize, @RequestParam int countryId) {
		return cityService.getCitiesByPage(currentPage, pageSize, countryId);
	}
	
	@PostMapping(value="/city", consumes="application/json")
	public Result<City> insertCity(@RequestBody City city) {
		return cityService.insertCity(city);
	}
}
