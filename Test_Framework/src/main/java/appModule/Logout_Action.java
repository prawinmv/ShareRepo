package appModule;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver; 

import pageObjects.*; 
import utility.*;

 
 public class Logout_Action {

	 @SuppressWarnings("unused")
	private static final TimeUnit SECONDS = null;

	public static String accVerify(WebDriver driver)throws Exception{    
    	 
		 String AccountName = ShiftPage.txt_MyAccount(driver).getText();
		System.out.println(AccountName);
        Log.info("Account name identification performed");
        return AccountName;
              }
	
	public static void logOut(WebDriver driver)throws Exception{    
   	 
        ShiftPage.lnk_Logout(driver).click();
        Log.info("Logout img clicked");
        Thread.sleep(1000);
     }

     
}