package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Logoutpage {
	 public WebDriver driver;

	public Logoutpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
		@FindBy(xpath="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement usericon;
	    @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logout;

	 

	public void logout() {
		usericon.click();
		logout.click();
	}

}
