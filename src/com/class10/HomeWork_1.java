package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utilities.CommonMethods;

public class HomeWork_1 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * TC 1: Table headers and rows verification1.Open chrome browser 2.Go to
		 * “https://www.aa.com/homePage.do” 3 Enter From and To 4.Select departure as
		 * May 14 of 2020. 5 Select arrival as November 8 of 2020. 6 Verify “Choose
		 * flights” text is displayed7.Close browser 7.Close browser
		 */

		setUp("Chrome", "https://www.aa.com/");
		driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.originAirport']")).clear();
		driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.originAirport']")).sendKeys("iad");
		driver.findElement(By.xpath("//input[@ id='reservationFlightSearchForm.destinationAirport']")).sendKeys("jfk");

		// selecting Number of passengers from dropdown
		WebElement ddpass = driver
				.findElement(By.xpath("//select[contains(@onchange,'calcTotalNoOfPsgrsOnHomePage')]"));
		Select selecpassnum = new Select(ddpass);
		selecpassnum.selectByValue("4");

		// selecting departure date from calendar
		driver.findElement(By.xpath("//input[@id='aa-leavingOn']")).click();
		// driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();

		boolean flag = false;
		while (!flag) {
			String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			if (month.equals("May")) {
				List<WebElement> dates = driver
						.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
				for (WebElement date : dates) {
					String choosenDate = date.getText();
					if (choosenDate.equals("14")) {
						date.click();
						flag = true;
						break;
					}
				}
			}
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}

		// selecting return date
		driver.findElement(By.cssSelector("input#aa-returningFrom")).click();
		WebElement next = driver.findElement(By.xpath("//a[@title='Next']"));

		 flag = false;
		while (!flag) {
			//Thread.sleep(3000);
			String returnmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			System.out.println(returnmonth);
			if (returnmonth.equals("November")) {
				List<WebElement> returndate = driver
						.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
				for (WebElement rdate : returndate) {
					String chooseRD = rdate.getText();
					if (chooseRD.equals("8")) {
						rdate.click();
						flag = true;
						break;
					}

				}
				
			}
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}
		//clicking on search button
		driver.findElement(By.xpath("//input[@id='flightSearchForm.button.reSubmit']")).click();
	}

}
