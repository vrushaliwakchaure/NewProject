package com.mystore.utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public static void setExtent() throws IOException {
		
		sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyStoreReport.html");
		sparkReporter.config().setDocumentTitle("Automation Test Report");
		sparkReporter.config().setReportName("My Store Automation Project");
		sparkReporter.config().setTheme(Theme.DARK);
		
		
		sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("HostName", "DESKTOP-T3BPDF3");
		extent.setSystemInfo("ProjectName", "MyStoreProject");
		extent.setSystemInfo("Tester", "Vrushali");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	public static void endReport() throws IOException {
		extent.flush();
		Desktop.getDesktop().browse(new File("MyStoreReport.html").toURI());
	} 
}
