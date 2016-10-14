/**
 * 
 */
/**
 * @author mvprawin
 *
 */
package testcase;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;





import appModule.*;
import utility.*;

public class PageObjectModel  {

	

@BeforeClass
public void browserSetUp() throws Exception {
	System.out.println("Start of Script");
	    DOMConfigurator.configure("log4j.xml");
	    String browser = Constant.Browser;
	    Utility.openBrowser(browser);
	    Log.info("New driver instantiated");
	    
}
@Test(dataProvider="Data",dataProviderClass=Dataprovider.class)
public void moduleActions(String sUsername,String sPassword,String Account_Name) throws Exception{
	System.out.println("Execution is in progress");
	LandingPage_Action.clickLoginlnk(Utility.driver);
	LogInPage_Action.Execute(Utility.driver, sUsername, sPassword);
	Logout_Action.accVerify(Utility.driver);//.equalsIgnoreCase(Account_Name);
	Logout_Action.logOut(Utility.driver);

	
}	

@AfterClass
public void tearDown() {

System.out.println("End of Script");
}
}