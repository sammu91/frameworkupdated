package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public abstract class BasePage {

	@FindBy(xpath="//div[text()='Tasks']") // by diganata
	//@FindBy(xpath="//a[@class='content tasks_selected selected']//div[1]")
	private @Getter WebElement taskEle;
	
	@FindBy(id="logoutLink")
	private @Getter WebElement logoutLink;
	
	public BasePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
