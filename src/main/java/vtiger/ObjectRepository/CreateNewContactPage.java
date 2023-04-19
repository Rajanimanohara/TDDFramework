package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{//Step1 : Create pom class for every page
	
	//step 2 : Identify the element by @FindBy, @FindAll and @FindBys
	@FindBy(name = "lastname")
	private WebElement LastnameEdt;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement OrgLookUpImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name = "search_text")
	private WebElement SearchEdt;
	
	@FindBy(name = "search")
	private WebElement SearchBtn;
	
	//Step 3 : Create a constructor to initialize these elements
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Step 4 : create getter methods to access the elements
	public WebElement getLastnameEdt() {
		return LastnameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	
	//Step 5 : Business Librabries - generic method specific to current project
	/**
	 * This method to create a new contact with lastname
	 * @param Lastname
	 */
	public void createNewContact(String Lastname)
	{	
		LastnameEdt.sendKeys(Lastname);
		SaveBtn.click();
	}
	
	/**
	 * This method will create ontact with organization
	 * @param Lastname
	 * @param OrgName
	 * @param driver
	 */
	public void createNewContact(String Lastname, String OrgName, WebDriver driver)
	{	
		LastnameEdt.sendKeys(Lastname);
		OrgLookUpImg.click();
		switchToWindow(driver,"Account");
		SearchEdt.sendKeys(OrgName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
		
	}

}
