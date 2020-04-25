package resources;

import  org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class base {
	
	//1500 test case
	public Properties p;
	public static WebDriver driver;// public để class homepage có thể kế thừa driver
	public WebDriver initializeDriver() throws IOException {
		p = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\T470\\RealProject\\src\\main\\java\\resources\\inputData.properties");
		p.load(fis);
		//mvn test -Dbrowser=chrome
		String browserName = System.getProperty("browser");
		
		
		//String browserName = p.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			//execute chrome
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\T470\\Desktop\\java\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("firefox"))
		{
			//execute firefox
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\T470\\Desktop\\java\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			//execute IE
			System.setProperty("webdriver.IE.driver", "C:\\Users\\T470\\Desktop\\java\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void screenshot(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\T470\\Desktop\\java\\screenshot\\"+result+"error.png"));
	}
}
