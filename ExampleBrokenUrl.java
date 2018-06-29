package com.example.testng;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExampleBrokenUrl {
	public List<WebElement> anchor;
	
	@Test
	public void brokenUrl() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "/home/nagendra/Downloads/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.com");
		anchor=driver.findElements(By.tagName("a"));
		System.out.println("Total links are present in page: ============ "+anchor.size());
		
		System.out.println("printing all links: ==========> ");
		for(WebElement e: anchor) {
			System.out.println(e.getAttribute("href"));
		}
		
		System.out.println("findout broken links: ============= >");
		
		for(WebElement e:anchor) {
			String url=e.getAttribute("href");
			
			verifyUrl(url);
		}
		driver.quit();
		
	}

	public void verifyUrl(String url) throws IOException {
		try {
		URL myurl=new URL(url);
		HttpsURLConnection httpurlconnection=(HttpsURLConnection)myurl.openConnection();
		httpurlconnection.connect();
		httpurlconnection.setConnectTimeout(3000);
		
		if(httpurlconnection.getResponseCode()==200) {
			System.out.println(" ===> "+url+" ===========> "+httpurlconnection.getResponseMessage());
			}
		else if(httpurlconnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
		System.out.println(" ====> "+url+" ===> "+httpurlconnection.getResponseMessage());
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			//System.out.println("finally block:");
		}
	}
	
	}


