package com.class08;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utilities.CommonMethods;
import com.utilities.Constants;

public class Test_case extends CommonMethods {

	public static void main(String[] args) throws Exception {
		/*
		 * 1.Open chrome browser 2.Go to
		 * “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.
		 * aspx” 3.Login to the application 4.Verify customer “Susan McLaren” is present
		 * in the table 5.Click on customer details 6.Update customers last name
		 * 7.Verify updated customers name is displayed in table 8.Close browser
		 */
		String customerName = "Susan McLaren";

		CommonMethods.setUp("chrome", Constants.SMART_BEARSSOFTWARE_URL);

		driver.findElement(By.cssSelector("input#ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.cssSelector("input#ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button")).click();

		List<WebElement> names = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));

		System.out.println(names.size());

		for (int i = 1; i < names.size(); i++) {

			String singleName = names.get(i).getText();

			if (singleName.contains(customerName)) {

				driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[" + (i + 1) + "]/td[13]")).click();
				break;
			}
		}

		driver.findElement(By.xpath("//input[@value='Susan McLaren']")).clear();
		driver.findElement(By.xpath("//input[@value='Susan McLaren']")).sendKeys("Susan Joe");
		driver.findElement(By.xpath("//input[@value='Visa']")).click();
		driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox1")).clear();
		driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("04/20");
		driver.findElement(By.cssSelector("a#ctl00_MainContent_fmwOrder_UpdateButton")).click();

		List<WebElement> updated = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));

		String updatedName= "Susan Joe";
		
		Iterator<WebElement> nameIt = updated.iterator();
		while (nameIt.hasNext()) {
			String newName = nameIt.next().getText();
			
			if(newName.contains(updatedName)) {
				System.out.println(customerName+" name was sucsesfully updated to "+ updatedName);
				break;
			}
			
		}

		
	}

}
