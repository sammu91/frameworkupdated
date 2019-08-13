package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class ActiveProjCustPage extends BasePage   // because we are verifying this page and logout available here
{
	@FindBy(css="input[value='Create New Customer'")
	private @Getter WebElement CreateNewCustBTn;
	
	@FindBy (className="successmsg")
	private @Getter WebElement SucessmsgEle;
	
	@FindBy(name="selectedCustomer")
	private @Getter WebElement cutomerDrpDwn;
	
	@FindBy(css="input[value*='Show']")
	private @Getter WebElement ShowBtn;
	
	@FindBy (xpath="//td[starts-with(@id,'customerNameCell')]//descendant::a[contains(@href,'customer')]")
	private @Getter WebElement customerNameLink;  
	// in above xpath td id has number that changes so we skip that no.in id 
	//we can use index also but in case of duplicate name it will not work
	// if i dont use show from drop down and evaluate above xpath we will gate node eaqual to no. of cutomer
	
	
	@FindBy(css="input[value='Create New Project']")
	private @Getter WebElement CreateNewProjBtn;
	
	
	
	@FindBy(xpath="//td[starts-with(@id,'projectNameCell')]//descendant::a[contains(@href,'projects')]")
	private @Getter WebElement projectNameLink;
	
	
	
	
	public ActiveProjCustPage(WebDriver driver)
	{
		super (driver);                      // calling base page constructor
		PageFactory.initElements(driver, this);
	}
}
