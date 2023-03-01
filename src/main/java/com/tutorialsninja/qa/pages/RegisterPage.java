package com.tutorialsninja.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;

	@FindBy(id="input-email")
	private WebElement emailAddressField;

	@FindBy(id="input-telephone")
	private WebElement telephoneField;

	@FindBy(id="input-password")
	private WebElement passwordField;

	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(name="agree")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOption;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailAddressWarning;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailAddressWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneNumberWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	
	WebDriver driver;
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public AccountSuccessPage registerWithMandatoryField(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailAddressField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(passwordText);
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	
		
		
	}
	public AccountSuccessPage registerWithAllField(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText) {
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailAddressField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		confirmPasswordField.sendKeys(passwordText);
		yesNewsLetterOption.click();
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	
		
		
	}
	
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordField.sendKeys(confirmPasswordText);
	}
	
	public void selectPrivacyPolicy() {
		privacyPolicyField.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void selectYesNewsLetterOption() {
		
		yesNewsLetterOption.click();
	}
	
	public String retrieveDuplicateEmailAddressWarning() {
		
		String duplicateEmailWarningText = duplicateEmailAddressWarning.getText();
		return duplicateEmailWarningText;
	}
	
	public String retrievePrivacyPolicyWarning() {
		String privacyPolicyWarningText = privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}
	
	public String retrieveFirstNameWarning() {
		String firstNameWarningText = firstNameWarning.getText();
		return firstNameWarningText;
	}
	
	public String retrieveLastNameWarning() {
		String lastNameWarningText = lastNameWarning.getText();
		return lastNameWarningText;
	}
	
	public String retrieveEmailAddressWarning() {
		String emailAddressWarningText = emailAddressWarning.getText();
		return emailAddressWarningText;
	}
	
	public String retrieveTelephoneNumberWarning() {
		String telephoneNumberWarningText = telephoneNumberWarning.getText();
		return telephoneNumberWarningText;
	}
	
	public String retrievePasswrodWarning() {
		String passwordWarningText = passwordWarning.getText();
		return passwordWarningText;
	}
	public boolean displayStatusOfWarningMessage(String expectedPrivacyPolicyWarningText,String expectedFirstNameWarningText,String expectedLastNameWarningText,String expectedEmailAddressWarningText, String expectedTelephoneNumberWarningText, String expectedPasswordWarningText) {
		boolean privacyPolicyWarningStatus= privacyPolicyWarning.getText().contains(expectedPrivacyPolicyWarningText);
		boolean firstNameWarningStatus=firstNameWarning.getText().contains(expectedFirstNameWarningText);
		boolean lastNameWarningStatus = lastNameWarning.getText().contains(expectedLastNameWarningText);
		boolean emailAddressWarningStatus=emailAddressWarning.getText().contains(expectedEmailAddressWarningText);
		boolean telephoneNumberWarningStatus=telephoneNumberWarning.getText().contains(expectedTelephoneNumberWarningText);
		boolean passwordWarningStatus=passwordWarning.getText().contains(expectedPasswordWarningText);
		
		return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailAddressWarningStatus && telephoneNumberWarningStatus && passwordWarningStatus;
		
	}


}
