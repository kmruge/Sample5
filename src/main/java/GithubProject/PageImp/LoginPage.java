package GithubProject.PageImp;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import GithubProject.Base.Common;

public class LoginPage extends Common {
	private RemoteWebDriver driver=null;
	private Properties property;
	public LoginPage(RemoteWebDriver driver, Properties property) {
		this.driver=driver;
		this.property=property;
	}

	public void EmailandPass()
	{
		WebElement email = driver.findElement(By.xpath(property.getProperty("EmailXpath")));
		String string1 = property.getProperty("EmailID").toString();
		typeKey(email,string1);
		WebElement pass = driver.findElement(By.xpath(property.getProperty("PasswordXpath")));
		String string2 = property.getProperty("Password").toString();
		typeKey(pass,string2);
		WebElement signin = driver.findElement(By.xpath("//input[@data-signin-label=\"Sign in\"]"));
		clickAction(signin);
		String Verify = property.getProperty("LogInAssertion");
		verify(driver.getTitle(), Verify);
	}
}
