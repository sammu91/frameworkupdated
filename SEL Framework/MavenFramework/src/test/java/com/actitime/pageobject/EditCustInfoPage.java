package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class EditCustInfoPage {

	@FindBy (css="input[value='Delete This Customer']")
	private @Getter WebElement deleteThisCustBtn;
	
	@FindBy (id="deleteButton")
	private @Getter WebElement deletConfirmBtn;
	
	
	
	public EditCustInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
