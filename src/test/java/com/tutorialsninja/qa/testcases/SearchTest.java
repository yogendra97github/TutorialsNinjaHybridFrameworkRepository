package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base {
	public SearchTest() {
		super();
	}
	
	public WebDriver driver;
	SearchPage searchpage;
	HomePage homepage;
	
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		homepage = new HomePage(driver);

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		HomePage homepage = new HomePage(driver);

		searchpage=homepage.verifySearch(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchpage.displayStatusOfHPValidProduct());
	
		
	}
	@Test(priority=2, dependsOnMethods= {"verifySearchWithValidProduct"})
	public void verifySearchWithInvalidProduct() {
		HomePage homepage = new HomePage(driver);

		searchpage=homepage.verifySearch(dataProp.getProperty("invalidProduct"));
		Assert.assertTrue(searchpage.displayStatusOfInvalidProduct(), "There is no product that matches the search criteria.");
		
	
	}
	@Test(priority=3)
	public void verifySearchWithoutAnyProduct() {
		HomePage homepage = new HomePage(driver);

		searchpage=homepage.clickOnSearchButton();
		Assert.assertTrue(searchpage.displayStatusOfInvalidProduct(), "There is no product that matches the search criteria.");
		
	}

}
