package com.hqyj.sb02.modules.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@RequestMapping("/test/appDesc")
	@ResponseBody
	public String getDsc(){
		return "Hello world,springboot WJB";
	}
}
