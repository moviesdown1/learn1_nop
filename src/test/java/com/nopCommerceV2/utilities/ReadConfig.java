package com.nopCommerceV2.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		
		File src= new File("./Configuration/config.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	public String getApplicationUrl() {
		String url=pro.getProperty("baseurl");
		return url;
		
	}
	public String getUsername() {
		String uname=pro.getProperty("username");
		return uname;
		
	}
	public String getPassword() {
		String pwd=pro.getProperty("password");
		return pwd;
		
	}
	public String getChromePath() {
		String cpath=pro.getProperty("chromepath");
		return cpath;
		
	}
	public String getFirefoxPath() {
		String fpath=pro.getProperty("firefoxpath");
		return fpath;
		
	}
	

}
