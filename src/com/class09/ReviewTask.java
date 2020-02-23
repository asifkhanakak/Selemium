package com.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.CommonMethods;
import com.utilities.Constants;

public class ReviewTask extends CommonMethods {

	public static void main(String[] args) {
		

		CommonMethods.setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.cssSelector("a#menu_recruitment_viewRecruitmentModule")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Candidates']")));
		
		driver.findElement(By.xpath("//a[text()='Candidates']")).click();
		
		/* //*[@id="resultTable"]/tbody/tr[1]/td[3]/a
		 *  //*[@id="resultTable"]/tbody/tr[2]/td[3]/a
		 *  //*[@id="resultTable"]/tbody/tr[3]/td[3]/a
		 *  //*[@id="resultTable"]/tbody/tr[4]/td[3]/a
		 */
		
		String firstHalfOfXpath= "//*[@id=\"resultTable\"]/tbody/tr[";
		String secondHalfOfXpath= "]/td[3]/a";
		
		List<WebElement> names=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		//WebDriverWait wait1=new WebDriverWait(driver, 30);
		//wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='resultTable']tbody/tr")));
		
		for(int i=1; i<names.size(); i++) {
			String name=driver.findElement(By.xpath(firstHalfOfXpath+i+secondHalfOfXpath)).getText();
			System.out.println(name);
		}
		
		
		
		
	}

}
