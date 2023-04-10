package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.util.ReadExcelFile;

public class AddEmployeePage extends ReadExcelFile {

	WebDriver driver;

	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
	}

	ReadExcelFile testInput = new ReadExcelFile();

	public String employeeID;

	By addEmployeeSectionLocator = By.linkText("Add Employee");

	By firstNameLocator = By.xpath("//input[@name='firstName']");

	By middleNameLocator = By.xpath("//input[@name='middleName']");

	By lastNameLocator = By.xpath("//input[@name='lastName']");

	By employeeIdLocator = By
			.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");

	By employeeImageLocator = By.xpath("//img[@class='employee-image']");

	By saveButtonLocator = By.xpath("//button[@type='submit']");

	By createLoginDetailsToggleLocator = By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']");

	By userNameLocator = By.xpath(
			"(//input[@class='oxd-input oxd-input--active'])[3]");

	By passWordLocator = By.xpath("(//input[@type='password'])[1]");

	By confirmPasswordLocator = By.xpath("(//input[@type='password'])[2]");

	By employeeListSectionLocator = By.linkText("Employee List");

	public void clickOnAddEmployeeSection() {
		try {
			driver.findElement(addEmployeeSectionLocator).click();
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String addEmployeeWithoutLoginDetails() {
		try {
			driver.findElement(addEmployeeSectionLocator).click();
			String firstName = testInput.readTestDataExcel().get("Firstname");
			System.out.println("First name is " + firstName);
			driver.findElement(firstNameLocator).sendKeys(firstName);

			String middleName = testInput.readTestDataExcel().get("Middlename");
			driver.findElement(middleNameLocator).sendKeys(middleName);

			String lastName = testInput.readTestDataExcel().get("Lastname");
			driver.findElement(lastNameLocator).sendKeys(lastName);

			employeeID = driver.findElement(employeeIdLocator).getText();
			System.out.println("Employee ID is "+employeeID);

			/*driver.findElement(employeeImageLocator).click();
			driver.findElement(employeeImageLocator).sendKeys("C:\\Users\\VAISHNAVI KRISHNA\\Desktop\\Screenshots\\Sample.jpg");
			driver.findElement(saveButtonLocator).click();

			driver.findElement(employeeListSectionLocator).click();*/

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
		return employeeID;

	}

	public void addEmployeeWithLoginDeatils() {
		try {
			addEmployeeWithoutLoginDetails();
			
			Thread.sleep(1000);

			driver.findElement(createLoginDetailsToggleLocator).click();

			String userName = testInput.readTestDataExcel().get("EmpUsername");
			driver.findElement(userNameLocator).sendKeys(userName);

			String passWord = testInput.readTestDataExcel().get("EmpPassword");
			driver.findElement(passWordLocator).sendKeys(passWord);
			driver.findElement(confirmPasswordLocator).sendKeys(passWord);

			driver.findElement(saveButtonLocator).click();

			driver.findElement(employeeListSectionLocator).click();

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}
}
