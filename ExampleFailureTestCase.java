package com.example.testng;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExampleFailureTestCase {
	public WebDriver driver;
	public ExtentHtmlReporter htmlreport;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "/home/nagendra/Downloads/chromedriver");
		driver=new ChromeDriver();
		htmlreport=new ExtentHtmlReporter("./reports/"+new Date().toString()+".html");
		extent=new ExtentReports();
		extent.attachReporter(htmlreport);
		test=extent.createTest("Test"+new Date().toString());
		test.log(Status.INFO, "open browser");
		test.log(Status.INFO, "url entered");
		test.log(Status.INFO, "doing operations");
		//test.log(Status.FAIL, "failed somethig happen");
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			String path=System.getProperty("user.dir")+"/screenshot/"+new Date().toString()+".png";
			File dest=new File(path);
			try {
				FileUtils.copyFile(src, dest);
				test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		extent.flush();
		driver.quit();
	}
@Test
public void test() {
	
	driver.get("http://www.google.com");
	String title=driver.getTitle();
	Assert.assertEquals("Google", title);
	Assert.assertEquals(true, true);
	
}
}
