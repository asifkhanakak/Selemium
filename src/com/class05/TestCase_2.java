package com.class05;

import org.openqa.selenium.By;

import com.utilities.CommonMethods;
import com.utilities.Constants;

public class TestCase_2 extends CommonMethods {

	/*
	 * 1.Open chrome browser 2.Go to
	 * “http://jiravm.centralus.cloudapp.azure.com:8081/index.html” 3.Click on
	 * “Others” link 4.Click on “Iframe” link 5.Click on the “Home” link inside the
	 * one frame 6.Verify “Syntax logo” is displayed in another frame 7.Quit browser
	 */

	public static void main(String[] args) throws InterruptedException {
		CommonMethods.setUp("chrome", Constants.SYNTAX_PRACTICE_URL);

		driver.findElement(By.linkText("Others")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Iframe")).click();
		driver.manage().window().maximize();

		Thread.sleep(3000);

		driver.switchTo().frame("FrameTwo");
		driver.findElement(By.xpath("//img[@alt='Syntax Technologies' and @class='custom-logo']")).click();
		
		driver.switchTo().defaultContent();

		Thread.sleep(3000);
		driver.switchTo().frame("FrameOne");
		boolean logo = driver.findElement(By.xpath("//img[@id='hide']")).isDisplayed();
		System.out.println("Is Syntax Logo displayed in frame One=  "+logo);
		driver.switchTo().defaultContent();
		
		driver.close();
		driver.quit();

	}

}
