package com.hqyj.sb01.modules.test.service;

import com.hqyj.sb01.modules.test.entity.Country;

public interface CountryService {

	Country getCountryById(int countryId);
	
	Country getCountryByName(String countryName);
}
