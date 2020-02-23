package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class launchChromeBrowser {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Asif Khan\\eclipse-workspace\\Selenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
		
		String title=	driver.getTitle();
		System.out.println(title);
		
		String expectedUrl="https://www.google.com/";
		String actualUrl=driver.getCurrentUrl();
		System.out.println(actualUrl);
		
		if (expectedUrl.equals(actualUrl)){
			System.out.println("Expected Url and Actual url Matched");
		}else {
			System.out.println("Expected Url and Actual Url did not  Matched");
		}

		driver.navigate().to("https://yahoo.com");
	
		driver.navigate().back();
		driver.navigate().forward();
		driver.close();
	}

}
