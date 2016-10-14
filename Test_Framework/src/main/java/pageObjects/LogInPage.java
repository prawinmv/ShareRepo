package pageObjects;
 
    import utility.*;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
 
 public class LogInPage {

static utility.RepositoryParser parser;
private static WebElement element;

public static WebElement txtbx_UserName(WebDriver driver) throws Exception{
	 parser= new RepositoryParser("src/main/java/objectProperty/LogInPage.properties");
      element = driver.findElement(parser.getbjectLocator(("sUsername")));
      Log.info("Username text box found");
      return element;

      }

  public static WebElement txtbx_Password(WebDriver driver) throws Exception{
	  element = driver.findElement(parser.getbjectLocator(("sPassword")));
      Log.info("Password text box found");
      return element;

      }

  public static WebElement btn_LogIn(WebDriver driver)throws Exception{
	  element= driver.findElement(parser.getbjectLocator(("Login")));
      Log.info("Submit button found");
      return element;

      }

}