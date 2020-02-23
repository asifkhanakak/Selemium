package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utilities.CommonMethods;

public class Task2 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * C 2: Radio Buttons Practice  
              Open chrome browser
               Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
                Click on “Input Forms” links
                Click on “Radio Buttons Demo” links
                Click on any radio button in “Radio Button Demo” section.
                 Verify correct checkbox is clicked
                     Click on any radio button in “Group Radio Buttons Demo” section.
                 Verify correct checkbox is clicked
                   Quit browser
		 */
		
		CommonMethods.setUp("chrome", "http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		Thread.sleep(2000);
		
		WebElement mCheckbox=driver.findElement(By.xpath("//input[@name='optradio' and @value='Male']"));
		mCheckbox.click();
		
		if(mCheckbox.isSelected()) {
			System.out.println("Correct Checkbox is selected");
		}else {
			System.out.println("Incorrect Checkbox is selected");
		}
		//driver.close();
		
		
		
		
		
	}

}
