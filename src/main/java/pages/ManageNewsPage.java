package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waitutility;

public class ManageNewsPage {
	
	 public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement managenewsmoreinfo;
	    @FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newonmanagenews;
	    @FindBy(xpath="//textarea[@placeholder='Enter the news']")WebElement typenews;
	    @FindBy(xpath="//button[@class='btn btn-danger']")WebElement savebutton;
	    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement newsalert;

	    
public void clickNewsMoreinfo() {
	
	managenewsmoreinfo.click();
	
}
public void clickNewonManageNews() {
	
	newonmanagenews.click();
	
}
public void typeNewsonManageNews(String typenewsvalue) {
	
	typenews.sendKeys(typenewsvalue);

}
public void clickSaveonManageNews() {
	
	savebutton.click();
}

public boolean isNewsAlertDisplayed() {
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
