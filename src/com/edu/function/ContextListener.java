package com.edu.function;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//获取上下文并获取路径
		ServletContext sContext=sce.getServletContext();
		ContextPath.path=sContext.getRealPath("/upload/");
	}

}
