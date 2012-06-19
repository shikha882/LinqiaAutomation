
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

public class campaign {
	
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
	
	@Parameters({ "user", "pwd", "campaignName", "keyword" })
	@Test
	public void testDraftCampaign(String user, String pwd, String campaignName, String keyword) throws Exception {
		driver.get(baseUrl + "/login.php");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.cssSelector("button.actionButton.fleft")).click();
		driver.findElement(By.linkText("Create campaign")).click();
		driver.findElement(By.name("search")).clear();
		driver.findElement(By.name("search")).sendKeys(keyword);
		driver.findElement(By.name("do-search")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Add to campaign')])[4]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Add to campaign')])[6]")).click();
		driver.findElement(By.name("next_step")).click();
		driver.findElement(By.id("brand")).clear();
		driver.findElement(By.id("brand")).sendKeys("Social Mom");
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(campaignName);
		driver.findElement(By.id("start_alt")).click();
		driver.findElement(By.linkText("19")).click();
		driver.findElement(By.id("duration-14")).click();
		driver.findElement(By.id("purpose-1")).click();
		driver.findElement(By.id("purpose-3")).click();
		driver.findElement(By.id("purpose-oth")).click();
		driver.findElement(By.id("purpose-2")).click();
		driver.findElement(By.id("purpose-4")).click();
		driver.findElement(By.name("purpose_other")).clear();
		driver.findElement(By.name("purpose_other")).sendKeys("publicity");
		driver.findElement(By.id("campaign_about")).clear();
		driver.findElement(By.id("campaign_about")).sendKeys("Social mom tend to be cost conscious, being 56% more likely to download coupons than the general public. They are also more likely to shop online for many products. Research shows that 86% of social mom shop online for cosmetics than the general public.");
		driver.findElement(By.cssSelector("#groups_benefit-element > div.placeholder")).click();
		driver.findElement(By.id("groups_benefit")).clear();
		driver.findElement(By.id("groups_benefit")).sendKeys("Website for downloading free coupons.");
		driver.findElement(By.id("sensitive_content_type-2")).click();
		driver.findElement(By.id("sensitive_content_type-4")).click();
		driver.findElement(By.id("sensitive_content_type-6")).click();
		driver.findElement(By.cssSelector("div.navigation.bottom > div.actions-step > div.steps-wrap > span.no-radius-next > input[name=\"next_step\"]")).click();
		driver.findElement(By.cssSelector("div.placeholder")).click();
		driver.findElement(By.id("content-ins")).clear();
		driver.findElement(By.id("content-ins")).sendKeys("Website for downloading coupons.");
		driver.findElement(By.linkText("Supporting text")).click();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Social mom and shopping");
		driver.findElement(By.id("text")).clear();
		driver.findElement(By.id("text")).sendKeys("Social moms shop online for cosmetics, hair accessories, nail paints and other home stuff.");
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.linkText("Links")).click();
		driver.findElement(By.xpath("(//input[@id='name'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@id='name'])[2]")).sendKeys("Social mom");
		driver.findElement(By.cssSelector("#link-element > div.placeholder")).click();
		driver.findElement(By.id("link_name")).clear();
		driver.findElement(By.id("link_name")).sendKeys("Online coupons for social moms");
		driver.findElement(By.cssSelector("#link-element > div.placeholder")).click();
		driver.findElement(By.id("link")).clear();
		driver.findElement(By.id("link")).sendKeys("socialmom.com");
		driver.findElement(By.xpath("(//input[@id='submit'])[2]")).click();
		driver.findElement(By.linkText("Videos")).click();
		driver.findElement(By.xpath("(//input[@id='name'])[4]")).clear();
		driver.findElement(By.xpath("(//input[@id='name'])[4]")).sendKeys("Social mom and");
		driver.findElement(By.xpath("(//input[@id='link_name'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@id='link_name'])[2]")).sendKeys("How social mom shop");
		driver.findElement(By.cssSelector("#content-video-form > dl.zend_form > #link-element > div.placeholder")).click();
		driver.findElement(By.xpath("(//input[@id='link'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@id='link'])[3]")).sendKeys("http://youtu.be/sNqaXt1F0RA");
		driver.findElement(By.xpath("(//input[@id='submit'])[3]")).click();
		//driver.findElement(By.linkText("NEXT STEP")).click();
		driver.findElement(By.xpath("//input[@class='next-step']")).click();
		driver.findElement(By.xpath("//input[@class='save-draft resetStyle']")).click();
		//driver.findElement(By.linkText("Save as draft")).click();
		driver.findElement(By.xpath("//*[@id='campaigns']/aside/nav/a[2]")).click();
		driver.findElement(By.linkText("Delete")).click();
		Alert alert = driver.switchTo().alert();
		String alertname = alert.getText();
		System.out.println("Alert name is " + alertname);
		alert.accept();
		// ERROR: Caught exception [ERROR: Unsupported command [getConfirmation]]
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
