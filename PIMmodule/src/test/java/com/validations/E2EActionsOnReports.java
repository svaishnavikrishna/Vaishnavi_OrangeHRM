package com.validations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.ReportsPage;
import com.util.BaseClass;

public class E2EActionsOnReports extends BaseClass {

	WebDriver driver;

	@BeforeTest
	public void logIn() {
		WebDriver driver = launchApplication();
		this.driver = driver;
	}

	@Test(priority = 0)
	public void searchPIMModule() {
		HomePage searchApp = new HomePage(driver);
		searchApp.search();
	}
	
	@Test(priority = 1)
	public void actionOnReports(){
		ReportsPage report = new ReportsPage(driver);
		report.addReport();
		report.deleteReport();
	}

	@AfterTest
	public void logOut() {
		logOutOfTheApplication(driver);
	}

}
