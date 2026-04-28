package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageFooterTextPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {

    @Test(description="manage contactpage")
    public void managefootertexttest() throws IOException {

    	//String username = ExcelUtility.getStringData(1, 0,"loginpage");
		//String password = ExcelUtility.getStringData(1, 1,"loginpage");
    	//String address = ExcelUtility.getStringData(0, 1,"footer");
    	//String phonenumber = ExcelUtility.getStringData(1, 1,"footer");
    	//String email = ExcelUtility.getStringData(2, 1,"footer");

    	String username= "admin";
    	String password= "admin";
    	String address = "123 MG Road, Kochi, Kerala, 682016";
    	int phonenumber = 345453;
    	String email = "aryasree@gmail.com";
    	
        
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterUserName(username);
        loginpage.enterPassword(password);
        loginpage.clickOnSignIn();

        ManageFooterTextPage footertext = new ManageFooterTextPage(driver);
        footertext.clickfooterMoreinfo();
        footertext.clickEditonFooterText();	     
        footertext.updateAddress(address);
        footertext.updateEmail(email);
        footertext.updatePhone(phonenumber);
        footertext.clickUpdateonFooterTextPage();
        boolean isAlertDisplayed = footertext.isFooterUpdateAlertDisplayed();
        Assert.assertTrue(isAlertDisplayed, "Contact updated successfully");
    }
}






