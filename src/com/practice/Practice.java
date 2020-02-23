package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utilities.CommonMethods;

public class Practice extends CommonMethods {
	public static void main(String[] args) {

		CommonMethods.setUp("Chrome", "http://166.62.36.207/Syntax_HRM/symfony/web/index.php/auth/login");
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Syntax@123");
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		jsClick(loginBtn);
		WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		jsClick(admin);
		
		Actions action=new Actions(driver);
		WebElement usrMangt=driver.findElement(By.id("menu_admin_UserManagement"));
		action.moveToElement(usrMangt).perform();
		action.click(driver.findElement(By.id("menu_admin_viewSystemUsers"))).perform();
	}
}
