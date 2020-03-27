package com.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utilities.CommonMethods;
import com.utilities.Constants;

public class TestCase_4 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * 1.Open chrome browser 2.Go to “http://166.62.36.207/syntaxpractice/” 3.Click
		 * on “Input Forms” link 4.Click on “Input Form Submit” link 5.Using different
		 * locator submit the form and click on “Send” button 6.Quit the browser
		 */

		CommonMethods.setUp("chrome", Constants.SYNTAX_PRACTICE_URL);
		driver.manage().window().maximize();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Input Form Submit")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("first_name")).sendKeys("Mike");
		driver.findElement(By.name("last_name")).sendKeys("Tyson");
		driver.findElement(By.xpath("//input[@placeholder='E-Mail Address']")).sendKeys("abcd@gmail.com");
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("703-123-4567");
		driver.findElement(By.cssSelector("input[name='address']")).sendKeys("123 Main St");
		driver.findElement(By.xpath("//input[@data-bv-field='city']")).sendKeys("Alexandria");

		WebElement state = driver.findElement(By.xpath("//select[@class='form-control selectpicker']"));

		Select options = new Select(state);
		List<WebElement> stateSize = options.getOptions();
		System.out.println("Number of states= "+stateSize.size());
		Thread.sleep(2000);

		options.selectByVisibleText("Virginia");

		driver.findElement(By.xpath("//input[@class='form-control'  and @name='zip']")).sendKeys("22222");
		driver.findElement(By.name("website")).sendKeys("www.website.com");
		Thread.sleep(3000);

  // FIX THE FOLLOWING CODE		
	List<WebElement> radButtHosting = driver.findElements(By.xpath("//div[@class='col-md-4']"));
	System.out.println("Number of options to select   "+radButtHosting.size());
	radButtHosting.get(1).click();
	Thread.sleep(3000);
		for(WebElement rbh : radButtHosting) {
			String value=rbh.getAttribute("value");
			Thread.sleep(2000);
			
			if(value.equalsIgnoreCase("no"))  {
				rbh.click();
				break;
			}
			}
		WebElement check = driver.findElement(By.xpath("//input[@value='yes' and @type='radio']"));
		if (check.isEnabled() & !check.isSelected()) {
			check.click();
		}

		driver.findElement(By.xpath("//textarea[@class='form-control']"))
				.sendKeys("Project Descrepation is typed here");
		Thread.sleep(2000);
		String fName = driver.findElement(By.name("first_name")).getAttribute("value");
		String lName = driver.findElement(By.name("last_name")).getAttribute("value");
		System.out.println(fName + lName);
		driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[13]/div/button")).click();

		if (fName.equalsIgnoreCase("Mike") & (lName.equals("Tyson"))) {
			System.out.println("Data submited correctly");
		} else {
			System.out.println("Data was not submited correctly");
		}

	}

		}
