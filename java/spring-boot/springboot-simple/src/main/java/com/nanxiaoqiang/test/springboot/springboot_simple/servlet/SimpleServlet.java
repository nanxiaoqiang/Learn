package com.nanxiaoqiang.test.springboot.springboot_simple.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * 简单的Serlvet的测试
 * 关于WebServlet标记：
 *   1、value表示拦截的地址，可以写多个：{"xxxa", "xxxb"}
 *   2、urlPattern和value的意思详细（前者貌似可以支持正则？需要看源码）
 *   3、name属性为命名，可写可不写
 * </pre>
 * 
 * @author nanxiaoqiang
 * 
 * @version 2016年7月30日
 */
@WebServlet(value = "/servlet/simple")
public class SimpleServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4563129149484703361L;

	public SimpleServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp);
		resp.getWriter().write("Hello Servlet 3");
		resp.getWriter().close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
