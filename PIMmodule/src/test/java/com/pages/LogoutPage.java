package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.util.BaseClass;

public class LogoutPage extends BaseClass {

	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By dropDown = By.xpath("//span[@class = 'oxd-userdropdown-tab']");

	By logOut = By.xpath("//a[contains(text(),'Logout')]");

	public void logoutOfTheApplication() {
		driver.findElement(dropDown).click();
		driver.findElement(logOut).click();
		driver.close();
	}

}
