package com.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pages.LoginPage;
import com.pages.LogoutPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
	
	/*public BaseClass(WebDriver driver) {
		this.driver = driver;
	}*/
	
	public ReadPropertiesFile properties = new ReadPropertiesFile();
	
	public String url = properties.getApplicationUrl();
	public String browser = properties.getBrowserType();
	
	public void launchBrowser() {
	
	if(browser.equalsIgnoreCase("ff") || browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();	
	}
	
}
	
	public WebDriver launchApplication() {
		
		launchBrowser();
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToTheApplication();
		return driver;
		
	}
	
	public void logOutOfTheApplication(WebDriver driver) {
		LogoutPage logOut = new LogoutPage(driver);
		logOut.logoutOfTheApplication();
	}
}
