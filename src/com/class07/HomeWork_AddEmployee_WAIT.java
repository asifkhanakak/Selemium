package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.CommonMethods;

public class HomeWork_AddEmployee_WAIT extends CommonMethods{
	
	public static void main(String[] args) throws InterruptedException {
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).submit();
		//Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		
		driver.findElement(By.linkText("PIM")).click();
		//Thread.sleep(3000);
		
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("PIM")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Add Employee']")));
		
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Fatma");
		
		driver.findElement(By.name("lastName")).sendKeys("HZ");
		
		driver.findElement(By.xpath("//input[@id='btnSave']")).submit();
		//Thread.sleep(3000);
		
		
		WebDriverWait wait1=new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.cssSelector("a#welcome"))));
	
		driver.findElement(By.cssSelector("a#welcome")).click();
		//Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Logout")));
		//Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Employee was added then Logedout sucessfully ");
		driver.quit();
		}

}
