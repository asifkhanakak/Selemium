package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utilities.CommonMethods;

public class TestCase extends CommonMethods{
	/*
	 * Open chrome browser
Go to “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
Login to the application
Verify customer “Susan McLaren” is present in the table
Click on customer details

	 */
	
	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		//login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		//search for Bob Feather
		String expectedValue="Susan McLaren";
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		for(int i=1; i<rows.size(); i++) {
			String rowText=rows.get(i-1).getText();//rowa.get(i-1)because List<> index start from [0]
			System.out.println(rowText);           // and Table values start from [1]
			if(rowText.contains(expectedValue)) {
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+(i)+"]/td[13]")).click();
			}
		}

		Thread.sleep(4000);
	//	driver.quit();
	}

}
