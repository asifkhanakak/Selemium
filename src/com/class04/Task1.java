package com.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utilities.CommonMethods;

public class Task1 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 1: Amazon Department List Verification1.Open chrome browser 2.Go to
		 * “http://amazon.com/” 3.Verify how many department options available.●Print
		 * each department ●Select Computers 4.Quit browser
		 */

		setUp("chrome", "https://www.amazon.com");
		WebElement depdd = driver.findElement(By.cssSelector("select#searchDropdownBox"));

		Select obj = new Select(depdd);
		List<WebElement> depddlist = obj.getOptions();

		// how many department options available
		System.out.println("Number of departments= " + depddlist.size());

		// Print each department
		for (WebElement dep : depddlist) {
			System.out.println(dep.getText());
		}
		
		// Select Computers
		obj.selectByVisibleText("Computers");
		Thread.sleep(2000);
		// obj.selectByValue("Baby"); did't work
		obj.selectByValue("search-alias=baby-products");
		
	

	}

}
