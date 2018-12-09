package Linkedin.Linkedin;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class linkfirst extends base{

	
	public WebDriver driver;
	
	
	@BeforeTest
	public void prep() throws IOException
	{
	driver=init();
	driver.get(pi.getProperty("url"));
	}
	
	
	@Test
	public void logtest() throws IOException
	{

	factory fact = PageFactory.initElements(driver, factory.class);
	fact.log("nisha.imagines@gmail.com", "lullupullu");
	
	}
	
   @AfterTest 
	public void logout() throws IOException
	{
	 
		homefactory hg = PageFactory.initElements(driver, homefactory.class);
		hg.logout();
		
	}
	
	

}
