package utilities;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;   // ✅ declare driver

    // ✅ constructor
    public PageUtility(WebDriver driver) {
        this.driver = driver;
    }
	
public void selectByVisibleTextMethod(WebElement elementname,String visibletext) {
	Select select = new Select(elementname);
	select.selectByContainsVisibleText(visibletext);
}
public void selectByIndexMethod(WebElement elementname,String index) {
	Select select = new Select(elementname);
	select.selectByIndex(1);
}
public void selectByValue(WebElement elementname,String value) {
	Select select = new Select(elementname);
	select.selectByValue("India");
}

public void dragAndDrop(WebElement dragelement, WebElement dropelement) {
	 Actions actions = new Actions(driver);
	    actions.dragAndDrop(dragelement, dropelement).perform();
	    actions.contextClick();
	    actions.moveToElement(dropelement);
	    actions.doubleClick();
	
}
/*public void rightClick(WebElement element) {
	 Actions actions = new Actions(driver);
	    actions.contextClick();
	
}
public void doubleClick(WebElement element) {
	 Actions actions = new Actions(driver);
	    actions.doubleClick();
	
}
public void mouseOver(WebElement element) {
	 Actions actions = new Actions(driver);
	    actions.moveToElement(element);
	
}
*/
}
