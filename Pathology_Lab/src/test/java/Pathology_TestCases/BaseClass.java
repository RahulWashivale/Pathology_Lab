package Pathology_TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pathology_Utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	String BaseURL = readconfig.ApplicationURL();
	String Username = readconfig.User();
	String Password = readconfig.Pass();
	String Val = readconfig.TestData();
	String Laboratory = readconfig.Lab();
	String Dr = readconfig.Doctors();
	protected WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	void Setup() {
		System.setProperty("webdriver.chrome.driver", readconfig.ChromePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterClass
	void Close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}

}
