package com.testscripts.demoblaze;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.demoblaze.Base;
import com.genericlib.demoblaze.EventList;
import com.objectrepo.demoblaze.ContactPom;

@Listeners(EventList.class)
public class Contact_Page extends Base
{
	
	@Test (dataProvider = "contactTest")               
	public void contactPageTest(String email, String name) throws InterruptedException, IOException
	{
		
		test=report.createTest("validate the contact details page");
		test.pass("logged into the app as "+fl.getDataFromproperties("username"));
		ContactPom Cont = PageFactory.initElements(driver, ContactPom.class);
		test.pass("Landed on the home page");
		Cont.getContact().click();
		test.pass("Clicked on the cantact");
		test.pass("landed on the cantact page");
		Cont.getContactMail().sendKeys(email);
		Cont.getContactName().sendKeys(name);
		Cont.getContactMessage().sendKeys("how are you");
		Cont.getContactSendButton().click();
		test.pass("clicked send the contact details button");
		cu.acceptAlert(driver);
		//Assert.assertTrue(false);//intentially failled
		test.pass("alert is to be handled");
		Reporter.log("Send the succesfully Contact details",true);
		test.pass("Successfully send the contact details");
		Thread.sleep(2000);
		
		
		
	}

}
