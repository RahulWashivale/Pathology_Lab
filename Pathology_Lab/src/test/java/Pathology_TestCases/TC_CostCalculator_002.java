package Pathology_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pathology_POM.HomePage;
import Pathology_POM.LoginPage;

public class TC_CostCalculator_002 extends BaseClass {

	@Test
	void Calculator() throws InterruptedException {
		driver.get(BaseURL);
		Thread.sleep(20);

		LoginPage LP = new LoginPage(driver);
		LP.SetName(Username);

		LP.SetPass(Password);

		LP.Setlogin();

		if (driver.getTitle().equals("GOR Pathology Web Portal")) {
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);

		}

		HomePage HP = new HomePage(driver);

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

		while (true) {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(2000); // Adjust the sleep time as needed

			long newHeight = (long) js.executeScript("return document.body.scrollHeight");
			if (newHeight == lastHeight) {
				break; // Reached the bottom of the page
			}
			lastHeight = newHeight;
		}

		HP.CostCalculator();
		HP.CostCalculator(Val);
		HP.CostCalculator_DISC();
		HP.CostDisc();
	}

}
