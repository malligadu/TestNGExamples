package com.example.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleTest {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/nagendra/Downloads/chromedriver");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--diable-notifications");
		options.addArguments("--disable-infobars");
		driver=new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("http://www.google.com");
	
	}
	@Test
	public void test() {
		String title=driver.getTitle();
		Assert.assertEquals(title, "Google");
		Assert.assertTrue(driver.findElement(By.linkText("Gmail")).isDisplayed());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
