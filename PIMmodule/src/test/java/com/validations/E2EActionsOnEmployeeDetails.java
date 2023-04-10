package com.validations;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.AddEmployeePage;
import com.pages.EmployeeDetailsPage;
import com.pages.HomePage;
import com.util.BaseClass;

public class E2EActionsOnEmployeeDetails extends BaseClass {

	WebDriver driver;

	@BeforeTest
	public void logIn() {
		WebDriver driver = launchApplication();
		this.driver = driver;
	}

	@Test(priority = 0)
	public void addEmpDetails() {
		HomePage searchApp = new HomePage(driver);
		searchApp.search();
		AddEmployeePage addEmp = new AddEmployeePage(driver);
		addEmp.addEmployeeWithLoginDeatils();
	}

	@Test(priority = 1)
	public void searchEmpDetails() {
		EmployeeDetailsPage searchEmp = new EmployeeDetailsPage(driver);
		searchEmp.searchByEmpName();
		/*searchEmp.searchByEmpID();
		searchEmp.searchByEmpStatus();
		searchEmp.searchBySupervisorName();
		searchEmp.searchByJobTitle();
		searchEmp.searchBySubUnit();*/
	}

	@Test(priority = 2)
	public void editEmpDetails() {
		EmployeeDetailsPage editEmp = new EmployeeDetailsPage(driver);
		editEmp.editEmployeeDetails();
	}
	
	@Test(priority = 3)
	public void deleteEmpDetails() {
		EmployeeDetailsPage searchEmp = new EmployeeDetailsPage(driver);
		searchEmp.searchByEmpName();
		EmployeeDetailsPage deleteEmp = new EmployeeDetailsPage(driver);
		deleteEmp.deleteEmployeeDetails();
	}

	@AfterTest
	public void logOut() {
		logOutOfTheApplication(driver);
	}

}
