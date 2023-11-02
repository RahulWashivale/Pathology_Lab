package Pathology_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name = "email")
	private WebElement uname;
	
	@FindBy(name = "password")
	private WebElement upass;
	
	@FindBy(xpath ="//*[@id=\"root\"]/div/div/form/button[1]/span[1]")
	private WebElement ulogin;
	
	public LoginPage(WebDriver rdriver){
		PageFactory.initElements(rdriver, this);
	}
	
	public void SetName(String name) {
		uname.sendKeys(name);
	}
	 public void SetPass(String pass) {
		 upass.sendKeys(pass);
	}
	 public void Setlogin() {
		 ulogin.click(); 
		
	 }

}
