package com.hqyj.sb01.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration：配置类
@Configuration
//@AutoConfigureAfter覆盖到哪个（WebMvcAutoConfiguration.class）配置文件
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebServerConfig {
	
	//@Value取值（从配置文件中）
	@Value("${http.port}")
	private int httpPort;

	//@Bean：将Connector注册成为一个Bean
	@Bean
	//1、连接器@Bean的设置
	public Connector connector() {
		Connector connector = new Connector();
		//添加支持哪种协议.setScheme---------------配置文件中（.keystore）已默认有为：https
		connector.setScheme("http");
		//默认端口.setPort
		connector.setPort(httpPort);
		return connector;
	}
	
	@Bean
	//2、注册  connector，将connector注册到ServletWebServerFactory中
	public ServletWebServerFactory servletWebServerFactory() {
		//实现类
		TomcatServletWebServerFactory tomcatFactory = new TomcatServletWebServerFactory();
		//添加额外的连接器，可使http使用
		tomcatFactory.addAdditionalTomcatConnectors(connector());
		return tomcatFactory;
	}
}