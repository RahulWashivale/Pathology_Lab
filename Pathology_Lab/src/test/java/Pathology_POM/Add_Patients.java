package Pathology_POM;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pathology_TestCases.BaseClass;

public class Add_Patients {

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[1]/a")
	private WebElement AddPatients;

	@FindBy(name = "name")
	private WebElement PatientName;

	@FindBy(name = "email")
	private WebElement PatientEmail;

	@FindBy(name = "phone")
	private WebElement PatientPhone;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/div/div[2]/div[2]/button[2]")
	private WebElement GDetails;

	@FindBy(name = "height")
	private WebElement Patientheight;

	@FindBy(name = "weight")
	private WebElement Patientweight;

	@FindBy(id = "mui-component-select-gender")
	private WebElement PatientGender;

	@FindBy(xpath = "//*[@id=\"menu-gender\"]/div[3]/ul/li[2]")
	private WebElement GenderList;

	@FindBy(name = "age")
	private WebElement Patientage;

	@FindBy(name = "systolic")
	private WebElement Patientsystolic;

	@FindBy(name = "diastolic")
	private WebElement Patientdiastolic;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/div/div[2]/div[2]/button[2]/span[1]")
	private WebElement AddTest;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[2]/div/div")
	private WebElement CostCalc_DISC_2;

	@FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul/li[3]")
	private WebElement CostCalc_DISC_List_2;

	@FindBy(id = "patient-tests-labs")
	private WebElement PatientLab;

	@FindBy(name = "doctor_name")
	private WebElement doctorname;

	@FindBy(xpath = "//*[@id=\"mui-component-select-doctor_commission\"]")
	private WebElement doctorCommision;

	@FindBy(xpath = "//*[@id=\"menu-doctor_commission\"]/div[3]/ul/li[2]")
	private WebElement doctorCommision_List;

	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit\" and @type=\"button\" and @title=\"Add equipment\"]")
	private WebElement AddEquip;

	
	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit\" and @type=\"button\" and @title=\"Save\"]")
	private WebElement Equipquantity;

	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[2]/div/div[2]/div[2]/button[2]")
	private WebElement PatientAdded;

	public Add_Patients(WebDriver rdriver) {
		PageFactory.initElements(rdriver, this);
	}

	public void Patient_Adding() {
		AddPatients.click();

	}

	public void PatientName(String value) {
		PatientName.sendKeys(value);
	}

	public void PatientEmail(String value2) {
		PatientEmail.sendKeys(value2);
	}

	public void PatientPhone(String value3) {
		PatientPhone.sendKeys(value3);
	}

	public void PatientInfo_Save() {
		GDetails.click();

	}

	public void Patient_Height(int randomHeight) {
		String heightAsString = Integer.toString(randomHeight);
		Patientheight.sendKeys(heightAsString);
	}

	public void Patient_Weight(int value5) {
		String WeightAsString = Integer.toString(value5);
		Patientweight.sendKeys(WeightAsString);
	}

	public void Patient_Gender() {
		PatientGender.click();

	}

	public void Patient_Gender_List() {
		GenderList.click();

	}

	public void Patient_Age(int value6) {
		String AgeAsString = Integer.toString(value6);
		Patientage.sendKeys(AgeAsString);
	}

	public void Patient_systolic(int value7) {
		String systolicAsString = Integer.toString(value7);
		Patientsystolic.sendKeys(systolicAsString);
	}

	public void Patient_diastolic(int value8) {
		String diastolicAsString = Integer.toString(value8);
		Patientdiastolic.sendKeys(diastolicAsString);
	}

	public void PatientInfo_Save_2(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(AddTest));

		AddTest.click();

	}

	public void Cost_Calculator() {
		CostCalc_DISC_2.click();

	}

	public void Cost_Calculator_List() {
		CostCalc_DISC_List_2.click();

	}

	public void LabSelection(String value) throws InterruptedException {
		PatientLab.sendKeys(value);
		Thread.sleep(1000);
		PatientLab.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		PatientLab.sendKeys(Keys.ENTER);

	}

	public void DoctorRecommendation(String value) throws InterruptedException {
		doctorname.sendKeys(value);
		doctorname.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		doctorname.sendKeys(Keys.ENTER);
	}

	public void doctor_Commision() {
		doctorCommision.click();

	}

	public void doctor_Commision_List() {
		doctorCommision_List.click();

	}

	public void Equipment(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
		wait.until(ExpectedConditions.elementToBeClickable(AddEquip));
		Actions actions = new Actions(driver);
		actions.moveToElement(AddEquip).doubleClick().build().perform();

	}

	public void Equipment_save(WebDriver driverr) {
		WebDriverWait wait = new WebDriverWait(driverr, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(Equipquantity));

		Equipquantity.click();
	}

	public void Patient_Confirm(WebDriver driverr) {
		WebDriverWait wait = new WebDriverWait(driverr, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(PatientAdded));

		PatientAdded.click();
		
		 try {
		        Thread.sleep(15000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }

	}

}
