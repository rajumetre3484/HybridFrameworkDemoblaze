package com.testscripts.demoblaze;

import java.util.NoSuchElementException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.genericlib.demoblaze.Base;
import com.objectrepo.demoblaze.Homepage;

public class DeleteProductFromCart extends Base 
{
	@Test
	public void DeleteProductFromCartTest() throws InterruptedException
	{
		Homepage hp=PageFactory.initElements(driver, Homepage.class);
		hp.getCart().click();
		Thread.sleep(5000);
		cu.deleteProduct(driver, ProductNmae).click();
		Thread.sleep(2000);
		//Assert.assertFalse(cu.verifyProductInCart(ProductNmae, driver).isDisplayed());
		try
		{
			cu.verifyProductInCart(ProductNmae, driver);
			Assert.assertTrue(false, "product has not been deleted - Test failed");
		}
		catch(NoSuchElementException n) //catch(Exception e)
		{
			Reporter.log("deleted "+ProductNmae+" from cart");
		}
		
		
	}

}
