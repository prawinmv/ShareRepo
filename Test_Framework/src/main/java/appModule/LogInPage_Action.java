package appModule;

import org.openqa.selenium.WebDriver; 
import pageObjects.*; 
import utility.*;

 
 public class LogInPage_Action {

	public static void Execute(WebDriver driver,String sUsername, String sPassword)throws Exception{    
    	
        
        LogInPage.txtbx_UserName(driver).sendKeys(sUsername);
        Log.info("Username entered in the Username text box");
        
		LogInPage.txtbx_Password(driver).sendKeys(sPassword);		
        Log.info("Password entered in the Password text box");
		
		Thread.sleep(1000);
        LogInPage.btn_LogIn(driver).click();
        Log.info("Login button clicked");
        
     }


     
}