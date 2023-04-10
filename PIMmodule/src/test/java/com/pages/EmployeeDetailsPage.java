package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.util.ReadExcelFile;

public class EmployeeDetailsPage extends ReadExcelFile {

	WebDriver driver;

	public EmployeeDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	ReadExcelFile testInput = new ReadExcelFile();

	AddEmployeePage employeeDetails = new AddEmployeePage(driver);

	By employeeNameLocator = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
	
	By employeeNameAfterSuggestionsLocator = By.xpath("//div[@role='listbox']//div[1]");

	By employeeIdLocator = By.xpath(
			"//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");

	By searchButtonLocator = By.xpath("//button[normalize-space()='Search']");

	By resetButtonLocator = By.xpath("//button[@type='reset']");

	By employeeStatusLocator = By.xpath("//div[contains(text()='Full-Time Permanent')]");

	By supervisorNameLocator = By.xpath("(//input[@placeholder='Type for hints...'])[2]");

	By jobTitleLocator = By.xpath("//div[contains(text(),'Account Assistant')]");

	By subUnitLocator = By.xpath("//div[contains(text(),'OrangeHRM')]");

	By empNameInSearchResultsLocator = By.xpath("(//div[@role='cell'])[3]");

	By empIDInSearchResultsLocator = By.xpath("(//div[@role='cell'])[2]");

	By empStatusInSearchResultsLocator = By.xpath("(//div[@role='cell'])[6]");

	By empSupervisorNameInSearchResultsLocator = By.xpath("(//div[@role='cell'])[8]");

	By empJobTitleInSearchResultsLocator = By.xpath("(//div[@role='cell'])[5]");

	By empsubUnitInSearchResultsLocator = By.xpath("(//div[@role='cell'])[7]");

	By editButtonInSearchResultsLocator = By.xpath("(//button[@type='button'])[5]");

	By deleteButtonInSearchResultsLocator = By.xpath("(//button[@type='button'])[4]");

	By employeeListSectionLocator = By.linkText("Employee List");
	
	By yesDeleteInPopUp = By.linkText(" Yes, Delete ");

	public void searchByEmpName() {

		try {
			String userName = testInput.readTestDataExcel().get("EmpUsername");
			driver.findElement(employeeNameLocator).sendKeys(userName);
			driver.findElement(employeeNameAfterSuggestionsLocator).click();
			driver.findElement(searchButtonLocator);
			String userNameActual = driver.findElement(empNameInSearchResultsLocator).getText();
			Assert.assertEquals(userNameActual, userName);
			//driver.findElement(resetButtonLocator);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}

	public void searchByEmpID() {
		try {
			String empID = employeeDetails.employeeID;
			driver.findElement(employeeIdLocator).sendKeys(empID);
			driver.findElement(searchButtonLocator);
			String empIDActual = driver.findElement(empIDInSearchResultsLocator).getText();
			Assert.assertEquals(empIDActual, empID);
			driver.findElement(resetButtonLocator);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}

	public void searchByEmpStatus() {
		try {
			driver.findElement(employeeStatusLocator).click();
			driver.findElement(searchButtonLocator);
			String empStatusActual = driver.findElement(empStatusInSearchResultsLocator).getText();
			String empStatus = driver.findElement(employeeStatusLocator).getText();
			Assert.assertEquals(empStatusActual, empStatus);
			driver.findElement(resetButtonLocator);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public void searchBySupervisorName() {
		try {
			String supervisorName = testInput.readTestDataExcel().get("Username");
			driver.findElement(supervisorNameLocator).sendKeys(supervisorName);
			driver.findElement(searchButtonLocator);
			String supervisorNameActual = driver.findElement(empSupervisorNameInSearchResultsLocator).getText();
			Assert.assertEquals(supervisorNameActual, supervisorName);
			driver.findElement(resetButtonLocator);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public void searchByJobTitle() {
		try {
			driver.findElement(jobTitleLocator).click();
			driver.findElement(searchButtonLocator);
			String jobTitleActual = driver.findElement(empJobTitleInSearchResultsLocator).getText();
			String jobTitle = driver.findElement(jobTitleLocator).getText();
			Assert.assertEquals(jobTitleActual, jobTitle);
			driver.findElement(resetButtonLocator);
		} catch (Exception e) {
			System.out.println("Exception e " + e.getMessage());
		}

	}

	public void searchBySubUnit() {
		try {
			driver.findElement(subUnitLocator).click();
			driver.findElement(searchButtonLocator);
			String subUnitActual = driver.findElement(empsubUnitInSearchResultsLocator).getText();
			String subUnit = driver.findElement(subUnitLocator).getText();
			Assert.assertEquals(subUnitActual, subUnit);
			driver.findElement(resetButtonLocator);
		} catch (Exception e) {
			System.out.println("Exception e " + e.getMessage());
		}

	}

	public void editEmployeeDetails() {
		try {
			driver.findElement(editButtonInSearchResultsLocator).click();
			driver.findElement(employeeListSectionLocator).click();
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public void deleteEmployeeDetails() {
		try {
			driver.findElement(deleteButtonInSearchResultsLocator).click();
			driver.findElement(yesDeleteInPopUp).click();
			
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}

}
