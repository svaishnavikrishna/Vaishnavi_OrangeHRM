package com.validations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.ConfigurationPage;
import com.pages.HomePage;
import com.util.BaseClass;

public class E2EActionsOnConfiguration extends BaseClass {
	
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
	public void actionOnConfiguration(){
		ConfigurationPage config = new ConfigurationPage(driver);
		/*config.actionOnOptionalFields();
		config.actionOnCustomFields();
		config.actionOnDataImport();*/
		config.actionOnReportingMethods();
		config.actionOnTerminationProcess();
	}
	
	@AfterTest
	public void logOut() {
		logOutOfTheApplication(driver);
	}

}
