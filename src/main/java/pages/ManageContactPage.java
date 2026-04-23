package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waitutility;

public class ManageContactPage {
	
	 public WebDriver driver;

	public ManageContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")WebElement managecontactmoreinfo;
	    @FindBy(xpath="//i[@class='fas fa-edit']")WebElement actiononcontact;
	    @FindBy(xpath="//input[@id='phone']")WebElement phonecontact;
	    @FindBy(xpath="//textarea[@placeholder='Enter Delivery Time']")WebElement deliverytime;
	    @FindBy(xpath="//button[@name='Update']")WebElement updatebutton;
	    @FindBy(xpath="//div[contains(@class,'alert-success')]")WebElement newsalert;

	    
public void clickContactMoreinfo() {
	
	managecontactmoreinfo.click();
	
}
public void clickActiononContact() {
	
	actiononcontact.click();	
}
public void typePhoneContact(String typenewsvalue) {
	phonecontact.clear();
	
	phonecontact.sendKeys("34439857847");

}
public void typeDeliveryTime(String typenewsvalue) {
	deliverytime.clear();
	
	deliverytime.sendKeys("3PM");

}


public void clickUpdateonContactPage() {
	
	updatebutton.click();
}

public boolean isUpdateAlertDisplayed() {
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
