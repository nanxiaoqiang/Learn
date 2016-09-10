package com.nanxiaoqiang.test.springboot.springboot_simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页
 * 
 * @author nanxiaoqiang
 * 
 * @version 2016年7月23日
 */
@Controller
public class IndexConntroller {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("host", "https://github.com/nanxiaoqiang");
		return "index";
	}
}
