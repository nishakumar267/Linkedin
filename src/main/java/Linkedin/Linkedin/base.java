package Linkedin.Linkedin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public static Properties pi;
	public static WebDriver driver;

	public static WebDriver init() throws IOException
	{
	    pi =new Properties ();	
	FileInputStream fz = new FileInputStream ("/Users/nisha/Documents/workspace/EPAS/src/main/java/linkedin/global.properties");
	  pi.load(fz);
	  String s= pi.getProperty("browser");
	  if(s.contains("firefox"))
	  {
		   driver= new FirefoxDriver();
	  }
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  return driver;
	 
	}

	public void screenprint()
	{
	Random is= new Random();
	int val = is.nextInt(40)+1;

	System.out.println(val);
	File scFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
	try {
		FileUtils.copyFile(scFile, new File("\\Users\\nisha\\Downloads\\"+val+"dummy.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
