package com.james.jettydemo;

import org.eclipse.jetty.server.Server;

public class SimplestServer {
	
	private static void startServer(){
		Server server = new Server(8080);
		server.setHandler(new HelloHandler());
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		startServer();
	}
	
}
