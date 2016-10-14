package pageObjects;
 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;

import utility.*;			


 public class LandingPage {
	private static utility.RepositoryParser parser;

    private static WebElement element;

 public  static WebElement lnk_LogIn(WebDriver driver) throws Exception{
    	parser= new RepositoryParser("src/main/java/objectProperty/LandingPage.properties");
	   	element = driver.findElement(parser.getbjectLocator(("Link")));
    	Log.info("Log In link element found");
     	return element;

    }

}