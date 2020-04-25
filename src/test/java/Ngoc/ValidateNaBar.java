package Ngoc;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LogInPage;
import resources.base;

public class ValidateNaBar extends base{
	
	// adding log 
	//generate html report
	//screenshot on failure
	//Jenkin intergration 
	
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(p.getProperty("url"));
	}
	
	@Test
	public void homePageNavigation() throws IOException, InterruptedException
	{
		
		
		//one is inheritance
		// create a object to that class to evoke method
		
		LandingPage lp = new LandingPage(driver); 
		
		//Verify that navigation bar is displayed or not
		Assert.assertTrue(lp.getInterview().isDisplayed());
		//Assert.assertFalse(false);
		log.info("Interview course link is displayed");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	}
	
	
	
	
	

}
