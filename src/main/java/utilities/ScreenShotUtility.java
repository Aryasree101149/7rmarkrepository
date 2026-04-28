package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		//(convert webdriver to screenshot)-selenium webdriver cannot takes screeshot directly,so we type cast it
		
		TakesScreenshot scrShot = (TakesScreenshot) driver; //interface used to take failed test case image=take screeshot

		//this takes the screenshot and stores it as a file for temporary
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//captures the screenshot
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//create date and time
		File f1 = new File(System.getProperty("user.dir") + "//outputScreenShot"); //screenshots stored under folder "outputscreenshot
		if (!f1.exists()) {
			f1.mkdirs(); //create a folder if it does not exists
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp 
				+ ".png";//decide final screenshot path
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); //copy screenshot to final location
	}

}
