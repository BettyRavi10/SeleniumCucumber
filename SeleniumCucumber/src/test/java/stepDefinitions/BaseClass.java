package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomer;
import pageObjects.LoginPage;
import pageObjects.SearchCustomer;

public class BaseClass {


	public WebDriver driver;
	public LoginPage lp;
	public AddCustomer addCust;
	public SearchCustomer searchCust;
	public static Logger logger;
	public  Properties configProp;
	
	//Created for generated random String for unique email id
	
	public static String  randomString() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
		
	}
}
