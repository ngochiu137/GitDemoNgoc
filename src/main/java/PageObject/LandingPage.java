package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	By login = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By interview = By.cssSelector(".nav.navbar-nav.navbar-right li:nth-child(4)>a");
	
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By signup = By.xpath("//div[@class='tools']/li[3]/a[1]");

	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement getSignUp()
	{
		return driver.findElement(signup);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getInterview()
	{
		return driver.findElement(interview);
	}
	
	

}
