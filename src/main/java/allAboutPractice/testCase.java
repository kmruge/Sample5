package allAboutPractice;

import org.testng.annotations.Test;

public class testCase extends driverClass {
	@Test
	public void test()
	{
		new POM().login(driver,"Admin","admin123");
	}
	@Test
	public void test1()
	{
		String ji=new POM().textExtract(driver);
		System.out.println(ji);
	}
}
