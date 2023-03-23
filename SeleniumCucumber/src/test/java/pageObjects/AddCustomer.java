package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer {

	public WebDriver ldriver;

	public AddCustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}


	By lnkCustomerMenu =By.xpath( "//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/p[1]\r\n");
	By lnkCusomersClick =By.xpath( "//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]");
	By addnewbutton =By.xpath( "//body/div[3]/div[1]/form[1]/div[1]/div[1]/a[1]");
	By txtemail =By.xpath( "//input[@id='Email']");
	By txtpassword =By.xpath( "//input[@id='Password']");
	By txtfirstname =By.xpath( "//input[@id='FirstName']");
	By txtlastname =By.xpath( "//input[@id='LastName']");
	By selectmale =By.xpath( "//label[contains(text(),'Male')]");
	By selectFemale =By.xpath( "//label[contains(text(),'Female')]");
	By dateofbirth = By.xpath("//input[@id='DateOfBirth']");
	By calendar = By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[6]/div[2]/span[1]/span[1]/span[1]/span");
	By txtcompanyname = By.xpath("//input[@id='Company']");
	By taxattemptselect = By.xpath("//input[@id='IsTaxExempt']");
	By txtnewsletter = By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]/div[1]");
	By txtcustmerroles = By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]");
	By rolesvendor = By.xpath("//li[contains(text(),'Vendors')]");
	By rolesregistered = By.xpath("//li[contains(text(),'Registered')]");
	By rolesguests = By.xpath("//li[contains(text(),'Guests')]");
	By roleForum = By.xpath("//li[contains(text(),'Forum Moderators')]");
	By roleadmin = By.xpath("//li[contains(text(),'Administrators')]");
	By mgrvendor = By.xpath("//select[@id='VendorId']");
	By selectActive = By.xpath("//input[@id='Active']");
	By admincomment = By.xpath("//textarea[@id='AdminComment']");
	By savebutton = By.xpath("//body/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]");

	//Action Methods
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}

	public void clickonCutomerMenu() {
		ldriver.findElement(lnkCustomerMenu).click();
	}

	public void clickonCutomerMenuItem() {
		ldriver.findElement(lnkCusomersClick).click();
	}

	public void clickonAddButtin() {
		ldriver.findElement(addnewbutton).click();
	}

	public void setEmail(String email) {
		ldriver.findElement(txtemail).sendKeys(email);;
	}

	public void setPassword(String pwd) {
		ldriver.findElement(txtpassword).sendKeys(pwd);;
	}
	
	public void setDob(String dob) {
		ldriver.findElement(dateofbirth).sendKeys(dob);;
	}
	
	public void setCompanyname(String cname) {
		ldriver.findElement(txtcompanyname).sendKeys(cname);;
	}

	public void setRoles(String role) throws InterruptedException {
		
//		Select drp = new Select(ldriver.findElement(txtcustmerroles));
//		drp.selectByVisibleText(role);

		if(!role.equals("Vendors")) {
			ldriver.findElement(By.xpath("//li[contains(text(),'Vendors')]"));
		}
		ldriver.findElement(txtcustmerroles);
		
		//ldriver.findElement(txtcustmerroles).click();
		WebElement listitem;
		Thread.sleep(2000);
		if(role.equals("Vendors")) {
			listitem = ldriver.findElement(rolesvendor);

		}
		else if (role.equals("Administrators")) {
			listitem = ldriver.findElement(roleadmin);

		}
		else if(role.equals("Guests")) {
			listitem = ldriver.findElement(rolesguests);

		}
		else if(role.equals("Registered")) {
			listitem = ldriver.findElement(rolesregistered);

			
		}
		else {
			listitem = ldriver.findElement(roleForum);

		}
		
		//listitem.click(); //if it is not work follow the below item
		
		JavascriptExecutor je = (JavascriptExecutor) ldriver;
		je.executeScript("arguments[0].click();", listitem);
		
//			
		}


	public void setManagerofVendor(String value) {
		Select drp = new Select(ldriver.findElement(mgrvendor));
		drp.selectByVisibleText(value);
		
	}
	
	public void setGender(String gender) {
		if(gender.equals("Male")) {
			ldriver.findElement(selectmale).click();
		}
		else if (gender.equals("Female")) {
			ldriver.findElement(selectFemale).click();
		}
		else {
			ldriver.findElement(selectmale).click();

			
		}
	}
		
		public void setfname(String fname) {
			ldriver.findElement(txtfirstname).sendKeys(fname);
		}	
		
		public void setLname(String lname) {
			ldriver.findElement(txtlastname).sendKeys(lname);
		}
		
		public void setAdminComment(String comment) {
			ldriver.findElement(admincomment).sendKeys(comment);
		}
		
		public void setNewsletter(String news) {
			ldriver.findElement(txtnewsletter).sendKeys(news);
		}
		
		public void clickSaveButton() {
			ldriver.findElement(savebutton).click();
		}
	}















	