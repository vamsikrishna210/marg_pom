package com.marg.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.marg.qa.TestBase.TestBase;

public class CompanyPage extends TestBase{
	
	public String	validateCompanyPageTitle(){
			return driver.getTitle();
		}
	
	//Excel Code
	String user = 			reader.getCellData("Sheet1", "user", 2);
	String pass = 			reader.getCellData("Sheet1", "password", 2);
	String Companyname = 	reader.getCellData("Sheet1", "company name", 2);
	String Address1 = 		reader.getCellData("Sheet1", "Address1", 2);
	String Address2 = 		reader.getCellData("Sheet1", "Addrees2", 2);
	String Address3 = 		reader.getCellData("Sheet1", "Addree3", 2);
	String state=			reader.getCellData("Sheet1", "state", 2);
	String pincode=			reader.getCellData("Sheet1", "pincode", 2);
	String branchCode = 	reader.getCellData("Sheet1", "branch code", 2);
	String FynYear = 		reader.getCellData("Sheet1", "FinancialYear", 2);	
	String phone =			reader.getCellData("Sheet1", "phone", 2);
	String gst1 =			reader.getCellData("Sheet1", "GST", 2);
	String gst2 =			reader.getCellData("Sheet1", "GST", 3);
	String trade01 =		reader.getCellData("Sheet1", "Trade LIC", 2);
	String trade02 =		reader.getCellData("Sheet1", "Trade LIC", 3);
	String workingstyle=	reader.getCellData("Sheet1", "working style", 2);
	
	
	
	//pageFactory
	@FindBy(xpath = "//button[@id='btn-New']")
	WebElement new_button;
	
	@FindBy(xpath = "//input[@id='txtcompname']")
	WebElement Company_name;
	
	public CompanyPage() {
		// TODO Auto-generated constructor stub
		new_button.click();
		Company_name.sendKeys(Companyname);
	}
}
