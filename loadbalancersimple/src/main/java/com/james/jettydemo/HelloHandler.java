package com.james.jettydemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HelloHandler extends AbstractHandler {
	public void handle(String target,Request baseRequest,HttpServletRequest request,HttpServletResponse response) 
	        throws IOException, ServletException{
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		
		System.out.println("before thread");
		new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("thread name:"+Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}.start();
		response.getWriter().println("hello world");
	}
}
