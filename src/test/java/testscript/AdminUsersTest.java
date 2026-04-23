package testscript;
	import java.io.IOException;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import pages.LoginPage;
	import pages.AdminUsersPage;
	import utilities.ExcelUtility;

	 public class AdminUsersTest extends Base {
		@Test
		public void adminuser() throws IOException {
			
			String username = ExcelUtility.getStringData(1, 0, "loginpage");
			String password = ExcelUtility.getStringData(1, 1, "loginpage");


			   LoginPage loginpage = new LoginPage(driver);
				loginpage.enterUserName(username);
				loginpage.enterPassword(password);
				loginpage.clickOnSignIn();
		       

				AdminUsersPage adminusercreate = new AdminUsersPage(driver);
		        String news = ExcelUtility.getStringData(0, 0, "news");
		        adminusercreate.clickAdminUserMoreinfo();
		        adminusercreate.clickNewonAdminUser();
		        adminusercreate.enterUserNameforAdmin(username);
		        adminusercreate.enterPasswordforAdmin(password);
		        adminusercreate.clickSaveonAdminUser();
		        adminusercreate.isSuccessalertDisplayed();
		        boolean newsalert = adminusercreate.isSuccessalertDisplayed();
		        

		    
		}

	}

