package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.ReadExcelFile;

public class ConfigurationPage extends ReadExcelFile {

	WebDriver driver;

	public ConfigurationPage(WebDriver driver) {
		this.driver = driver;
	}

	ReadExcelFile testInput = new ReadExcelFile();

	By employeeListSectionLocator = By.linkText("Employee List");

	By configurationSectionLocator = By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent']");

	By optionalFieldsLocator = By.linkText("Optional Fields");
	By saveButtonInOptionalFieldsLocator = By.xpath("//button[@type='submit']");

	By customFieldsLocator = By.linkText("Custom Fields");
	By addButtonInCustomFieldsLocator = By.xpath("//button[normalize-space()='Add']");
	By fieldNameInCustomFieldsLocator = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By screenInCustomFieldsLocator = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
	By screenOptionInCustomFieldsLocator = By.xpath("(//div[@role='option'])[2]");
	By typeInCustomFieldsLocator = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
	By typeOptionInCustomFieldsLocator = By.xpath("(//div[@role='option'])[2]");
	By deleteInCustomFieldsLocator = By.xpath("(//button[@type='button'])[3]");
	By yesDeletePopUpInCustomFieldsLocator = By.xpath("//button[normalize-space()='Yes, Delete']");

	By dataImportLocator = By.linkText("Data Import");

	By reportingMethodsLocator = By.linkText("Reporting Methods");
	By addButtonInReportingMethodsLocator = By.xpath("//button[normalize-space()='Add']");
	By nameInReportingMethodsLocator = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By saveInReportingMethodsLocator = By.xpath("//button[normalize-space()='Save']");
	By deleteInReportingMethodsLocator = By.xpath("(//button[@type='button'])[3]");
	By yesDeletePopUpInReportingMethodsLocator = By.xpath("//button[normalize-space()='Yes, Delete']");

	By terminationReasonsLocator = By.linkText("Termination Reasons");
	By addButtonInTerminationReasonsLocator = By.xpath("//button[normalize-space()='Add']");
	By nameInTerminationReasonsLocator = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By saveInTerminationReasonsLocator = By.xpath("//button[normalize-space()='Save']");
	By deleteInTerminationReasonsLocator = By.xpath("(//button[@type='button'])[3]");
	By yesDeletePopUpInTerminationReasonsLocator = By.xpath("//button[normalize-space()='Yes, Delete']");
	

	public void actionOnOptionalFields() {
		try {
			driver.findElement(employeeListSectionLocator).click();

			driver.findElement(configurationSectionLocator).click();

			driver.findElement(optionalFieldsLocator).click();

			JavascriptExecutor j = (JavascriptExecutor) driver;
			WebElement saveButton = driver.findElement(saveButtonInOptionalFieldsLocator);
			j.executeScript("arguments[0].click();", saveButton);

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public void actionOnCustomFields() {
		try {

			driver.findElement(employeeListSectionLocator).click();

			driver.findElement(configurationSectionLocator).click();

			driver.findElement(customFieldsLocator).click();

			JavascriptExecutor j = (JavascriptExecutor) driver;
			WebElement addButton = driver.findElement(addButtonInCustomFieldsLocator);
			j.executeScript("arguments[0].click();", addButton);

			driver.findElement(fieldNameInCustomFieldsLocator).sendKeys("AAA");

			driver.findElement(screenInCustomFieldsLocator).click();

			driver.findElement(screenOptionInCustomFieldsLocator).click();

			driver.findElement(typeInCustomFieldsLocator).click();

			driver.findElement(typeOptionInCustomFieldsLocator).click();

			WebElement saveButton = driver.findElement(saveButtonInOptionalFieldsLocator);
			j.executeScript("arguments[0].click();", saveButton);

			driver.findElement(deleteInCustomFieldsLocator).click();

			WebElement yesDelete = driver.findElement(yesDeletePopUpInCustomFieldsLocator);
			j.executeScript("arguments[0].click();", yesDelete);

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public void actionOnDataImport() {
		try {
			driver.findElement(employeeListSectionLocator).click();

			driver.findElement(configurationSectionLocator).click();

			driver.findElement(dataImportLocator).click();
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public void actionOnReportingMethods() {
		try {
			driver.findElement(employeeListSectionLocator).click();

			driver.findElement(configurationSectionLocator).click();

			driver.findElement(reportingMethodsLocator).click();
			
			JavascriptExecutor j = (JavascriptExecutor) driver;
			WebElement addButton = driver.findElement(addButtonInReportingMethodsLocator);
			j.executeScript("arguments[0].click();", addButton);
			
			driver.findElement(nameInReportingMethodsLocator).sendKeys("AAA");
			
			WebElement saveButton = driver.findElement(saveInReportingMethodsLocator);
			j.executeScript("arguments[0].click();", saveButton);
			
			driver.findElement(deleteInReportingMethodsLocator).click();

			WebElement yesDelete = driver.findElement(yesDeletePopUpInReportingMethodsLocator);
			j.executeScript("arguments[0].click();", yesDelete);
			
			
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public void actionOnTerminationProcess() {
		try {
			driver.findElement(employeeListSectionLocator).click();

			driver.findElement(configurationSectionLocator).click();

			driver.findElement(terminationReasonsLocator).click();
			
			JavascriptExecutor j = (JavascriptExecutor) driver;
			WebElement addButton = driver.findElement(addButtonInTerminationReasonsLocator);
			j.executeScript("arguments[0].click();", addButton);
			
			driver.findElement(nameInTerminationReasonsLocator).sendKeys("AAA");
			
			WebElement saveButton = driver.findElement(saveInTerminationReasonsLocator);
			j.executeScript("arguments[0].click();", saveButton);
			
			driver.findElement(deleteInTerminationReasonsLocator).click();

			WebElement yesDelete = driver.findElement(yesDeletePopUpInTerminationReasonsLocator);
			j.executeScript("arguments[0].click();", yesDelete);
			
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

}
