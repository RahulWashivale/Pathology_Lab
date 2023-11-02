package Pathology_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pathology_POM.LoginPage;

public class TC_LoginPage_001 extends BaseClass {

	@Test
	void Login() throws InterruptedException {
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

	}
}
