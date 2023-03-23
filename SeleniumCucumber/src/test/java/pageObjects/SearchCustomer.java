package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomer {
	public WebDriver ldriver;
	WaitHelper waithelper;

	public SearchCustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		waithelper = new WaitHelper(ldriver);

	}

	//	By txtEmail = By.xpath("//input[@id='SearchEmail']");
	//	By searchButton = By.xpath("//button[@id='search-customers']");
	//	By enailHeader = By.xpath("//th[contains(text(),'Email')]");


	@FindBy(how = How.ID, using = "SearchEmail" )
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how = How.ID, using = "SearchFirstName" )
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(how = How.ID, using = "SearchLastName" )
	@CacheLookup
	WebElement txtLastName;

	@FindBy(how = How.ID, using = "SearchMonthOfBirth" )
	@CacheLookup
	WebElement txtMonthOfBirth;

	@FindBy(how = How.ID, using = "SearchDayOfBirth" )
	@CacheLookup
	WebElement txtDateOfBirth;

	@FindBy(how = How.ID, using = "SearchRegistrationDateFrom" )
	@CacheLookup
	WebElement txtRegDateFrom;

	@FindBy(how = How.ID, using = "SearchRegistrationDateTo" )
	@CacheLookup
	WebElement txtRegDateTo;

	@FindBy(how = How.ID, using = "SearchLastActivityFrom" )
	@CacheLookup
	WebElement txtLastActFrom;

	@FindBy(how = How.ID, using = "SearchLastActivityTo" )
	@CacheLookup
	WebElement txtLastActTo;

	@FindBy(how = How.ID, using = "SearchCompany" )
	@CacheLookup
	WebElement txtSearchCompany;

	@FindBy(how = How.ID, using = "SearchIpAddress" )
	@CacheLookup
	WebElement txtSearchIpaddress;

	@FindBy(how = How.XPATH, using = "//div[@class = 'k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtCustomerRoles;

	@FindBy(how = How.XPATH, using = "//li[contains(text(), 'Administrators')]")
	@CacheLookup
	WebElement listAdmin;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Forum Moderators')]")
	@CacheLookup
	WebElement listForum;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement listGuests;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement listRegistered;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement listVendors;


	@FindBy(how = How.ID, using = "search-customers" )
	@CacheLookup
	WebElement searchButton;

	@FindBy(how = How.XPATH, using = "//table[@xpath ='1']")
	@CacheLookup
	WebElement tableSearchResults;


	@FindBy(how = How.XPATH, using = "//table[@id= 'customers-grid']")
	@CacheLookup
	WebElement table;

	@FindBy(how = How.XPATH, using = "//table[@id= 'customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(how = How.XPATH, using = "//table[@id= 'customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;



	//Action Methods

	public void setSearchEmail(String email) throws InterruptedException {
		//waithelper.waitForElement(txtEmail, 30);
		Thread.sleep(2000);
		txtEmail.clear();
		txtEmail.sendKeys(email);

	}

	public void setFirstName(String fname) {
		//waithelper.waitForElement(txtFirstName, 30);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);

	}
	public void setLastName(String lname) throws InterruptedException {

		//	waithelper.waitForElement(txtLastName, 30);
		Thread.sleep(2000);
		txtLastName.clear();
		txtLastName.sendKeys(lname);

	}

	public void clickSearch() throws InterruptedException {
		searchButton.click();
		Thread.sleep(2000);
		//		waithelper.waitForElement(searchButton, 30);
	}

	public int getNoRows() {
		return tableRows.size();
	}

	public int getNoColumns() {
		return tableColumns.size();
	}

	public boolean searchCustomerByEmail(String email) {

		boolean flag = false;

		for(int i = 1;i<=getNoRows();i++) {
			String emailId = table.findElement(By.xpath("//table[@id= 'customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			if(emailId.equals(email)) {
				flag=true;

			}
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String name) {

		boolean flag = false;

		for(int i = 1;i<=getNoRows();i++) {
			String name1 = table.findElement(By.xpath("//table[@id= 'customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			String names[] = name1.split(" ");  //seperating fname and lname
			if(names[0].equals("Ravikumar") && names[1].equals("Ponraj")) {
				flag=true;

			}
		}
		return flag;
	}


}

