package Pathology_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;


public class ReadConfig {
	Properties pt;
	public ReadConfig() {
	File f= new File("./Configuration/Config.Properties");
	 try{
		FileInputStream Fis= new FileInputStream(f);
		pt= new Properties();
		pt.load(Fis);
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Exception Is   "+e.getMessage());
	}
	
       }
	
	public String ApplicationURL() {
		String URL = pt.getProperty("BaseURL");
		return URL; 
	}
	public String User() {
		 String Uname=pt.getProperty("Username");
		 return Uname; 
	}
	
	public String Pass(){
		String Upass = pt.getProperty("Password");
		return Upass;
	}
	
	 public String ChromePath() {
		String Cpath = pt.getProperty("ChromeDriverPath");
		return Cpath;
	}
	 
	 public String TestData() {
			String Values = pt.getProperty("Tdata");
			return Values;
		}
	 
	 public String Lab() {
			String Values = pt.getProperty("LabSelect");
			return Values;
		}
	 public String Doctors() {
			String Values = pt.getProperty("Doctor");
			return Values;
		}
		
	
}
