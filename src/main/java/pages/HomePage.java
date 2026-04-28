package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")
	WebElement usericon;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logout;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement managenewsmoreinfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")
	WebElement footerTextMoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	WebElement managecontactmoreinfo;
	@FindBy(xpath = "//a[@href=\'https://groceryapp.uniqassosiates.com/admin/list-category\']")
	WebElement managenewscategoryinfo;
	
	public ManageNewsPage clickonManageNewsMoreinfo() {

		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);

	}

	public ManageFooterTextPage clickfooterMoreinfo() {

		footerTextMoreInfo.click();
		return new ManageFooterTextPage(driver);

	}

	public ManageContactPage clickContactMoreinfo() {

		managecontactmoreinfo.click();
		return  new ManageContactPage(driver);

	}
	
	public ManageCategoryPage clickManageCategoryMoreinfo() {

		managenewscategoryinfo.click();
		return new ManageCategoryPage(driver);

	}

	public void logout() {
		usericon.click();
		logout.click();
	}

}
