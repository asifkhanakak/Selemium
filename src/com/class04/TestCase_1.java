package com.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utilities.CommonMethods;


public class TestCase_1 extends CommonMethods {
	
	

	public static void main(String[] args) {
		/*
		 * TC 1: Facebook dropdown verification
		 * 1.Open chrome browser
		 * 2.Go to “https://www.facebook.com”
		 * 3.Verify:●month dd has 12 month options●day dd has 31 day options●year dd has 115 year options
		 * 4.Select your date of birth
		 * 5.Quit browser
		 */
		

		setUp("chrome","https://www.facebook.com");
		
		// Finding number of options for Month DropDown
		WebElement dropDown= driver.findElement(By.id("month"));
		Select obj=new Select(dropDown);
		
		List<WebElement> allValues=obj.getOptions();
		
		int monthDDSize=allValues.size();
		System.out.println("Total number of options in Month DropDown= "+(monthDDSize-1));
		
		// Finding number of options for day DropDown
		Select obj2= new Select(driver.findElement(By.cssSelector("select#day")));
		List<WebElement> dayDDValues=obj2.getOptions();
		System.out.println("Total number of options in Day DropDown= "+dayDDValues.size());
		
		// Finding number of options for Year DropDown
		Select obj3= new Select(driver.findElement(By.cssSelector("select#year")));
		List<WebElement> yearDD=obj3.getOptions();
		System.out.println("Total number of options in Year DropDown= "+yearDD.size());
		
		
		System.out.println("************************************************************");
		
		//To get Attribute from List elements
	String month= allValues.get(6).getAttribute("value");
	String day =  dayDDValues.get(4).getAttribute("value");
	String year = yearDD.get(30).getAttribute("value");
	
	System.out.println("My date of Birth is "+month+" "+day+" "+year);
	
	System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	
	// To Select Values from the drop down
	obj.selectByVisibleText("Mar");
	obj2.selectByValue("13");
	obj3.selectByIndex(34);
	
	String sMonth= allValues.get(3).getText();
	String sDay = dayDDValues.get(13).getText();
	String sYear = yearDD.get(35).getText();
	
		System.out.println("New date of birth by.getText() method= "+sMonth+" "+sDay+" "+sYear);
		
	
	}

}
