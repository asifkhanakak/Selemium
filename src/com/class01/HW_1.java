package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class HW_1 {

	public static void main(String[] args) {
		
//	TC 1: Facebook Forgot account link: 
//		   1.Open chrome browser
//			2.Navigate to Facebook
//			3.Validate that the expected  Facebook title matches the actual Facebook title    “Facebook - Log in or Sign up”
//			4.Click on Forgot account Links
//		    5.Validate that the expected  Facebook title matches the actual Facebook title “Forgot Password | Can't Log In | Facebook”
//			6.Navigate Back 7.Refresh the page 
//			8.Validate that the expected  Facebook title matches the actual Facebook title    “Facebook - Log in or Sign up”
//			9.Close the Browser 
//		
//		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asif Khan\\eclipse-workspace\\Selenium\\drivers\\chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		String title=driver.getTitle();
		System.out.println(title);
		driver.findElement(By.className("inputtext")).sendKeys("7037897462");;
		driver.findElement(By.id("pass")).sendKeys("taxi4677");;
		driver.findElement(By.id("u_0_2")).click();;
	//	driver.close();
		
		
		// Line 33 has been changed first time
		
		

	}

	private static String using() {
		// TODO Auto-generated method stub
		return null;
	}

}
