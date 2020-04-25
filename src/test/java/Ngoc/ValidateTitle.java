package Ngoc;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LogInPage;
import resources.base;

public class ValidateTitle extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());

	@Test
	public void homePageNavigation() throws IOException, InterruptedException
	{
		driver = initializeDriver();
		log.info("initialize Driver");
		driver.get("http://qaclickacademy.com");
		log.info("Welcome to academy.com homepage");
		
		//one is inheritance
		// create a object to that class to evoke method
		
		LandingPage lp = new LandingPage(driver); 
		
		
		//compare text in the browser and actual value
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.error("Title is not match");
		
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	}
	
	
	
	
	
	

}
