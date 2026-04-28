package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
    HomePage home;
    ManageCategoryPage categorypage;
	@Test(description = "Test case description")
	public void manageCategoryTest() throws IOException {

		
		
		
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		//String category = ExcelUtility.getStringData(0, 1, "category");

		
		String typecategory = "orange";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		//loginpage.clickOnSignIn();
		home= loginpage.clickOnSignIn();

		//ManageCategoryPage categorytest = new ManageCategoryPage(driver);

		categorypage=home.clickManageCategoryMoreinfo();
		categorypage.clickEditonCategoryEdit().typeCategoryName(typecategory).fileUploadUsingSendKeys().clickOnUpdate();
		//categorypage.typeCategoryName(typecategory);
		//categorypage.fileUploadUsingSendKeys();
		//categorypage.clickOnUpdate();
		boolean isAlertDisplayed = categorypage.isCategoryUpdateAlertDisplayed();
		
	}
}
