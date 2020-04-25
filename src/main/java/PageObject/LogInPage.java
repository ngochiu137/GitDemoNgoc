package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	
	public WebDriver driver;
	
	public LogInPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	By email = By.cssSelector("#user_email");
	
	By pwd = By.xpath("//input[@type='password']");
	
	By login = By.xpath("//input[@type='submit']");
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(pwd);
	}
	
	public WebElement getLogIn()
	{
		return driver.findElement(login);
	}
	
	
	public WebElement getLogIn2()
	{
		System.out.println("fake log in. please ignore");
		return driver.findElement(login);
	}
	

}
