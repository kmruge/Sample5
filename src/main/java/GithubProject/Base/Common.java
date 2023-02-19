package GithubProject.Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Common extends WebDriver {
	public RemoteWebDriver driver;
	public void clickAction(WebElement ele)
	{
		ele.click();
	}
	public void typeKey(WebElement ele, String value)
	{
		ele.sendKeys(value);
	}
	public void sendKey(WebElement ele, String name)
	{
		ele.sendKeys(name);
	}
}