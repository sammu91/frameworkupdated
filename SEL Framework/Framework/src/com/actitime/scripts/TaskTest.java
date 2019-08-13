package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.features.TaskFeature;
import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;

public class TaskTest extends BaseLib
{

	@Test(priority=1)
	public void createCustomer()
	{
		ExcelUtilities eu= new ExcelUtilities("./testdata/testdata.xlsx");
		String username = eu.readData("Sheet1", 3, 1);
		String password = eu.readData("Sheet1", 3, 2);
		String CustomerName = eu.readData("Sheet1", 3, 3);
		
		TaskFeature tf = new TaskFeature(driver);
		tf.createCustomer(username, password, CustomerName);
	}
	
	@Test(priority=4,dependsOnMethods={"createCustomer"})
	public void deleteCustomer()
	{
		ExcelUtilities eu= new ExcelUtilities("./testdata/testdata.xlsx");
		String username = eu.readData("Sheet1", 4, 1);
		String password = eu.readData("Sheet1", 4, 2);
		String CustomerName = eu.readData("Sheet1", 4, 3);
		
		TaskFeature tf = new TaskFeature(driver);
		tf.deleteCustomer(username, password, CustomerName);
	}
	
	@Test(priority=2)
	public void createProject()
	{
		ExcelUtilities eu= new ExcelUtilities("./testdata/testdata.xlsx");
		String username = eu.readData("Sheet1", 5, 1);
		String password = eu.readData("Sheet1", 5, 2);
		String CustomerName = eu.readData("Sheet1", 5, 3);
		String ProjectName = eu.readData("Sheet1", 5,4);
		
		TaskFeature tf = new TaskFeature(driver);
		tf.createProject(username, password, CustomerName,ProjectName);
		
	}
	
	@Test(priority=3)
	public void deleteProject()
	{
		ExcelUtilities eu= new ExcelUtilities("./testdata/testdata.xlsx");
		String username = eu.readData("Sheet1", 5, 1);
		String password = eu.readData("Sheet1", 5, 2);
		//String CustomerName = eu.readData("Sheet1", 5, 3);
		TaskFeature tf = new TaskFeature(driver);
		tf.deleteProject(username, password);
	}
}
