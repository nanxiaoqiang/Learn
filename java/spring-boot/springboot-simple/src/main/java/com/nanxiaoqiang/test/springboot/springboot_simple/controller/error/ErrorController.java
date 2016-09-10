package com.nanxiaoqiang.test.springboot.springboot_simple.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nanxiaoqiang.test.springboot.springboot_simple.commons.exception.MyException;

/**
 * 自定义异常
 * 
 * @author nanxiaoqiang
 * 
 * @version 2016年7月23日
 */
@Controller
public class ErrorController {

	@RequestMapping(value = "/common_error", method = RequestMethod.GET)
	public String doError() throws Exception {
		throw new Exception("出错啦！");
	}

	/**
	 * 自定义异常，返回的是json
	 * @return
	 * @throws MyException
	 */
	@RequestMapping(value = "/my_error", method = RequestMethod.GET)
	public String doMyError() throws MyException {
		throw new MyException("自定义出错");
	}
}