package com.example.javascripterrormsg;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookTest {
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities dc=DesiredCapabilities.chrome();
		LoggingPreferences lp=new LoggingPreferences();
		lp.enable(LogType.BROWSER, Level.ALL);
		dc.setCapability(CapabilityType.LOGGING_PREFS, lp);
		System.setProperty("webdriver.chrome.driver", "/home/nagendra/Downloads/chromedriver");
		driver=new ChromeDriver(dc);
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public void extractJsInfo() {
		LogEntries entries=driver.manage().logs().get(LogType.BROWSER);
		for(LogEntry entry:entries) {
			System.out.println(new Date(entry.getTimestamp()+"--->"+entry));
		}
	}
	@Test
	public void facebookTest() {
		driver.get("http://www.flipKart.com");
		extractJsInfo();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
