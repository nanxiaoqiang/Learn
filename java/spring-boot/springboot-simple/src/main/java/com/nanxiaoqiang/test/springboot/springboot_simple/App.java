package com.nanxiaoqiang.test.springboot.springboot_simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ServletComponentScan// 自动扫描@WeSbervlet、@WebFilter、@WebListener
public class App {

	public static void main(String[] args) {
		System.out.println(com.mysql.jdbc.Driver.class.getName());
		System.out.println("Hello World!");
		SpringApplication.run(App.class, args);
		
	}
}
