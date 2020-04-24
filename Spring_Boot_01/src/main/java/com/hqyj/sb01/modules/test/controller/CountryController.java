package com.hqyj.sb01.modules.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hqyj.sb01.modules.test.entity.Country;
import com.hqyj.sb01.modules.test.service.CountryService;

//控制器
@RestController
//公共的path路径
@RequestMapping("/api")
public class CountryController {
	
	//注入Service
	@Autowired
	private CountryService countryService;

	/**
	 * http://127.0.0.1/api/country/522
	 */
	//请求路径
	@RequestMapping("/country/{countryId}")
	//@PathVariable后形式参数  与  @RequestMapping("/cities/{countryId}")内获取到的参数一致
	//@PathVariable获取	@RequestMapping("/cities/{countryId}")内的参数
	public Country getCountryById(@PathVariable int countryId) {
		return countryService.getCountryById(countryId);
	}
	
	/**
	 * http://127.0.0.1/api/country?countryName=China
	 */
	@RequestMapping("/country")
	public Country getCountryByName(@RequestParam String countryName) {
		return countryService.getCountryByName(countryName);
	}
}
