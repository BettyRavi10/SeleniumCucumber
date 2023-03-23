package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomer;
import pageObjects.LoginPage;
import pageObjects.SearchCustomer;


public class Steps extends BaseClass
{
	@Before
	public void setUp() throws IOException {

		logger = Logger.getLogger("nopcommerce");//added logger
		PropertyConfigurator.configure("log4j.properties");

		//Reading property file
		configProp = new Properties();

		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);


		String br = configProp.getProperty("browser");
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			System.setProperty("webdriver.chrome.whitelistedIps", "");
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new ChromeDriver();

		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			System.setProperty("webdriver.chrome.whitelistedIps", "");
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new InternetExplorerDriver ();

		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			System.setProperty("webdriver.chrome.whitelistedIps", "");
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			driver = new FirefoxDriver();

		}

		logger.info("----Launch browser----");


	}
	@Given("launch chrome browser") 
	public void launch_chrome_browser() {
		lp = new LoginPage(driver);
	}

	@When("User open URL")
	public void user_open_url() {
		logger.info("----Launch URL----");
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();

	}

	@When("user enter email ID as {string} and password as {string}")
	public void user_enter_email_id_as_and_password_as(String email, String password) {
		logger.info("----Providing login credentialsr----");
		lp.setUsername(email);
		lp.setPassword(password);
	}

	@When("User click login")
	public void user_click_login() {
		logger.info("----Start login----");
		lp.clickLogin();

	}

	@Then("Page title should be displayed as {string}")
	public void page_title_should_be_displayed_as(String title) {

		if(driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title, driver.getTitle());;

		}
		logger.info("----Login  Succesful----");


	}

	@When("user click logout")
	public void user_click_logout() throws InterruptedException {
		logger.info("----Logout  App----");

		lp.clickLogout();
		Thread.sleep(1500);

	}


	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getTitle().equals("Your store. Login")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);

		}

		logger.info("----Title correct----");


	}


	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();


	}

	//Customer feature step definitions

	@Then("User can view the Dashboard")
	public void user_can_view_the_dashboard() {
		addCust = new AddCustomer(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());

	}

	@When("user clicks on customers menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickonCutomerMenu();
	}

	@When("click on customers menu item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickonCutomerMenuItem();

	}

	@When("Click on Add New button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickonAddButtin();


	}

	@Then("user can view Add new customer Page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());

	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		logger.info("----Add  Customer----");
		logger.info("----Add  Customer details----");

		String email = randomString() + "@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		//addCust.setRoles("Guests");
		Thread.sleep(3000);
		addCust.setAdminComment("Add the First customer");
		addCust.setDob("7/05/1985");
		addCust.setGender("Male");
		addCust.setfname("Ravikumar");
		addCust.setLname("Ponraj");
		addCust.setCompanyname("Abc Solns");
		addCust.setManagerofVendor("Vendor 2");
		//addCust.setNewsletter("Test store 2");
		Thread.sleep(2000);

	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.clickSaveButton();
		logger.info("---- Customer added successfully----");
		Thread.sleep(3000);

	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));


	}


	//Search customer by email id

	@When("enter the email id")
	public void enter_the_email_id() throws InterruptedException {
		searchCust = new SearchCustomer(driver);
		searchCust.setSearchEmail("admin@yourStore.com");

	}

	@When("click on Search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(2000);

	}

	@Then("The customer record related to the email id will be displayed")
	public void the_customer_record_related_to_the_email_id_will_be_displayed() {
		boolean status =searchCust.searchCustomerByEmail("admin@yourStore.com");
		Assert.assertEquals(true,status);
	}

	//Search by first name and last name

	@When("enter the firstname")
	public void enter_the_firstname() throws InterruptedException {
		logger.info("----Search  Customer----");

		searchCust = new SearchCustomer(driver);
		searchCust.setFirstName("Ravikumar");

	}

	@When("enter the lastname")
	public void enter_the_lastname() throws InterruptedException {
		searchCust.setLastName("Ponraj");

	}

	@Then("The customer record related to the name will be displayed")
	public void the_customer_record_related_to_the_name_will_be_displayed() {
		boolean status = searchCust.searchCustomerByName("Ravikumar POnraj");
		Assert.assertEquals(true, status);

	}





}
