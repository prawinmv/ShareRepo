package pageObjects;
 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;

import utility.*;			


 public class ShiftPage {
	private static utility.RepositoryParser parser;

    private static WebElement element;

 public  static WebElement txt_MyAccount(WebDriver driver) throws Exception{
    	parser= new RepositoryParser("src/main/java/objectProperty/ShiftPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("Account")));
    	Log.info("My Account name element found");
     	return element;

    }
 
 public  static WebElement lnk_Logout(WebDriver driver) throws Exception{
	   	element = driver.findElement(parser.getbjectLocator(("Logout")));
 	Log.info("Log out element found");
  	return element;

 }

}