package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement invalidProduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement noProductMessage;
	
	 
	
	public SearchPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayStatusOfHPValidProduct() {
		boolean displayStatusvalidproduct = validHPProduct.isDisplayed();
		return displayStatusvalidproduct;
	}
	
	public boolean displayStatusOfInvalidProduct() {
		boolean displayStatusInvalidProduct = invalidProduct.isDisplayed();
		return displayStatusInvalidProduct;
	}
	
	public String retrieveNoProductMessageText() {
		String noProductMessageText = noProductMessage.getText();
		return noProductMessageText;
	}
}
