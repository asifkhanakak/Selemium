package com.class05;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.utilities.CommonMethods;

public class TestCase_3 extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		/*1.Open chrome browser
		 * 2.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
		 * 3.Click on “Javascript Alerts” link
		 * 4.Click on “Window Popup Modal” link
		 * 5.Click on the “ Follow On Instagram” button
		 * 6.Verify title of the page is “Syntax Technologies (@syntaxtechs) • Instagram photos and videos” 
		 * 7.Click on the “Like us On Facebook ” button
		 * 8.Verify title of the page is “Go to Facebook Home” 
		 * 9.Quit the browser
		 */

		CommonMethods.setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Alerts & Modals")).click();
		driver.findElement(By.linkText("Window Popup Modal")).click();
		driver.findElement(By.xpath("//a[@title='Follow @syntaxtech on Instagram']")).click();
		
		Set<String> handle=driver.getWindowHandles();
		System.out.println("Number of Windows= "+handle.size());
		
		Iterator<String> it=handle.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		
		System.out.println("Parrent/current Window is= "+parentWindow);
		System.out.println("Child Window is = "+childWindow);
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//a[@title='Follow @syntaxtech on Facebook'] ")).click();
		
		Set<String> handle1=driver.getWindowHandles();
		
		Iterator<String> it1= handle1.iterator();
		parentWindow=it1.next();
		childWindow= it1.next();
		
		driver.switchTo().window(childWindow);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		
		driver.quit();
		
		
	}

}