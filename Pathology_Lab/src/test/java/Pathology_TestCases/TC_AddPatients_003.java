package Pathology_TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pathology_POM.Add_Patients;
import Pathology_POM.HomePage;
import Pathology_POM.LoginPage;

public class TC_AddPatients_003 extends BaseClass {

	@Test
	void AddPatients() throws InterruptedException {

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
		long lastHeight2 = (long) js.executeScript("return document.body.scrollHeight");
		long lastHeight3 = (long) js.executeScript("return document.body.scrollHeight");

		while (true) {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(2000);

			long newHeight = (long) js.executeScript("return document.body.scrollHeight");
			if (newHeight == lastHeight) {
				break;
			}
			lastHeight = newHeight;
		}

		HP.CostCalculator();
		HP.CostCalculator(Val);
		HP.CostCalculator_DISC();
		HP.CostDisc();

		HP.AddPatient();

		Add_Patients AP = new Add_Patients(driver);

		Faker faker = new Faker();
		String randomFullName = faker.name().fullName();
		String randomEmail = faker.internet().emailAddress();
		String randomPhoneNumber = faker.numerify("##########");
		int randomHeight = faker.number().numberBetween(150, 201);
		int randomWeight = faker.number().numberBetween(50, 101);
		int randomAge = faker.number().numberBetween(18, 81);
		int randomSystolicBP = faker.number().numberBetween(90, 180);
		int randomDiastolicBP = faker.number().numberBetween(60, 99);

		AP.Patient_Adding();
		AP.PatientName(randomFullName);
		AP.PatientEmail(randomEmail);
		AP.PatientPhone(randomPhoneNumber);
		AP.PatientInfo_Save();
		AP.Patient_Height(randomHeight);
		AP.Patient_Weight(randomWeight);
		AP.Patient_Gender();
		AP.Patient_Gender_List();
		AP.Patient_Age(randomAge);
		AP.Patient_systolic(randomSystolicBP);
		AP.Patient_diastolic(randomDiastolicBP);

		while (true) {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(1000);

			long newHeight2 = (long) js.executeScript("return document.body.scrollHeight");
			if (newHeight2 == lastHeight2) {
				break;
			}
			lastHeight2 = newHeight2;
		}

		AP.PatientInfo_Save_2(driver);
		HP.CostCalculator();
		HP.CostCalculator(Val);
		AP.Cost_Calculator();
		AP.Cost_Calculator_List();
		AP.LabSelection(Laboratory);
		AP.DoctorRecommendation(Dr);
		AP.doctor_Commision();
		AP.doctor_Commision_List();

		while (true) {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(2000);

			long newHeight3 = (long) js.executeScript("return document.body.scrollHeight");
			if (newHeight3 == lastHeight3) {
				break;
			}
			lastHeight3 = newHeight3;
		}

		AP.Equipment(driver);
		AP.Equipment_save(driver);
		AP.Patient_Confirm(driver);

	}

}
