package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
    HomePage home;
    ManageNewsPage newspage;
    @Test(priority=1 ,description="Test case description" ,groups= {"regression"},retryAnalyzer=retry.Retry.class)
    public void manageNewsTest() throws IOException {

    	String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
        String newstext = ExcelUtility.getStringData(0, 0, "news");

        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserName(username).enterPassword(password);
        //loginpage.enterPassword(password);
        home=loginpage.clickOnSignIn();

       // ManageNewsPage manageNewsPage = new ManageNewsPage(driver);
       newspage= home.clickonManageNewsMoreinfo();
       newspage.clickNewonManageNews().typeNewsonManageNews(newstext).clickSaveonManageNews();
       // manageNewsPage.typeNewsonManageNews(newstext);
       // System.out.println("Data: " + newstext);
       // manageNewsPage.clickSaveonManageNews();
        boolean isAlertDisplayed = newspage.isNewsAlertDisplayed();
        Assert.assertTrue(isAlertDisplayed, "News alert is NOT displayed");
        newspage.clickSaveonManageNews();
    }
}