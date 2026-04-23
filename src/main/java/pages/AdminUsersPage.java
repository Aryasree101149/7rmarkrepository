package pages;

import org.openqa.selenium.By;
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
		    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement adminusermoreinfo;
		    @FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newonadminuser;
		    @FindBy(xpath="// //input[@id='username']")WebElement usernameforadmin;
		    @FindBy(xpath="//input[@id='password']")WebElement passwordforadmin;
		    @FindBy(xpath="//select[@id='user_type']")WebElement  usertype;
		    @FindBy(xpath="//button[@name='Create']")WebElement  saveadminuser;
		    @FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]")WebElement  adminsuccessmessage;

		  
		


		 
		
		    
	public void clickAdminUserMoreinfo() {
		
		adminusermoreinfo.click();
		
	}
	public void clickNewonAdminUser() {
		
		newonadminuser.click();
		
	}
	public void enterUserNameforAdmin(String typenewsvalue) {
		
		usernameforadmin.sendKeys(typenewsvalue);

	}
public void enterPasswordforAdmin(String typenewsvalue) {
		
		passwordforadmin.sendKeys(typenewsvalue);

	}
public void selectUserTypeforAdmin(String typenewsvalue) {
	Select select = new Select(usertype);
	select.selectByVisibleText("Admin");

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

