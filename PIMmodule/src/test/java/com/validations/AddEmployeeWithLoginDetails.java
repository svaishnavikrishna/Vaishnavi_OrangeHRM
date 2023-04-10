package com.validations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.AddEmployeePage;
import com.pages.HomePage;
import com.util.BaseClass;

public class AddEmployeeWithLoginDetails extends BaseClass {

	WebDriver driver;

	@BeforeTest
	public void logIn() {
		WebDriver driver = launchApplication();
		this.driver = driver;
	}

	@Test
	public void addEmployee() {
		HomePage searchApp = new HomePage(driver);
		searchApp.search();
		AddEmployeePage addEmp = new AddEmployeePage(driver);
		addEmp.addEmployeeWithLoginDeatils();
	}

	@AfterTest
	public void logOut() {
		logOutOfTheApplication(driver);
	}

}
