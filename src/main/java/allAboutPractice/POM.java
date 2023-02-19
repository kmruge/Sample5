package allAboutPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class POM {
	public void login(RemoteWebDriver driver, String email, String password)
	{
		driver.findElement(By.xpath("//div/input[@name='username']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	public String textExtract(RemoteWebDriver driver)
	{
		return driver.findElement(By.xpath("//p[text()='Time at Work']")).getText();
	}
}