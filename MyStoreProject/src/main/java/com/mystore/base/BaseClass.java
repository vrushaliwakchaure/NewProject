package com.mystore.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.mystore.actiondrivers.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	//public static WebDriver driver;
	
	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	
	@BeforeSuite(groups= {"Smoke", "Sanity", "Regression"})
	
	public void loadConfig() throws IOException {
		
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		//used this class to initialize log4j env using dom tree
		
		try {
			prop = new Properties();
			//System.out.println("Super Contructor invoked");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static WebDriver getDriver() {
		//get driver from Thread local map
		return driver.get();
	}
	
	
	
	public static void launchApp(String browserName) {
		
		//WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		
		//String browserName= prop.getProperty("browser");
	
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			driver.set(new ChromeDriver());  // Set Browser to ThreadLocalMap
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			driver.set(new FirefoxDriver()); 
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup(); 
			//driver=new EdgeDriver();
			driver.set(new EdgeDriver());
		}
		
		
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(),10);
		Action.pageLoadTimeOut(getDriver(),30);
		getDriver().get(prop.getProperty("url"));
		
		
	}
	
	@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
	public void afterSuite() throws IOException {
		ExtentManager.endReport();
	}
	
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + filename + "_" + dateName + ".png";
		File finalDestination=new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		//String newImageString = "C:\\Users\\winma\\eclipse-workspace\\MyStoreProject\\Screenshots" + filename + "_"+ dateName + ".png";
		return destination;
	}
	
}
