package testscript;

	import java.io.IOException;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import pages.LoginPage;
import pages.ManageContactPage;
import pages.ManageNewsPage;
	import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	
	    @Test(description="manage contactpage")
	    public void manageNewsTest() throws IOException {

	    	//String username = ExcelUtility.getStringData(1, 0,"loginpage");
			//String password = ExcelUtility.getStringData(1, 1,"loginpage");
	       // String typephno = ExcelUtility.getStringData(1,0,"contact");
	       // String time =     ExcelUtility.getStringData(1,1,"contact");

	    	String username= "admin";
	    	String password= "admin";
	    	int phonenumber = 345453;
	    	String time = "03:00 PM";
            
	        LoginPage loginpage = new LoginPage(driver);
	        loginpage.enterUserName(username);
	        loginpage.enterPassword(password);
	        loginpage.clickOnSignIn();

	        ManageContactPage contactpage = new ManageContactPage(driver);
	        contactpage.clickContactMoreinfo();
	        contactpage.clickActiononContact();	     
			contactpage.typePhoneContact(phonenumber);
	        System.out.println("Data: " + phonenumber);
	        contactpage.typeDeliveryTime(time);
	        contactpage.clickUpdateonContactPage();
	        boolean isAlertDisplayed = contactpage.isUpdateAlertDisplayed();
	        Assert.assertTrue(isAlertDisplayed, "Contact updated successfully");
	    }
	}

