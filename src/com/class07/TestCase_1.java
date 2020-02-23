package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.CommonMethods;

public class TestCase_1 extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
	/* TC 1: Verify element is present

1 Open chrome browser
 2 Go to “https://the-internet.herokuapp.com/”
3 Click on “Click on the “Dynamic Loading” link
4 Click on “Example 1...” and click on “Start”
5 Verify element with text “Hello World!” is displayed
6Close the browser*/
		
		
		setUp("Chrome","https://the-internet.herokuapp.com");
		
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Start']")).click();
				
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#finish")));
		
	boolean check=	driver.findElement(By.cssSelector("div#finish")).isDisplayed();
	
	String text= driver.findElement(By.cssSelector("div#finish")).getText();
		
		if(check) {
			System.out.println(text+" is Displayed, test pass");
		}else {
			System.out.println("Failed");
		}
		

	}

}
