package com.genericlib.demoblaze;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonUtils 
{
	
	
	public WebElement verifyProductInCart(String pn, WebDriver driver)
	{
		return driver.findElement(By.xpath("//td[.='"+pn+"']"));//Any added to cart i will check 	
	}
	
	//Common method deleting method upon the product name
	public WebElement deleteProduct(WebDriver driver,String pn) throws InterruptedException
	{
	
		//return driver.findElement(By.xpath("//td[.='"+pn+"']/following-sibling::td/a"));//concate the pn to xpath //td[text()='Nexus 6']/following-sibling::td/a
		return driver.findElement(By.xpath("//td[text()='Nexus 6']/following-sibling::td/a"));
	}
	
	//handle the alert
	
	public void acceptAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	public void dismissAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	
	public void waitTillElementClickable(WebDriver driver,WebElement e)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}

	//waiting alert to be present
	public void waitTillAlertToBeDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	//stale element referential exception
	public void resolveStaleElement(WebElement w) throws InterruptedException
	{
		for(int i=0; i<3; i++)
		try{
			Thread.sleep(2000);
			w.getText();
			break;
		   }
		catch(StaleElementReferenceException e)
		{
			//System.out.println(e);
		}
	}
	
	public String signUp(String un, String pwd)
	{
		return un;
	}
	
	public void mouseHover(WebDriver driver,WebElement e) 
	{
		Actions act= new Actions(driver);
		act.moveToElement(e).build().perform();
		
	}
 

}
