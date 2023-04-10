package com.validations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.util.BaseClass;

public class SearchValidation extends BaseClass {
	
	WebDriver driver;

	@BeforeTest
	public void logIn() {
		WebDriver driver = launchApplication();
		this.driver = driver;
	}

	@Test
	public void search() {
		HomePage searchApp = new HomePage(driver);
		driver = searchApp.search();
	}

	@AfterTest
	public void logOut() {
		logOutOfTheApplication(driver);
	}

}
