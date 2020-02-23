package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utilities.CommonMethods;
import com.utilities.Constants;

public class TestCase1 extends CommonMethods {

	public static void main(String[] args) {

		setUp("chrome", Constants.SYNTAX_PRACTICE_URL);
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		System.out.println("Number of rows= " + rows.size());

		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='table']/thead[2]/tr/th"));
		System.out.println("Number of Columns= " + cols.size());

		for (WebElement colHeader : cols) {
			System.out.print(colHeader.getText() + " ");
		}
		
		System.out.println();
		System.out.println("*************Rows Data******************");
		
		for (WebElement rowsData : rows) {
			System.out.println(rowsData.getText());
		}

	}

}
