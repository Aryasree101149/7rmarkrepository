package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	   // @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")WebElement managecontactmoreinfo;
	    @FindBy(xpath="//i[@class='fas fa-edit']")WebElement actiononcontact;
	    @FindBy(xpath="//input[@id='phone']")WebElement phonecontact;
	    @FindBy(xpath="//textarea[@placeholder='Enter Delivery Time']")WebElement deliverytime;
	    @FindBy(xpath="//button[@name='Update']")WebElement updatebutton;
	    @FindBy(xpath="//div[contains(@class,'alert-success')]")WebElement newsalert;

	    
/*public void clickContactMoreinfo() {
	
	managecontactmoreinfo.click();
	
}*/
public ManageContactPage clickActiononContact() {
	
	actiononcontact.click();
	return this;	
}
public ManageContactPage typePhoneContact(String typephno) {
	phonecontact.clear();
	
	phonecontact.sendKeys("phonenumber");
	return this;

}
public ManageContactPage typeDeliveryTime(String time) {
	deliverytime.clear();
	
	deliverytime.sendKeys(time);
	return this; 
}


public ManageContactPage clickUpdateonContactPage() {

    Waitutility wait = new Waitutility();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", updatebutton);
    wait.waitForElementToBeClickable(driver, updatebutton);

    try {
    	updatebutton.click();
    } catch (Exception e) {
        js.executeScript("arguments[0].click();", updatebutton);
    }
	return this;
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
