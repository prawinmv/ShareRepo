/**
 * 
 */
/**
 * @author mvprawin
 *
 */
package jenkinGithub_project1;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {
	
 public static WebDriver driver;

@BeforeMethod
public static void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
    driver = new FirefoxDriver();
    System.out.println("FireFox is invoked successfully");
    driver.get("http://www.google.com");
    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	driver.manage().window().maximize();
    
}

@Test
public static void execute() throws Exception {
	System.out.println("In Progress");
	Thread.sleep(2000);
	driver.findElement(By.name("q")).sendKeys("testing");
	driver.findElement(By.name("btnG")).click();
}

@AfterMethod
public static void tearDown() throws Exception {
	System.out.println("End of Script");
	//driver.quit();
	
}
}

