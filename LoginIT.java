package com.acxiom.cm.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import com.acxiom.cm.tests.TestClassBase;
import com.acxiom.cm.pages.HomePage;
import com.acxiom.cm.pages.LoginPage;

public class LoginIT extends TestClassBase {

	private final static Logger logger = LoggerFactory
			.getLogger(LoginIT.class);
    private final static String pageTitle = "Impact� User Login"; 


	@BeforeMethod
	public void setupTest(Method method) {
		logger.info("Begin test: " + method.getName());
		webDriver.get(this.getBase_url());
		webDriver.manage().deleteAllCookies();
		//this.getWait30().until(ExpectedConditions.titleIs(pageTitle));

	}
	

	
	@Test(description="Valid User Login")
	public void validLogin() throws Exception {
		LoginPage loginPage = new LoginPage(webDriver);
		HomePage homePage = loginPage.loginAs(userID, password);
		//getWait30().until(ExpectedConditions.titleIs(pageTitle));
		Assert.assertTrue(homePage.getPageActiveTopMenu().equals("Home"),
				"Valid Login Failed, Top Menu not match");
		Assert.assertTrue(homePage.getPageActiveSubMenu().equals("Shortcuts"),
				"Valid Login Failed, Sub Menu not match");
	}

	@Test(description="Bad User Login")
	public void badUserLogin() throws Exception {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.failLoginAs("baduser", password);
		Assert.assertTrue(loginPage.getErrorMessage().contains("We are unable to log you into Impact"),
				"Login attempt with bad user wasn't properly handled");
	}
	
	@Test(description="Bad Password Login")
	public void badPasswordLogin() throws Exception {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.failLoginAs(userID, "badpassword");
		Assert.assertTrue(loginPage.getErrorMessage().contains("We are unable to log you into Impact"),
				"Login attempt with bad password wasn't properly handled");
	}
	
	@Test(description="Null User Login")
	public void nullUserLogin() throws Exception {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.failLoginAs("", password);
		Assert.assertTrue(validateNullLogin(),
				"Login attempt with null user wasn't properly handled");
	}
	
	@Test(description="Null Password Login")
	public void nullPasswrodLogin() throws Exception {
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.failLoginAs(userID, "");
		Assert.assertTrue(validateNullLogin(),
				"Login attempt with null password wasn't properly handled");
	}


	
	
	//check if the java script alert display
	private boolean validateNullLogin() {
	    try 
	    { 
	    	wait.until(ExpectedConditions.alertIsPresent());
	    	System.out.println(webDriver.switchTo().alert().getText());
	    	webDriver.switchTo().alert().dismiss();
	        return true;
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    } 
		
	}

	@Override
	protected String getQAURL() {
		return props.getProperty("CM_QA_URL");
	}

	@Override
	protected String getDEVURL() {
		return props.getProperty("CM_DEV_URL");
	}

}
