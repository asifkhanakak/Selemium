package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LaunchFirefoxBrowser {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Asif Khan\\eclipse-workspace\\Selenium\\drivers\\geckodriver.exe");
		
		WebDriver driver2 = new FirefoxDriver();
		driver2.get("https://google.com");
		driver2.manage().window().maximize();

	}

}
