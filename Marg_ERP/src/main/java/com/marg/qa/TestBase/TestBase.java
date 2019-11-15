package com.marg.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.marg.qa.util.TestUtil;
import com.marg.qa.util.Xls_Reader;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static Xls_Reader reader;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",
					"E:\\Marg\\NewMargWeb\\Marg_ERP\\src\\main\\java\\driver\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
}
	public static void login_Credentials(){
		prop = new Properties();
		driver.findElement(By.xpath("//*[@id='navbarNav']/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id='userid']")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("pass");
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();


	}
	public static void excel_path(){
		 reader = new Xls_Reader(
				"C:\\Users\\Admin.DESKTOP-P28CFV6\\Desktop\\ddf.xlsx");
	}
}
