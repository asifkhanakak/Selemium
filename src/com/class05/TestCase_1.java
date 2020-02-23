package com.class05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utilities.CommonMethods;
import com.utilities.Constants;

public class TestCase_1 extends CommonMethods{
	/* TC 1: JavaScript alert text verification
Open chrome browser
Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
Click on “Alerts & Modals” links
Click on “Javascript Alerts” links
Click on button in “Java Script Alert Box” section
Verify alert box with text “I am an alert box!” is present
Click on button in “Java Script Confirm Box” section
Verify alert box with text “Press a button!” is present
Click on button in “Java Script Alert Box” section
Enter text in the alert box
Quit browser*/


	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome","http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		
		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
		driver.findElement(By.linkText("Javascript Alerts")).click();
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		Alert alert2=driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert2.getText());
		alert2.dismiss();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		Alert alert3=driver.switchTo().alert();
		Thread.sleep(1000);
		alert3.sendKeys("Asif");
		Thread.sleep(2000);
		
		Thread.sleep(1000);
		System.out.println(alert3.getText());
		alert3.accept();
		System.out.println(driver.findElement(By.id("prompt-demo")).getText());
		
		String msg=driver.findElement(By.id("prompt-demo")).getText();
		
		if(msg.contains("Asif")) {
			System.out.println("Correct Name is Displayed");
		}else {
			System.out.println("No Name is Displayed");
		}
		
		//driver.quit();
		
		
		
		
		
		
		

	}

}
