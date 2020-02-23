package com.class10;

import org.openqa.selenium.By;

import com.utilities.CommonMethods;
import com.utilities.Constants;

public class Class_task_1 extends CommonMethods {

	public static void main(String[] args) {
		setUp("chrome", Constants.HRMS_URL);
		// login into HRMS
		String userName = "Admin";
		String password = "Hum@nhrm123";
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		//driver.findElement(By.id("btnLogin")).click();
	}

}
