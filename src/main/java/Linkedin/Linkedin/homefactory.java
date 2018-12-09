package Linkedin.Linkedin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class homefactory {
	
	@FindBy(xpath="//*[@id='nav-settings__dropdown-trigger']/div/span[1]")
	public WebElement me;
	
	//@FindBy(xpath="//*[@id='ember883']")
	
	
	@FindBy(how = How.LINK_TEXT, using = "Sign out")
	public WebElement lg;

	//*[@id='nav-settings__dropdown']/div/ul[4]
	public void logout()
	{
		
		me.click();
		lg.click();
		
	}

}
