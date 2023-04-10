package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.util.BaseClass;
import com.util.ReadExcelFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage extends BaseClass {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	ReadExcelFile testInput = new ReadExcelFile();

	By userNameLocator = By.xpath("//input[@name = 'username']");

	By passWordLocator = By.xpath("//input[@name = 'password']");

	By loginLocator = By.xpath("//button[@type = 'submit']");

	/*
	 * public void launchBrowser(String browserName) {
	 * 
	 * try { if(browserName.equalsIgnoreCase("Firefox")) {
	 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }
	 * 
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 * 
	 * }catch(Exception e) { System.out.println("Exception is "+e.getMessage()); }
	 * 
	 * }
	 */

	public void loginToTheApplication() {
		try {

			driver.get(url);
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

			String username = testInput.readTestDataExcel().get("Username");
			driver.findElement(userNameLocator).sendKeys(username);
			
			String password = testInput.readTestDataExcel().get("Password");
			driver.findElement(passWordLocator).sendKeys(password);
			
			driver.findElement(loginLocator).click();
			
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
}
