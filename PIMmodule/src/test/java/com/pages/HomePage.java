package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchField = By.xpath("//input[@placeholder = 'Search']");
	By searchResult = By.linkText("PIM");
	
	public WebDriver search() {
		try {
			driver.findElement(searchField).sendKeys("PIM");
			driver.findElement(searchResult).click();
			
		}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		return driver;
	}

}
