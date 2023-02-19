package GithubProject.PageImp;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import GithubProject.Base.Common;

public class HomePage extends Common {
	private RemoteWebDriver driver;
	private Properties property;
	public HomePage(RemoteWebDriver driver, Properties property)
	{
		this.driver=driver;
		this.property=property;
	}
	public void LoadURL()
	{
		driver.get(property.getProperty("URL"));
	}
	public void clickSignIn()
	{
		WebElement findElement = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
		clickAction(findElement);
	}
}
