package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
public class LoginPage {
 @FindBy(xpath="//input[@name='username']")WebElement username;
 @FindBy(xpath="//input[@name='password']")WebElement password;
 @FindBy(xpath="//button[contains(text(),'Sign In')]")WebElement button;
 @FindBy(xpath="//div[contains(@class,'alert')]")WebElement alert;
 @FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
 
 
 public WebDriver driver;
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


public LoginPage enterUserName(String usernamevalue) {
	username.clear();   
	username.sendKeys(usernamevalue);
	return this;
	
}

public LoginPage enterPassword(String passwordvalue) {
	password.clear();
	password.sendKeys(passwordvalue);
	return this;
}

public HomePage clickOnSignIn() {
	//WaitUtility wait = new WaitUtility();
	//wait.waitForElementToBeClickable(driver, alert);
	button.click();
	return new HomePage(driver) ;
}

//public void login(String username, String password) {
   // enterUserName(username);
   // enterPassword(password);
  //  clickOnSignIn();
//}


public boolean isDashboardDisplayed() {
    return dashboard.isDisplayed();
}

public boolean isAlertMessageDisplayed() {
    return alert.isDisplayed();
}


}