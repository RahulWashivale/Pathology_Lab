package Pathology_POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath ="//*[@id=\"root\"]/div/nav/div[2]/div/div/div/div[2]/ul/a[4]/div/div[2]/span")
	private WebElement Patients;
	
	@FindBy(xpath ="//*[@id=\"root\"]/div/nav/div[2]/div/div/div/div[2]/ul/a[1]/div")
	private WebElement Dashboard;
	
	@FindBy(id = "patient-test")
	private WebElement CostCalc;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div[3]/div/div[2]/div[2]/div/div")
	private WebElement CostCalc_DISC;
	
	@FindBy(xpath = "//*[@id=\"menu-\"]/div[3]/ul/li[3]")
	private WebElement CostCalc_DISC_List;
	
	
	
	public HomePage(WebDriver rdriver){
		PageFactory.initElements(rdriver, this);
	}

	
	public void dashboard() {
		 Dashboard.click(); 
		
	 }

	 public void AddPatient() {
		 Patients.click();
		
	 }
	 
	 public void CostCalculator() {
		 CostCalc.click();
		
	}
	 
	 
	 public void CostCalculator(String value) throws InterruptedException {
		 CostCalc.sendKeys(value);
		 CostCalc.sendKeys(Keys.ARROW_DOWN);
		 Thread.sleep(1000);
		 CostCalc.sendKeys(Keys.ENTER);
		
	}

	 public void CostCalculator_DISC() {
		 CostCalc_DISC.click();
		
	}
	 
	 public void CostDisc() {
		 CostCalc_DISC_List.click();
		
	}


}
