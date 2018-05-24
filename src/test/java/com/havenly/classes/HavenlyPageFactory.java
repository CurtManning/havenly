package com.havenly.classes;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HavenlyPageFactory {
	
	WebDriver driver;
	static Logger log = Logger.getLogger(HavenlyPageFactory.class);

	@FindBy(xpath="//a[@id='start-project']")
	WebElement yourStyle;
	
	@FindBy(xpath="//img[contains(@src, 'Between')]")
	WebElement inBetween;
	
	@FindBy(xpath="//img[contains(@src, 'LessIs')]")
	WebElement lessIsMore;
	
	@FindBy(xpath="//img[contains(@src, 'BalancedIs')]")
	WebElement balancedIsBetter;
	
	@FindBy(xpath="//img[contains(@src, 'MoreIs')]")
	WebElement moreIsMore;
	
	@FindBy(xpath="//img[contains(@src, 'CleanA')]")
	WebElement cleanAndNeutral;
	
	@FindBy(xpath="//a[text()='Next']")
	WebElement next;
	
	@FindBy(xpath="//button//*[contains(text(), 'living room')]")
	WebElement livingRoom;
	
	@FindBy(xpath="//div/div/a[contains(text(), 'I don')]")
	WebElement noLike;
	
	@FindBy(xpath="//img[contains(@src, 'Transitional1')]")
	WebElement transitional;	
	
	@FindBy(xpath="//img[contains(@src, 'Scandinavian')]/following-sibling::div/img[contains(@src, 'Nursery/Scandinavian1')]")
	WebElement scandinavian;
	
	@FindBy(xpath="//button[contains(text(), 'finish')]")
	WebElement finished;

	@FindBy(id="UserName")
	WebElement fullName;
	
	@FindBy(id="user-email")
	WebElement userEmail;
	
	@FindBy(id="UserPassword")
	WebElement userPsswd;
	
	@FindBy(id="registerUser")
	WebElement registerUser;
	
	@FindBy(xpath="//*[@id='userRegistrationForm']/div[4]/div/span")
	WebElement message;
	
	By scand = By.xpath("//img[contains(@src, 'Scandinavian')]/following-sibling::div/img[contains(@src, 'Nursery/Scandinavian1')]");
	
	public HavenlyPageFactory(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log.info("HavenlyPageFactory");
	}
	
	public void clickFindYourStyle() {
		
		yourStyle.click();
		log.info("clickFindYourStyle");
	}
	
	public void clickInBetween() {
		
		inBetween.click();
		log.info("clickInBetween");
	}
	
	public void clickLessIsMore() {
		
		lessIsMore.click();
		log.info("clickLessIsMore");
	}
	
	public void clickCleanAndNeutral() {
		
		cleanAndNeutral.click();
		log.info("clickCleanAndNeutral");
	}
	
	public void clickLivingRoom() {
		
		livingRoom.click();
		log.info("clickLivingRoom");
	}
	
	public void clickNoLike() {
		
		noLike.click();
		log.info("clickNoLike");
	}
	
	public void clickTransitional() {
		
		transitional.click();
		log.info("clickTransitional");
	}
	
	public WebElement findNurseryScandinavian() throws Exception {
		
		Thread.sleep(30000); 
		WebElement element = driver.findElement(scand);
		log.info("findNurseryScandinavian");
		return element;
	}
	
	public void clickScandinavian() {

		scandinavian.click();
		log.info("clickScandinavian");
	}
	
	public void clickFinished() {
		
		finished.click();
		log.info("clickFinished");
	}
	
	public void setName(String name) {
		
		fullName.sendKeys(name);
		log.info("setName");
	}
	
	public void setUserEmail(String name) {
		
		userEmail.sendKeys(name);
		log.info("setUserEmail");
	}
	
	public void setPsswd(String name) {
		
		userPsswd.sendKeys(name);
		log.info("setPsswd");
	}
	
	public void clickRegisterUser(String name) {
		
		registerUser.click();
		log.info("clickRegisterUser");
	}
	
	public String getMessage() {
		
		String msg = message.getText();
		log.info("msg " + msg);
		return msg;
	}

}