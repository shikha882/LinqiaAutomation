/**
 * 
 */
package com.linqia.automation;

/**
 * @author Shikha Gupta
 *
 */

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import java.io.File;

public class authentication {
	
	private String baseUrl;
	private BrowserType selectedBrowser;
	private FirefoxDriver driver;
	private String browser;
	private StringBuffer verificationErrors = new StringBuffer();
	public enum BrowserType { FIREFOX,CHROME,IE9,SAFARI,HTMLUNIT };

	@Parameters({ "browser" })
	@BeforeTest
	public void setUp() throws Exception {
		System.out.println("browser is " + browser);
		selectedBrowser = BrowserType.valueOf(browser);
		switch (selectedBrowser) {
			case FIREFOX:
				File profileDir = new File("C:\\Users\\Administrator\\workspace\\Linqia\\config\\firefox");
				FirefoxProfile profile = new FirefoxProfile(profileDir);
				driver = new FirefoxDriver(profile);
				baseUrl = "http://stage.linqia.com/";
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("Browser type is " + selectedBrowser);
			case CHROME:
				//TBD
				System.out.println("Browser type is " + selectedBrowser);
			case IE9:
				//TBD
				System.out.println("Browser type is " + selectedBrowser);
			case SAFARI:
				//TBD
				System.out.println("Browser type is " + selectedBrowser);
			case HTMLUNIT:
				//TBD
				System.out.println("Browser type is " + selectedBrowser);
			default:
				throw new RuntimeException("Browser type" + selectedBrowser + "is unsupported.");
	   }
    }

	@Test
	public void testExistingGroupLeader() throws Exception {
		driver.get(baseUrl + "/login.php");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("sneha");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("abracadabra");
		driver.findElement(By.cssSelector("button.actionButton.fleft")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
