package com.nanxiaoqiang.test.springboot.springboot_simple.commons.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nanxiaoqiang.test.springboot.springboot_simple.commons.dto.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception exception) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", request.getRequestURI());
		mav.setViewName("error");
		return mav;
	}

	@ExceptionHandler(value = MyException.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, MyException exception) throws Exception {
		ErrorInfo<String> r = new ErrorInfo<>();
		r.setCode(ErrorInfo.ERROR);
		r.setMessage(exception.getMessage());
		r.setDate("自定义消息！");
		r.setUrl(request.getRequestURI());
		return r;
	}
}
