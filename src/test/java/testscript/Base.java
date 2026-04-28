package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenShotUtility;

//import utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	public Properties properties;
	@Parameters("browser")
	@BeforeMethod(alwaysRun=true)
	
    public void browserInitinalisation(String browser) throws Exception {
		try {
			properties=new Properties();
			FileInputStream fileinputstream = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);
		}
		catch(Exception e){
			System.out.println(e);
		}
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			 driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			 driver = new EdgeDriver();
		}
		else {
			throw new Exception("Invalid Browser") ;

		}
	
	 driver = new ChromeDriver();  //browser launch
	  //driver.get("https://groceryapp.uniqassosiates.com/admin/login");  // url launch
	 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
	 driver.get(properties.getProperty("url"));
	 driver.manage().window().maximize();
 }
	 @AfterMethod(alwaysRun=true)
	public void browserQuit(ITestResult iTestResult) throws IOException //ITestresult-Interface
	 {
		if (iTestResult.getStatus() == ITestResult.FAILURE) //get status-method to get the status of the test execution
		{
			ScreenShotUtility scrShot = new ScreenShotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());//retrive the name of failed method
		}

	}
  
 //public void browserQuitandClose() {
	// driver.close();  //To close the current window
	// driver.quit();
// }
	

}
