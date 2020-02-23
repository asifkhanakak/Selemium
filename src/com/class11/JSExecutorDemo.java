package com.class11;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.*;

import com.utilities.CommonMethods;
import com.utilities.Constants;

public class JSExecutorDemo extends CommonMethods{

	public static void main(String[] args) throws Exception {
		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Syntax@123");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		js.executeScript("arguments[0].style.backgroundColor='Red'", loginBtn);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", loginBtn);
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,22050)");
		Thread.sleep(5000);
		driver.quit();
	}

}
