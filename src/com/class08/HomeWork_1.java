package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utilities.CommonMethods;
import com.utilities.Constants;

public class HomeWork_1 extends CommonMethods {

	/*
	 * 1: Delete Employee
	 * 
	 * 1 Open chrome browser 2 Go to
	 * “http://166.62.36.207/humanresources/symfony/web/index.php/auth” 3 Login into
	 * the application 4 Add Employee 5 Verify Employee has been added 6 Go to
	 * Employee List 7 Delete added Employee 8 Quit the browser
	 */
	public static void main(String[] args) throws Throwable {

		String empName = "Adam Rich";
		setUp("Chrome", Constants.HRMS_URL);

		// Signing in to the application
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();

		// clicking on add Employee
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();

		// Adding/saving Employee Details
		driver.findElement(By.id("firstName")).sendKeys("Adam");
		driver.findElement(By.id("lastName")).sendKeys("Rich");
		String firstName = driver.findElement(By.id("firstName")).getAttribute("value");
		String lastName = driver.findElement(By.id("lastName")).getAttribute("value");
		String empId = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();

		// Finding the added employee in the Table
		if (empName.equals(firstName + " " + lastName)) {
			System.out.println("New Employee " + empName + " was sucsesfully added,   TC Passed");
		} else {
			System.err.println("Employee was not added to the table,   Failed");
		}

		// Deleting the added employee from the Table
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
		boolean found = false;
		while (!found) {

			List<WebElement> table = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
			for (int i = 1; i < table.size(); i++) {
				String row = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]")).getText();
				// if (cell.contains(empId){} is also correct approach
				if (row.contains(firstName + " " + lastName)) {
					driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[1]")).click();
					Thread.sleep(2000);
					driver.findElement(By.cssSelector("input#btnDelete")).click();
					driver.findElement(By.cssSelector("input#dialogDeleteBtn")).click();
					System.out.println(row + " was deleted from the Employee List Table");
					found = true;
					break;
				}
			}
			driver.findElement(By.xpath("//a[text()='Next']")).click();
		}

	}

}
