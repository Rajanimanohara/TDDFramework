package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {//Step 1 : Create pom class for every web page
	
	//step 2 : Identify the element by @FindBy, @FindAll and @FindBys
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
	//Step 3 : Create a constructor to initialize these elements
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Step 4 : create getters method to access the elements
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}
	
	//Step 5 :  Business Librabries - generic methods specific to current project
		/**
		 * This method will perform click operation on Organization lookup Image
		 */
		public void clickCreateOrganizationLookUpImg()
		{
			CreateOrgLookUpImg.click();
		}

}
