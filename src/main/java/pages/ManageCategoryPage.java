package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waitutility;

public class ManageCategoryPage {

	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href=\'https://groceryapp.uniqassosiates.com/admin/list-category\']")
	WebElement managenewscategoryinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/category/edit?edit=3249&page_ad=1']")
	WebElement categoryedit;
	@FindBy(xpath = "//input[@name='category']")
	WebElement categoryname;
	@FindBy(xpath = "//li[contains(text(),'discount')]")
	WebElement discountclick;
	@FindBy(xpath = "//input[@type='file']")
	WebElement fileupload;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement update;
	@FindBy(xpath = " //div[@class='alert alert-success alert-dismissible']")
	WebElement updatesuccessalert;

	
	
	
	public void clickManageCategoryMoreinfo() {

		managenewscategoryinfo.click();

	}

	public void clickEditonCategoryEdit() {

		categoryedit.click();

	}

	public void typeCategoryName(String typecategory) {
		categoryname.clear();
		categoryname.sendKeys(typecategory);

	}

	public void selectDiscount() {

		
		
		Waitutility wait = new Waitutility();
	    wait.waitForElementToBeVisible(driver, discountclick);
	    Actions actions = new Actions(driver);
	    actions.moveToElement(discountclick).perform();
	    try {
	        Thread.sleep(500);
	    } catch (InterruptedException e) {}
	    actions.click(discountclick).perform();
	}

	public void fileUploadUsingSendKeys() {
	    fileupload.sendKeys("C:\\Users\\ARYASREE\\Pictures\\Screenshots\\image.png.png");
	}

	public void clickOnUpdate() {

	    Waitutility wait = new Waitutility();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", update);
	    wait.waitForElementToBeClickable(driver, update);

	    try {
	        update.click();
	    } catch (Exception e) {
	        js.executeScript("arguments[0].click();", update);
	    }
	}
	public boolean isCategoryUpdateAlertDisplayed() {
		try {
			Waitutility wait = new Waitutility();

			wait.waitForPresence(driver, By.xpath("//div[contains(@class,'alert-success')]"));

			return true; // just confirm it appeared

		} catch (Exception e) {
			return false;
		}
	}

}
