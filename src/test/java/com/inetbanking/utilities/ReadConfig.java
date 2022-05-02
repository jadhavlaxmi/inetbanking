package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
   Properties pro;
   public ReadConfig() {
	   File src=new File("./configuration/config.properties");
	   
	   try {
		   FileInputStream fis=new FileInputStream(src);
		   pro=new Properties();
		   pro.load(fis);
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
   }
   public String getApplicationUrl() {
	   String url=pro.getProperty("baseUrl");
	return url;
	   
   }
   public String getUserName() {
	   String username=pro.getProperty("username");
	return username;
	   
   }
   public String getPassword() {
	   String password=pro.getProperty("password");
	return password;
	   
   }
   public String getChroPath() {
	   String chromepath=pro.getProperty("chromepath");
	return chromepath;
	   
   }
   public String getFirefoxPath() {
	   String firefoxpath =pro.getProperty("firefoxpath");
	return firefoxpath;
	   
   }
   public String getEdgePath() {
	   String edgepath=pro.getProperty("edgepath");
	return edgepath;
	   
   }
}
