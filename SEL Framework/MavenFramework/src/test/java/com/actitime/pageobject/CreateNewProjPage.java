package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class CreateNewProjPage {

	@FindBy(name="customerId")
	private @Getter WebElement projcutomerDrpDwn;
	
	@FindBy (name="name")
	private @Getter WebElement ProjName;
	
	@FindBy(name="createProjectSubmit")
	private @Getter WebElement createProjectSubmitBtn;
	
	
	public CreateNewProjPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
}
