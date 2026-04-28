package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Waitutility;

public class AdminUsersPage {

	 public WebDriver driver;

		public AdminUsersPage(WebDriver driver) {
			
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
		    @FindBy(xpath="//a[contains(@href,'list-admin')]")WebElement adminusermoreinfo;
		    @FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newonadminuser;
		    @FindBy(xpath="//input[@id='username']")WebElement usernameforadmin;
		    @FindBy(xpath="//input[@id='password']")WebElement passwordforadmin;
		    @FindBy(xpath="//select[@id='user_type']")WebElement  usertype;
		    @FindBy(xpath="//button[@name='Create']")WebElement  saveadminuser;
		    @FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]")WebElement  adminsuccessmessage;

		  
		


		    
		
		   
public void clickAdminUserMoreinfo() {

	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].click();", adminusermoreinfo);	    

}
public void clickNewonAdminUser() {
		
		newonadminuser.click();
		
}
public void enterUserNameforAdmin(String username) {
		
		usernameforadmin.sendKeys(username);

}
public void enterPasswordforAdmin(String password) {
		
		passwordforadmin.sendKeys(password);

	}

public void selectUserTypeforAdmin(String userTypeValue) {
    Select select = new Select(usertype);
    select.selectByVisibleText(userTypeValue);
}

	public void clickSaveonAdminUser() {
		
		saveadminuser.click();
	}

	public boolean isSuccessalertDisplayed() {
		try {
	        Waitutility wait = new Waitutility();

	        wait.waitForPresence(driver,
	            By.xpath("//div[contains(@class,'alert-success')]")
	        );

	        return true; // just confirm it appeared

	    } catch (Exception e) {
	        return false;
	    }
	}

}

