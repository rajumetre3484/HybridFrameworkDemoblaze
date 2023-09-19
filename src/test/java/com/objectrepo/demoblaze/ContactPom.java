package com.objectrepo.demoblaze;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class ContactPom 
{

	@FindBy(xpath ="//a[.='Contact']")
	private WebElement Contact;
	
	@FindBy(id="recipient-email")
	private WebElement ContactMail;
	
	@FindBy(id = "recipient-name")
    private WebElement ContactName;
	
	@FindBy(id = "message-text")
	private WebElement ContactMessage;
	
	@FindBy(xpath = "//button[.='Send message']")
	private WebElement ContactSendButton;
	
	
       //Getters
	public WebElement getContact() {
		return Contact;
	}

	public WebElement getContactMail() {
		return ContactMail;
	}

	public WebElement getContactName() {
		return ContactName;
	}

	public WebElement getContactMessage() {
		return ContactMessage;
	}

	public WebElement getContactSendButton() {
		return ContactSendButton;
	}
	
	
	

}
