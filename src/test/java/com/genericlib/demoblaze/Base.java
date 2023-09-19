package com.genericlib.demoblaze;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;
import com.objectrepo.demoblaze.Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Base 
{                                   // make it non static when we execute parallel execution like to launch diffrent browser to execute the test scripts.
	public static WebDriver driver;   // get other class webdriver we make static or To execute all test scripts in single browser and multple class in single browser (group or batch execution).
	public FileLib fl=new FileLib();
	public CommonUtils cu=new CommonUtils();
    public static String ProductNmae;
    public static ExtentReports report;
    public static ExtentSparkReporter spark;
    public static ExtentTest test;
    
    

	@BeforeTest (groups = {"smoke","regression"}) //@BeforeSuite 
	public void configBS() throws IOException, InterruptedException  // public void configBS(String bn)  -- this is bcs parallel execution
	{
		String browserName = fl.getDataFromproperties("browser");
		report=new ExtentReports();
		spark=new ExtentSparkReporter("test-output/ExtentReport.html");
		report.attachReporter(spark);
		WebDriverManager.chromedriver().setup();
		if(browserName.equals("chrome")) //fl.getDataFromproperties("browser").equals("chrome") it was remove because while doing the parallel execution
        {
			WebDriverManager.chromedriver().setup();
	          driver = new ChromeDriver();
	        
        }
		
		if(browserName.equals("edge"))//if(bn.equals("edge"))
        {
			WebDriverManager.edgedriver().setup();
	          driver = new EdgeDriver();
	         
         }
		if(browserName.equals("firefox"))
        {
			WebDriverManager.firefoxdriver().setup();
	          driver = new FirefoxDriver();
	         
         }
		
		driver.get(fl.getDataFromproperties("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Reporter.log("Logged in to the browser", true);
		Thread.sleep(5000);
	}
	
	@DataProvider
	public Object[][] contactTest() throws Throwable
	{
		return fl.getDataFromExcel("Sheet1");//"TestData/test.xlsx", "Sheet1"
	}
	@BeforeMethod(groups = {"smoke","regression"})
	public void configBM() throws IOException, InterruptedException
	{
		
		driver.findElement(By.linkText("Log in")).click();//id("login2") driver.findElement(By.id("login2")).click();
	   cu.resolveStaleElement(driver.findElement(By.id("login2")));
		driver.findElement(By.id("loginusername")).sendKeys(fl.getDataFromproperties("username"));
		Thread.sleep(5000);
		driver.findElement(By.id("loginpassword")).sendKeys(fl.getDataFromproperties("password"));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		cu.resolveStaleElement(driver.findElement(By.id("nameofuser")));
		
		//cu.waitTillElementClickable(driver, driver.findElement(By.id("nameofuser")));//wait statment bcase illegalargemnt ecption
		System.out.println(driver.findElement(By.id("nameofuser")).getText());
		Assert.assertTrue(driver.findElement(By.id("nameofuser")).getText().contains(fl.getDataFromproperties("username")));
		Reporter.log("Logged in to the appa", true);
	}
	
	@AfterMethod (groups = {"smoke","regression"})
	public void configAM()
	{
		driver.findElement(By.id("logout2")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Log in")).isDisplayed()); //validation for logout seeing login is display
		Reporter.log("logged out from the app",true);
		test.pass("Logged out from the app");
	}
	
	@AfterTest  (groups = {"smoke","regression"}) //@AfterSuite
	public void confiAS()
	{
		driver.quit();
		Reporter.log("Closed the browser", true);
		test.pass("clossed the browser");
		report.flush();//all statment inserted in the exent report
	}
	
	

}
