package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Asif");
		driver.findElement(By.xpath("//input[starts-with(@name,'las')]")).sendKeys("Khan");
		driver.findElement(By.xpath("//input[contains(@name,'pho')]")).sendKeys("123456789");
		driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.cssSelector("input[name$='1']")).sendKeys("1234 main Street");
		driver.findElement(By.name("city")).sendKeys("Alexandria");
		driver.findElement(By.name("state")).sendKeys("VA");
		driver.findElement(By.name("postalCode")).sendKeys("12345");
		
		int totalCountries= driver.findElements(By.cssSelector("selector[name='country']")).size();
		System.out.println(totalCountries);
		
		driver.findElement(By.id("email")).sendKeys("asifkhan");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("selenium");
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input[type='image']")).click();
		
		if(driver.getCurrentUrl().equals("http://newtours.demoaut.com/create_account_success.php")){
			System.out.println("Form was Succesfully submitted");
		}
		
		Thread.sleep(3000);
		driver.close();
		

	}

}
