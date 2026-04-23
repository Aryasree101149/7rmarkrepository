package testscript;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.Logoutpage;
public class LogoutTest extends Base {
	@Test
	 public void verifyLogoutSuccessfully()   {
		
		 String username = "admin";
	     String password = "admin";

		   LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUserName(username);
			loginpage.enterPassword(password);
			loginpage.clickOnSignIn();
	        
	       Logoutpage logoutpage = new Logoutpage(driver);
		   logoutpage.logout();
	        
	      
	    }
}
