package com.example.testSeleniumQuestions;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTab {

	
	@Test
	public void newTabTest() {
		
		System.setProperty("webdriver.chrome.driver", "/home/nagendra/"
				+ "Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		
		//By using JavascriptExecutor
		
		((JavascriptExecutor)driver).executeScript("window.open('mass', '-blank')");
        
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
       
       driver.get("http://www.google.com");
		
			
	}
}
