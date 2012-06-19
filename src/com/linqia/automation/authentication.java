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
	private FirefoxDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@Parameters({ "browser", "Url", "firefoxProfile"})
	@BeforeTest
	public void setUp(String browser, String Url, String firefoxProfile) throws Exception {
		System.out.println("browser is " + browser);
		System.out.println("Base URL is " + Url);
		System.out.println("Firefox profile directory is " + firefoxProfile);
		File profileDir = new File(firefoxProfile);
		FirefoxProfile profile = new FirefoxProfile(profileDir);
		driver = new FirefoxDriver(profile);
		baseUrl = Url;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	
	@Parameters({ "user", "pwd", "userType" })
	@Test
	public void testExistingGroupLeader(String user, String pwd, String userType) throws Exception {
		driver.get(baseUrl + "/login.php");
		System.out.println("Username is " + user);
		System.out.println("Password is " + pwd);
		System.out.println("User type is " + userType);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.cssSelector("button.actionButton.fleft")).click();
		String name = driver.findElement(By.cssSelector("p.userType")).getText();
		assertEquals(name, userType);
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Parameters({ "user", "pwd", "userType" })
	@Test
	public void testExistingBrandUser(String user, String pwd, String userType) throws Exception {
		driver.get(baseUrl + "/login.php");
		System.out.println("Username is " + user);
		System.out.println("Password is " + pwd);
		System.out.println("User type is " + userType);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.cssSelector("button.actionButton.fleft")).click();
		String name = driver.findElement(By.cssSelector("p.userType")).getText();
		assertEquals(name, userType);
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
