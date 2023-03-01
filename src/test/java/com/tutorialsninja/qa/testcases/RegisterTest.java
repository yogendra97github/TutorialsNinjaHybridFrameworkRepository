package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;

import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base{
	
	public RegisterTest() {
		super();
	}
	public WebDriver driver;
	RegisterPage registerpage;
	AccountSuccessPage accountsuccesspage;
	@BeforeMethod
	public void setup() {
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homepage = new HomePage(driver);
		registerpage =homepage.navigateToRegisterPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	
	public void verifyRegisteringAnAccountWithMandatoryFields() {

		accountsuccesspage=registerpage.registerWithMandatoryField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));
		Assert.assertEquals(accountsuccesspage.retrieveAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success Page is not displayed");
		
	
	}
	@Test(priority=2)
	public void verifyRegisteringAnAccountByProvidingAllTheField() {
		accountsuccesspage=registerpage.registerWithAllField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Utilities.generateTimeStamp(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));		
		Assert.assertEquals(accountsuccesspage.retrieveAccountSuccessPageHeading(),dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Success Page is not displayed");
		
	}
	@Test(priority=3)
	public void verifyRegisteringAccountWithExistingEmailAddress() {
		accountsuccesspage=registerpage.registerWithAllField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"));		
		Assert.assertEquals(registerpage.retrieveDuplicateEmailAddressWarning(),dataProp.getProperty("duplicateEmailWarning"));
		
		
	}
	@Test(priority=4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {
		
		registerpage.clickOnContinueButton();
		registerpage.displayStatusOfWarningMessage(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning"), dataProp.getProperty("passwordWarning"));

	}
}
