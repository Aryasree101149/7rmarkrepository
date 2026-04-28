package testscript;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.HomePage;
public class HomeTest extends Base {
	@Test
	 public void verifyLogoutSuccessfully()   {
		
		 String username = "admin";
	     String password = "admin";

		   LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUserName(username);
			loginpage.enterPassword(password);
			loginpage.clickOnSignIn();
	        
	       HomePage logoutpage = new HomePage(driver);
		   logoutpage.logout();
	        
	      
	    }
}
