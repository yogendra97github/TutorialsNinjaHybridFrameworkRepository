package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {
	public LoginTest() {
		super();
	}

	public WebDriver driver;
	LoginPage loginpage;
	AccountPage accountpage;

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homepage = new HomePage(driver);
		loginpage = homepage.navigateToLoginPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {

		accountpage = loginpage.Login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		Assert.assertTrue(accountpage.getDisplayStatusOfEditYourAccountInformationOption(),"Edit your account information");

	}

	@DataProvider(name = "validCredentialsSupplier")
	public Object[][] supplyTestData() {

		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 2)
	public void verifyLogininWithInvalidCredentials() {

		loginpage.Login(Utilities.generateTimeStamp(), dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(loginpage.retrieveEmailPasswordNotMatchingWarningMessageText(),dataProp.getProperty("emailPasswordNotMatchWarning"));

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() {

		loginpage.Login(Utilities.generateTimeStamp(), prop.getProperty("validPassword"));
		Assert.assertEquals(loginpage.retrieveEmailPasswordNotMatchingWarningMessageText(),dataProp.getProperty("emailPasswordNotMatchWarning"));

	}

	@Test(priority = 4)
	public void verifyLoginWithvalidEmailAndInValidPassword() {
		loginpage.Login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		Assert.assertEquals(loginpage.retrieveEmailPasswordNotMatchingWarningMessageText(), dataProp.getProperty("emailPasswordNotMatchWarning"));

	}

	@Test(priority = 5)
	public void verifyLoginWithoutProvidingCredentials() {

		loginpage.clickOnLoginButton();
		Assert.assertEquals(loginpage.retrieveEmailPasswordNotMatchingWarningMessageText(), dataProp.getProperty("emailPasswordNotMatchWarning"));

	}

}
