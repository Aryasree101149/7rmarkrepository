package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Waitutility;

public class ManageFooterTextPage {

	public WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	WebElement footerTextMoreInfo;
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	WebElement actiononfootertext;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement updateaddress;
	@FindBy(xpath = "//input[@name='email']")
	WebElement updateemail;
	@FindBy(xpath = "//input[@name='phone']")
	WebElement updatephone;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updatefooter;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement footerupdatealert;

	/*public void clickfooterMoreinfo() {

		footerTextMoreInfo.click();

	}*/

	public void clickEditonFooterText() {

		actiononfootertext.click();
	}

	public ManageFooterTextPage updateAddress(String address) {
		updateaddress.clear();

		updateaddress.sendKeys("address");
		return this;

	}

	public ManageFooterTextPage updateEmail(String email) {
		updateemail.clear();

		updateemail.sendKeys("email");
		return this;
	}

	public ManageFooterTextPage updatePhone(int phonenumber) {
		updatephone.clear();

		updatephone.sendKeys("phonenumber");
		return this;
	}

	public ManageFooterTextPage clickUpdateonFooterTextPage() {

		Waitutility wait = new Waitutility();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", updatefooter);
		wait.waitForElementToBeClickable(driver, updatefooter);

		try {
			updatefooter.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", updatefooter);
		}
		return this;
	}

	public boolean isFooterUpdateAlertDisplayed() {
		try {
			Waitutility wait = new Waitutility();

			wait.waitForPresence(driver, By.xpath("//div[@class='alert alert-success alert-dismissible']"));

			return true; // just confirm it appeared

		} catch (Exception e) {
			return false;
		}
	}

}
