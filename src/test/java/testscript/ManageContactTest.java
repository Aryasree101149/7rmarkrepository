package testscript;

	import java.io.IOException;

	import org.testng.Assert;
	import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageFooterTextPage;
import pages.ManageNewsPage;
	import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageContactTest extends Base {
	    HomePage home;
	    ManageContactPage managepage;
	    @Test(description="manage contactpage")
	    public void manageNewsTest() throws IOException {

	    	//String username = ExcelUtility.getStringData(1, 0,"loginpage");
			//String password = ExcelUtility.getStringData(1, 1,"loginpage");
	       // String typephno = ExcelUtility.getStringData(1,0,"contact");
	       // String time =     ExcelUtility.getStringData(1,1,"contact");

	    	FakerUtility faker = new FakerUtility();

	        String phonenumber = faker.generatePhoneNumber();

	    	String username= "admin";
	    	String password= "admin";
	    	//int phonenumber = 345453;
	    	String time = "03:00 PM";
            
	        LoginPage loginpage = new LoginPage(driver);
	        loginpage.enterUserName(username);
	        loginpage.enterPassword(password);
	       // loginpage.clickOnSignIn();
	        home=loginpage.clickOnSignIn();

	      //  ManageContactPage contactpage = new ManageContactPage(driver);
	        managepage=home.clickContactMoreinfo();
	        managepage.clickActiononContact().typePhoneContact(phonenumber).typeDeliveryTime(time).clickUpdateonContactPage();	     
	       // managepage.typePhoneContact(phonenumber);
	       // System.out.println("Data: " + phonenumber);
	        //managepage.typeDeliveryTime(time);
	     //   managepage.clickUpdateonContactPage();
	        boolean isAlertDisplayed = managepage.isUpdateAlertDisplayed();
	        Assert.assertTrue(isAlertDisplayed, "Contact updated successfully");
	    }
	}

