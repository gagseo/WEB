package com.kh.common;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BmLogFactory {
	
	private BmLogFactory()   {
		//log4j.properties 파일불러오기
		PropertyConfigurator.configure("C:\\Users\\user2\\OneDrive\\WEB\\servlet01Project\\web\\WEB-INF\\config\\log4j.properties");
	}
	
	private static class BmLogFactoryHolder{
		
		private static final BmLogFactory instance = new BmLogFactory();
	}
		
	public static BmLogFactory getInstance() {
		return BmLogFactoryHolder.instance;
	}
	
	public Logger getLogger(Class className) {
		return Logger.getLogger(className);
	}
}
