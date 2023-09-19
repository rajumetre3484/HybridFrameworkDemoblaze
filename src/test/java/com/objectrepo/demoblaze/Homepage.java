package com.objectrepo.demoblaze;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage 
{
	@FindBy(linkText ="Log in")              //(id="login2")
	private WebElement Login;
	
	@FindBy(id="loginusername")
	private WebElement LoginUsername;
	
	@FindBy(id="loginpassword")
	private WebElement Loginpassword;
	
	@FindBy(xpath ="//button[text()='Log in']")
	private WebElement LoginLoginButton;
	
	@FindBy(id="nameofuser")
	private WebElement NameofUser;
	
	
	@FindBy(xpath = "//a[.='Nexus 6']")
	private WebElement Nexus6;
	
	@FindBy(xpath ="//a[.='Add to cart']")////a[text()="Add to cart"]
	private WebElement AddToCart;
	
	@FindBy(id="cartur")
	private WebElement Cart;
	
	@FindBy(id="logout2")
	private WebElement Logout;
	
	
	//getters
	public WebElement getLogin() {
		return Login;
	}

	public WebElement getLoginUsername() {
		return LoginUsername;
	}

	public WebElement getLoginpassword() {
		return Loginpassword;
	}

	public WebElement getLoginLoginButton() {
		return LoginLoginButton;
	}
	
	public WebElement getNameofUser() {
		return NameofUser;
	}
	
	public WebElement getLogout() {
		return Logout;
	}
	
	public WebElement getNexus6() {
		return Nexus6;
	}

	public WebElement getAddToCart() {
		return AddToCart;
	}

	public WebElement getCart() {
		return Cart;
	}
	
	
	

}
