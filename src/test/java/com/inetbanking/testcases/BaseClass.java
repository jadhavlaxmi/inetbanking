package com.inetbanking.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	
	ReadConfig readconfig=new ReadConfig();
 public String baseUrl =readconfig.getApplicationUrl();
 public String username=readconfig.getUserName();
 public String password=readconfig.getPassword();
 public static WebDriver driver;
 
 
 
 @Parameters("browser")
 @BeforeClass
	public void setUp(String br) {
	 logger.info("inetbanking");
	
	 if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfig.getChroPath());
		  driver=new ChromeDriver();
	 }
		
	 else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			  driver=new FirefoxDriver();
		 }
			
	 
	 else if(br.equals("edge")) {
			System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
			  driver=new EdgeDriver();
		 }
			
	 driver.get(baseUrl);
		logger.info("url opened");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
	}
 @AfterClass
	public void tearDown() {
		driver.quit();
		
	}
 public void captureScreen(WebDriver driver,String tname) throws IOException {
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File src=ts.getScreenshotAs(OutputType.FILE);
	 File target=new File(System.getProperty("user.dir")+ "/screenshot/"+tname+".png");
	 FileUtils.copyFile(src, target);
	 logger.info("screenshot captured");
 }
 
 public String randomestring() {
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
			
		}
	public static String randomNumber() {
		String generatedString2=RandomStringUtils.randomNumeric(4);
		return generatedString2;
			
		}
}
