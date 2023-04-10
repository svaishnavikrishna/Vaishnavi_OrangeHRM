package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.util.ReadExcelFile;

public class ReportsPage extends ReadExcelFile{
	
	WebDriver driver;

	public ReportsPage(WebDriver driver) {
		this.driver = driver;
	}

	ReadExcelFile testInput = new ReadExcelFile();
	
	
	
	By reportsSectionLocator = By.linkText("Reports");

	By addReportLocator = By.xpath("//button[normalize-space()='Add']");
	
	By reportNameLocator = By.xpath("//input[@placeholder='Type here ...']");
	
	By selectDisplayFieldGroupLocator = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[3]");
	
	By selectOptionInDisplayFieldGroupLocator = By.xpath("(//div[@role='option'])[2]");
	
	By selectDisplayFieldLocator = By.xpath("(//i)[10]");
	
	By addDisplayFieldLocator = By.xpath("(//i[@class='oxd-icon bi-plus'])[2]");
	
	By saveButtonLocator = By.xpath("//button[normalize-space()='Save']");
	
	By deleteButtonLocator = By.xpath("(//button[@type='button'])[5]");
	
	By yesDeleteInPopUpLocator = By.xpath("//button[normalize-space()='Yes, Delete']");
	
	public void addReport() {
		try {
		driver.findElement(reportsSectionLocator).click();
		WebElement addReport = driver.findElement(addReportLocator);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", addReport);
		
		//driver.findElement(addReportLocator).click();
		
		driver.findElement(reportNameLocator).sendKeys("AAA");
		
		WebElement selectDisplayFieldGroup = driver.findElement(selectDisplayFieldGroupLocator);
		
		Actions action = new Actions(driver);
		action.click(selectDisplayFieldGroup);
		
		//j.executeScript("arguments[0].click();", selectDisplayFieldGroup);
		
		WebElement selectOptionInDisplayFieldGroup = driver.findElement(selectOptionInDisplayFieldGroupLocator);
		
		j.executeScript("arguments[0].click();", selectOptionInDisplayFieldGroup);
		
		
		//driver.findElement(selectDisplayFieldGroupLocator).click();
		
		driver.findElement(selectDisplayFieldLocator).click();
		
		driver.findElement(addDisplayFieldLocator).click();
		
		driver.findElement(saveButtonLocator).click();
		
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
		
	}
	
	public void deleteReport() {
		try {
			driver.findElement(reportsSectionLocator).click();
			
			driver.findElement(deleteButtonLocator).click();
			
			WebElement yesDelete = driver.findElement(yesDeleteInPopUpLocator);
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", yesDelete);
			
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
}
