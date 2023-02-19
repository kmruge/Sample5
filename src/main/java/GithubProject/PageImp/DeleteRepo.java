package GithubProject.PageImp;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GithubProject.Base.Common;

public class DeleteRepo extends Common {
	private RemoteWebDriver driver;
	private Properties property;
	public DeleteRepo(RemoteWebDriver driver, Properties property)
	{
		this.driver=driver;
		this.property=property;
	}
	public void delRepo()
	{
		WebElement findElement1 = driver.findElement(By.xpath(property.getProperty("DelSetting")));
		clickAction(findElement1);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("DelClick"))));
		clickAction(until);
		WebElement until2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(property.getProperty("DelNameGet"))));
		String DelText=until2.getText();
		System.out.println(DelText);
		driver.findElement(By.xpath(property.getProperty("DelNamePaste"))).sendKeys(DelText);
		WebElement until3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("DelFinalClick"))));
		clickAction(until3);
		String DelNotify = driver.findElement(By.xpath(property.getProperty("DelNotify"))).getText();
		System.out.println(DelNotify);
	}
}
