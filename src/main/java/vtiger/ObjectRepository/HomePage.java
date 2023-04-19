package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{//Step 1 : Create a pom for every webpage
	
	//Step 2 : Identify the element by using @FindBy, @FindAll and @FindBys 
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Products")
	private WebElement ProductLink;
	
	//Step 3 : Create a constructor to initialize these Web elements
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Step 4 : Create getters to access these elements
	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}
	
	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getProductLink() {
		return ProductLink;
	
	}
	
	//Step 5 :  Business Librabries - generic methods specific to current project
	/**
	 * This method is used to click on Contacts link
	 */
	public void clickContactsLink() {
		ContactsLink.click();
	}
	
	/**
	 * This method is used to click on Organizations link
	 */
	public void clickOrganizationsLink() {
		OrganizationsLink.click();
	}
	
	/**
	 * This method is used to click on the Products link
	 */
	public void clickProductLink() {
		ProductLink.click();
	}
	
	/**
	 * This method will perform logout application
	 * @param driver
	 */
	public void logoutOfApp(WebDriver driver) {
		mouseHoverAction(driver, AdministratorImg);
		SignOutLink.click();
	}

}
