package com.example.datatable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExampleDataTable {
	
	@Test
	public void testDataTable() {
	
		System.setProperty("webdriver.chrome.driver","/home/nagendra/"
				+ "Downloads/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		/*driver.get("file:///home/nagendra/eclipse-workspace/SeleniumProject/"
				+ "src/com/example/datahtml/datatable.html");*/
		driver.navigate().to("file:///home/nagendra/eclipse-workspace/SeleniumProject/"
				+ "src/com/example/datahtml/datatable.html");
		List<WebElement> rows=driver.findElements(By.tagName("tr"));
		System.out.println("total rows: =========== "+rows.size());
		
		List<WebElement> colums=driver.findElements(By.xpath("/html/body/table/tbody/tr[2"
				+"]/td"));
		System.out.println("total colums are: ============ "+colums.size());
		
		WebElement partiallink=driver.findElement(By.partialLinkText("oog"));
		System.out.println(partiallink.isDisplayed()+" ============ "+partiallink.getText());
		
		String xpath1="/html/body/table/tbody/tr[";
		String xpath2="]/td[";
		String xpath3="]";
		
		for(int row=2;row<=rows.size();row++) {
			for(int col=1;col<=colums.size();col++) {
				
				WebElement ele=driver.findElement(By.xpath(xpath1+row+xpath2+col+xpath3));
				/*System.out.println(row+" ======== "+col);
				ele.click();*/
				
				if(ele.getText().equals(partiallink.getText())) {
					ele.click();
					System.out.println("link is found at: ========= "+row+"  =========  "+col);
					break;
				}else {
					continue;
				}
		
				//driver.navigate().back();
				
		}
				
                // driver.quit();
	}
	

}
}