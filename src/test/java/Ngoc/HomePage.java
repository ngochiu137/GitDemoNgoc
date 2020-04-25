package Ngoc;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LogInPage;
import resources.base;

public class HomePage extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
	}

	@Test(dataProvider="getData")
	public void homePageNavigation(String username,String password,String text) throws IOException, InterruptedException
	{
		
		driver.get("http://qaclickacademy.com");
		
		log.info("go to home page");
		
		//one is inheritance
		// create a object to that class to evoke method
		
		LandingPage lp = new LandingPage(driver); 
		lp.getLogin().click();
		//lp.getSignUp().click();
		log.info("Click log in button");
		
		LogInPage lip = new LogInPage(driver);
		
		lip.getEmail().sendKeys(username);
		log.info("enter username");
		lip.getPassword().sendKeys(password);
		log.info("enter password");
		System.out.println(text);
		lip.getLogIn().click();
		log.error("log in failed");
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data type test should run
		// Column stands for how many values per each test
		
		//Array size is 4
		//array start from 0,1,2,3
		Object[][] data = new Object[2][3]; // array size is 2 2
		//0th row
		data[0][0] = "ngochiu@gmail.com";
		data[0][1] = "12345cogN";
		data[0][2] = "restricted user";
		
		//1st row
		data[1][0] = "hieu@gmail.com";
		data[1][1] = "12345Hieu";
		data[1][2] = " Non restricted user";
		
		
		return data;
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	}
	
	
	

}
