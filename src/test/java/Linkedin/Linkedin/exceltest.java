package Linkedin.Linkedin;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class exceltest extends base {
	private static Logger log=LogManager.getLogger(exceltest.class.getName());
	//public static final ExtentReports report = ExtentReports.get(exceltest.class);
	public WebDriver driver;
	
	@DataProvider
	public static Object[][] fetchdata() throws IOException
	{
		Object[][] arr = new Object[3][2];
		FileInputStream fs= new FileInputStream("/Users/nisha/Downloads/Practise.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(fs);
		XSSFSheet sheet = book.getSheet("login");
		Iterator<Row> rw= sheet.iterator();
		int i=0,j=0;
		while (rw.hasNext())
		{
			Row r= rw.next();
			arr[i][0]= r.getCell(0).getStringCellValue();
			arr[i][1]=r.getCell(1).getStringCellValue();
			i++;
		}
		
		return arr;
		
		
	}
	

	
	public void prep() throws IOException
	{
	driver=init();
	log.info("initialised");
	driver.get(pi.getProperty("url"));
	log.info("launched");
	}

	@Test (dataProvider="fetchdata")
	public void logtest(String usr,String pass1) throws IOException
	{
	prep();
	factory fact = PageFactory.initElements(driver, factory.class);
	fact.log(usr, pass1);
	log.info("login 1");
	logout();
	}
	
	
	public void logout() throws IOException
	{
	 
		homefactory hg = PageFactory.initElements(driver, homefactory.class);
		hg.logout();
		driver.close();
		
	}
	
	@AfterTest
	public void cleanup(){
		driver.quit();
		}
	

}
