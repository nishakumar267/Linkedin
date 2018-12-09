package Linkedin.Linkedin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class factory {
	

	@FindBy(xpath="//*[@id='login-email']")
	public WebElement user;
	@FindBy(xpath="//*[@id='login-password']")
	public WebElement pwd;
	@FindBy(xpath="//*[@id='login-submit']")
	public WebElement login;
	
	public void log(String usr, String pass)
	{
		user.sendKeys(usr);
		pwd.sendKeys(pass);
		login.click();
	}

}
