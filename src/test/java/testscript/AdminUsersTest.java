package testscript;
	import utilities.FakerUtility;

import java.io.IOException;

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
	
			FakerUtility fakerUtil = new FakerUtility();
			String username1 = fakerUtil.generateUsername();
			String password1 = fakerUtil.generatePassword();

		
			
			
			AdminUsersPage adminusercreate = new AdminUsersPage(driver);

			adminusercreate.clickAdminUserMoreinfo();
			adminusercreate.clickNewonAdminUser();
			adminusercreate.enterUserNameforAdmin(username1);
			adminusercreate.enterPasswordforAdmin(password1);
			adminusercreate.selectUserTypeforAdmin("Admin");
		    adminusercreate.clickSaveonAdminUser();
			

		    
		}

	}

