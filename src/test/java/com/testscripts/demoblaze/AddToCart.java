package com.testscripts.demoblaze;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.demoblaze.Base;
import com.genericlib.demoblaze.EventList;
import com.objectrepo.demoblaze.Homepage;

@Listeners(EventList.class)
public class AddToCart  extends Base
{
	
	@Test(groups = {"smoke"})
	public void addToCartTest() throws InterruptedException, IOException
	{
		test=report.createTest("validate product can be added to cart");
		test.pass("logged into the app as "+fl.getDataFromproperties("username"));
		Homepage hp=PageFactory.initElements(driver, Homepage.class);
		test.pass("landed on HomePage");
		Thread.sleep(2000);
		ProductNmae = hp.getNexus6().getText();
		hp.getNexus6().click();
		test.pass("Clicked on Nexus6 product");
		test.pass("Navigated to product details page");
		Thread.sleep(2000);
		hp.getAddToCart().click();
		test.pass("Clicked on Add to cart button");
		cu.waitTillAlertToBeDisplayed(driver);
		cu.acceptAlert(driver);
		test.pass("Handled the alert");
		hp.getCart().click();
		Assert.assertTrue(cu.verifyProductInCart(ProductNmae, driver).isDisplayed());
		Reporter.log("Added to the cart",true);
		test.pass("Verify the product in cart");
	}

}
