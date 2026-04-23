package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

    @Test
    public void manageNewsTest() throws IOException {

    	String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
        String newstext = ExcelUtility.getStringData(0, 0, "news");

        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserName(username);
        loginpage.enterPassword(password);
        loginpage.clickOnSignIn();

        ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
        manageNewsPage.clickNewsMoreinfo();
        manageNewsPage.clickNewonManageNews();
        manageNewsPage.typeNewsonManageNews(newstext);
        System.out.println("Data: " + newstext);
        manageNewsPage.clickSaveonManageNews();
        boolean isAlertDisplayed = manageNewsPage.isNewsAlertDisplayed();
        Assert.assertTrue(isAlertDisplayed, "News alert is NOT displayed");
        manageNewsPage.clickSaveonManageNews();
    }
}