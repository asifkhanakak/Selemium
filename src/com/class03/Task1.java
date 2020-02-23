package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static final String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(url);
		driver.findElement(By.name("txtUsername")).sendKeys("VanEarl");

		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		WebElement errorMessage = driver.findElement(By.xpath("//span[@id='spanMessage']"));

		String messagePass = errorMessage.getText();

		if (errorMessage.isDisplayed()) {

			if (messagePass.equals("Password cannot be empty")) {
				System.out.println("Correct message displayed");
			} else {
				System.err.println("Incorrect Error Message displayed");
			}

		}
		
		WebElement image= driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div"));
		if(image.isDisplayed()) {
			System.out.println("Logo is displayed");
		}
		Thread.sleep(3000);
		driver.close();

	}

}
