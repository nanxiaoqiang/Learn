package com.nanxiaoqiang.test.springboot.springboot_simple.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异步Servlet
 * 
 * @author nanxiaoqiang
 * 
 * @version 2016年7月30日
 */
@WebServlet(value = "/servlet/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5907515272301939233L;

	public AsyncServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp);
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doPost(req, resp);
		// resp.setContentType("text/plan;charset=UTF-8");// 设置了这个有时候浏览器会直接把repsonse当作文本下载下来
		resp.setCharacterEncoding("UTF-8");
		final PrintWriter writer = resp.getWriter();
		writer.write("中文输出第一句。\n");
		writer.flush();
		// 开启异步
		final AsyncContext asyncContext = req.startAsync();
		asyncContext.setTimeout(20000L);// 设置超时20s
		asyncContext.addListener(new MyAsyncListenser());
		// 只要设置了超时，后表不必用asyncContext.start(……)
		// 可以之间new Runnable()，然后x.start();
		asyncContext.start(new Runnable() {

			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(5L);
					writer.write("异步输出的话，sleep 5秒了。\n");
					writer.flush();
					
					asyncContext.complete();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		writer.write("最后输出的话。在异步的外边。\n");
		writer.flush();
	}

	/**
	 * 异步监听(超时的话还是有问题)
	 * @author nanxiaoqiang
	 * 
	 * @version 2016年7月30日
	 */
	private class MyAsyncListenser implements AsyncListener {

		@Override
		public void onComplete(AsyncEvent e) throws IOException {
			e.getSuppliedResponse().getWriter().write("异步完成！\n");
		}

		@Override
		public void onError(AsyncEvent e) throws IOException {
			e.getSuppliedResponse().getWriter().write("异步出错！\n");
			e.getSuppliedResponse().getWriter().flush();
			e.getSuppliedResponse().getWriter().close();
		}

		@Override
		public void onStartAsync(AsyncEvent e) throws IOException {
			e.getSuppliedResponse().getWriter().write("异步开始！\n");
		}

		@Override
		public void onTimeout(AsyncEvent e) throws IOException {
			e.getSuppliedResponse().getWriter().write("异步超时！\n");
			e.getSuppliedResponse().getWriter().flush();
			e.getSuppliedResponse().getWriter().close();// 不结束会相当于报异常然后跳转到公用Exception页面
		}
		
	}
}
