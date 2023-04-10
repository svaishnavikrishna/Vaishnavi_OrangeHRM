package com.validations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.EmployeeDetailsPage;
import com.pages.HomePage;
import com.util.BaseClass;

public class SearchValidationsInEmployeeListPage extends BaseClass {
	WebDriver driver;

	@BeforeTest
	public void logIn() {
		WebDriver driver = launchApplication();
		this.driver = driver;
	}
	
	@Test
	public void empDetailsSearch() {
		HomePage searchApp = new HomePage(driver);
		searchApp.search();
		EmployeeDetailsPage searchEmp = new EmployeeDetailsPage(driver);
		searchEmp.searchByEmpName();
		searchEmp.searchByEmpID();
		searchEmp.searchByEmpStatus();
		searchEmp.searchBySupervisorName();
		searchEmp.searchByJobTitle();
		searchEmp.searchBySubUnit();
	}
	
	
	@AfterTest
	public void logOut() {
		logOutOfTheApplication(driver);
	}
	
	

}
