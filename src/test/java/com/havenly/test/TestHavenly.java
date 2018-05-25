package com.havenly.test;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.JavascriptExecutor;
import com.havenly.classes.HavenlyPageFactory;

public class TestHavenly {
	
	private WebDriver driver;
	private JavascriptExecutor js;
	HavenlyPageFactory objPage;

	static Logger log = Logger.getLogger(TestHavenly.class);

	@BeforeClass
	public void beforeClass() {
		
		String baseDir = System.getProperty("user.dir");
		String geckoDriver = baseDir + "/" + "drivers/geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", geckoDriver);
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		objPage = new HavenlyPageFactory(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PropertyConfigurator.configure("log4j.properties");
		js.executeScript("window.location = 'https://havenly.com/'");
	}

	@Test
	public void test() throws Exception {

		objPage.clickFindYourStyle();
		objPage.clickInBetween();
		objPage.clickLessIsMore();
		objPage.clickCleanAndNeutral();
		objPage.clickNoLike();
		objPage.clickLivingRoom();
		
		WebElement element = objPage.findNurseryScandinavian();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		objPage.clickScandinavian();
		
		objPage.clickFinished();
		objPage.setName("Test Tester");
		objPage.setUserEmail("Test@tester.com");
		objPage.setPsswd("test");
		String msg = objPage.getMessage();
		Assert.assertTrue(msg.contains("* Password must have a mimimum of 6 characters."));
	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
}