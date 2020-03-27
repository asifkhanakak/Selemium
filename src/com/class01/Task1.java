package com.class01;

import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) {
		String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Asif Khan\\eclipse-workspace\\Selenium\\drivers\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.amazon.com");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title matches");
		} else {
			System.out.println("Title did not matches");
		}

		//System.out.println(driver.getPageSource());
		System.out.println("Current URL is   "+driver.getCurrentUrl());

		//driver.close();
	}

}
