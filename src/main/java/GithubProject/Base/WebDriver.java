package GithubProject.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.template.SimpleDate;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriver {
	public RemoteWebDriver driver;
	public Properties property;
	public ExtentHtmlReporter htmlReport;
	public ExtentReports report;
	public ExtentTest test;
	@BeforeTest
	public void setUpExtents()
	{
		htmlReport=new ExtentHtmlReporter(".\\test-output\\extentReport.html");
		htmlReport.config().setDocumentTitle("Extents Report");
		htmlReport.config().setReportName("Functional Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		
		report.setSystemInfo("Window", "window 10");
		report.setSystemInfo("Id", "kmruge");
		report.setSystemInfo("source", "Github");
	}
	@AfterTest
	public void flush()
	{
		report.flush();
	}
	@BeforeClass
	public void driverRun()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		property=new Properties();
		try {
			property.load(new FileInputStream("C:\\Users\\kmruge\\Pictures\\jai\\allAboutPractice\\src\\main\\java\\GithubProject\\pro.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void verify(String value1 ,String value2)
	{
		Assert.assertEquals(value1, value2,"Assertion Failed");
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test failed at "+result.getTestName());
			test.log(Status.FAIL, "Test failed at "+result.getThrowable());
			String screenShot = ScreenShot();
			test.addScreenCaptureFromPath(screenShot);
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Passed at "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.SKIP, "Test result Skipped at "+result.getName());
		}
	}
	public String ScreenShot() throws IOException
	{
		String date=new SimpleDateFormat("yyyymmdd").format(new Date());
		File dig=driver.getScreenshotAs(OutputType.FILE);
		String sourceString=(".\\ScreenShot\\"+date+"ScreenShot.png");
		File source=new File(sourceString);
		FileUtils.copyFile(dig, source);
		return sourceString;
	}
}
