package com.actitime.features;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.actitime.pageobject.ActiveProjCustPage;
import com.actitime.pageobject.CreateNewCustPage;
import com.actitime.pageobject.CreateNewProjPage;
import com.actitime.pageobject.EditCustInfoPage;
import com.actitime.pageobject.EditProjInfoPage;
import com.actitime.pageobject.EnterTimeTrackPage;
import com.actitime.pageobject.LoginPage;
import com.actitime.pageobject.OpenTaskPage;

public class TaskFeature {

	WebDriver driver;   // declaring 
	LoginPage lp;
	EnterTimeTrackPage ettp;
	OpenTaskPage otp ;
	ActiveProjCustPage apcp;
	CreateNewCustPage cncp;
	EditCustInfoPage ecip;
	CreateNewProjPage cnpp;
	EditProjInfoPage epip;
	
	public TaskFeature(WebDriver driver)     //initializing
	{
		this.driver=driver;
		lp=new LoginPage(driver);
		ettp =new EnterTimeTrackPage(driver); // have all common elemets as it extends base page
		otp = new OpenTaskPage(driver);
		apcp=new ActiveProjCustPage(driver);
		cncp=new CreateNewCustPage(driver);
		ecip=new EditCustInfoPage(driver);
		cnpp=new CreateNewProjPage(driver);
		epip=new EditProjInfoPage(driver);
	}
	
	public void createCustomer(String username, String password, String CustomerName) // arguments as per test data
	{
		lp.getUnTXBX().sendKeys(username);
		lp.getPwdTXBX().sendKeys(password);
		lp.getLoginBtn().click();
		ettp.getTaskEle().click();
		otp.getProjCutLink().click();	
		apcp.getCreateNewCustBTn().click();
		cncp.getCustomerTXtBX().sendKeys(CustomerName);
		cncp.getCreateCustomerSubmitBtn().click();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//String Expectedmsg1 = ("Customer "+'"'+CustomerName+'"'+ " has been successfully created.");
		// or by diganata sir
		String Expectedmsg =("Customer \""+CustomerName+"\" has been successfully created.");
		String actualmsg = apcp.getSucessmsgEle().getText();
		Assert.assertEquals(actualmsg, Expectedmsg);
		Reporter.log(Expectedmsg, true);
		
		apcp.getLogoutLink().click();
		
	}
	
	public void  deleteCustomer(String username, String password, String CustomerName )
	{
		lp.getUnTXBX().sendKeys(username);
		lp.getPwdTXBX().sendKeys(password);
		lp.getLoginBtn().click();
		ettp.getTaskEle().click();
		otp.getProjCutLink().click();
		
		Select sel = new Select(apcp.getCutomerDrpDwn());  // 1. select class for drop down (sending locator of dropdown as argument)
		sel.selectByVisibleText(CustomerName);
		apcp.getShowBtn().click();
		apcp.getCustomerNameLink().click();
		ecip.getDeleteThisCustBtn().click();
		ecip.getDeletConfirmBtn().click();
		
		// validation/ verification
		String expMsg="Customer has been successfully deleted.";
		String actMsg = apcp.getSucessmsgEle().getText(); // we not to create xpath for delete mesg and all msg class is same so we can use that msg again
		Assert.assertEquals(actMsg,expMsg);
		Reporter.log(expMsg,true);
		
		Select sel2=new Select (apcp.getCutomerDrpDwn()); //2.  creating select object again because page get refreshed and stale exception error message appear for cutom drop down geetter
		List<WebElement> allOptions = sel2.getOptions();
		
		for(int i=0; i < allOptions.size(); i++)
		{
			String actoptionText = allOptions.get(i).getText();
			Assert.assertNotEquals(actoptionText, CustomerName);
		}
		
		Reporter.log("Customer"+CustomerName+"is sucessfully deleted", true);
		
		apcp.getLogoutLink().click();
		
	}
	
	
	public void  createProject(String username, String password, String CustomerName, String ProjectName )
	{
		
		lp.getUnTXBX().sendKeys(username);
		lp.getPwdTXBX().sendKeys(password);
		lp.getLoginBtn().click();
		ettp.getTaskEle().click();
		otp.getProjCutLink().click();
		
		apcp.getCreateNewProjBtn().click();
		Select sel= new Select(cnpp.getProjcutomerDrpDwn());
		sel.selectByVisibleText(CustomerName);
		cnpp.getProjName().sendKeys(ProjectName);
		cnpp.getCreateProjectSubmitBtn().click();
		
		String Expectedmsg =("Project "+ '"'+ProjectName+'"' +" has been successfully created.");
		String actualmsg = apcp.getSucessmsgEle().getText();
		Assert.assertEquals(actualmsg, Expectedmsg);
		Reporter.log(Expectedmsg, true);
		apcp.getLogoutLink().click();
				
	}
	
	
	public void  deleteProject(String username, String password)
	{
		
		lp.getUnTXBX().sendKeys(username);
		lp.getPwdTXBX().sendKeys(password);
		lp.getLoginBtn().click();
		ettp.getTaskEle().click();
		otp.getProjCutLink().click();
	
		apcp.getProjectNameLink().click();
		epip.getDeleteThisProjBtn().click();
		epip.getDeletprojConfirmBtn().click();
		
		String Expectedmsg=("Project has been successfully deleted.");
		String actualmsg = apcp.getSucessmsgEle().getText();
		Assert.assertEquals(actualmsg, Expectedmsg);
		Reporter.log(Expectedmsg, true);
		apcp.getLogoutLink().click();
		
	}
	
	
	
	
	
	
}
