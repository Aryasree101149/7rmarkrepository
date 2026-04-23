package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	// @BeforeMethod
	// public void refreshPage() {
	// driver.navigate().refresh();
	// }

	@Test
	// ( groups= {"regression"},retryAnalyzer=retry.Retry.class)
	public void verifyLoginSuccessfullyWithValidUsernameAndValidPassword() throws IOException {

		// String username = "admin";
		// String password = "admin";
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignIn();
		boolean homepage = loginpage.isDashboardDisplayed();
		Assert.assertTrue(homepage);

	}

	@Test
	public void verifyLoginFailsWithValidUsernameAndInvalidPassword() throws IOException {

		// String username = "admin";
		// String password = "admin#123";
		String username = ExcelUtility.getStringData(2, 0, "loginpage");
		String password = ExcelUtility.getStringData(2, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		//loginpage.login(username, password);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignIn();
		boolean message = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(message);
	}

	@Test
	public void verifyLoginFailsWithInvalidUsernameAndValidPassword() throws IOException {

		// String username = "admin#";
		// String password = "admin";
		String username = ExcelUtility.getStringData(3, 0, "loginpage");
		String password = ExcelUtility.getStringData(3, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignIn();
		//loginpage.login(username, password);
		boolean message = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(message);

	}

	@Test
	public void verifyLoginFailsWithInvalidUsernameAndInvalidPassword() throws IOException {

		// String username = "admin#";
		// String password = "admin#";
		String username = ExcelUtility.getStringData(4, 0, "loginpage");
		String password = ExcelUtility.getStringData(4, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickOnSignIn();
		//loginpage.login(username, password);
		boolean message = loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(message);

	}
}