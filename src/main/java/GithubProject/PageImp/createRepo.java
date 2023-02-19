package GithubProject.PageImp;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GithubProject.Base.Common;

public class createRepo extends Common {
	RemoteWebDriver driver;
	Properties property;
	public createRepo(RemoteWebDriver driver, Properties property)
	{
		this.driver=driver;
		this.property=property;
	}
	public void CreateRepository()
	{
		WebElement findElement1 = driver.findElement(By.xpath(property.getProperty("CreateRepro")));
		clickAction(findElement1);
		WebElement findElement2 = driver.findElement(By.xpath(property.getProperty("NewRepo")));
		clickAction(findElement2);
		String text = driver.findElement(By.xpath(property.getProperty("IdVerification"))).getText();
		verify(text, property.getProperty("RepoVerify"));
		WebElement findElement3= driver.findElement(By.xpath(property.getProperty("RepoName")));
		sendKey(findElement3,property.getProperty("RepoNameText"));
		WebElement findElement4 = driver.findElement(By.xpath(property.getProperty("Visibility")));
		boolean selected = findElement4.isSelected();
		System.out.println("Public is Enabled : "+ selected);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement findElement5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(property.getProperty("lastRepoClick"))));
		clickAction(findElement5);
	}
}
