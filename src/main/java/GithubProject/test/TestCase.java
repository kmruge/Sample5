package GithubProject.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import GithubProject.Base.WebDriver;
import GithubProject.PageImp.DeleteRepo;
import GithubProject.PageImp.HomePage;
import GithubProject.PageImp.LoginPage;
import GithubProject.PageImp.createRepo;

public class TestCase extends WebDriver{
	HomePage hPage=null;
	LoginPage lPage=null;
	createRepo cpage=null;
	DeleteRepo dpage=null;
	@BeforeClass
	public void Instance()
	{
		hPage=new HomePage(driver, property);
		lPage=new LoginPage(driver,property);
		cpage=new createRepo(driver, property);
		dpage=new DeleteRepo(driver,property);
	}
	@Test(priority=1)
	void login()
	{
		test=report.createTest("Login Test");
		hPage.LoadURL();
		hPage.clickSignIn();
		lPage.EmailandPass();
	}
	@Test(priority=2)
	void RepoCreate()
	{
		test=report.createTest("Repository Creating");
		cpage.CreateRepository();
	}
	@Test(priority=3)
	void deleteRepo()
	{
		test=report.createTest("Deleting Repository");
		dpage.delRepo();
	}
	
}
