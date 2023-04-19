package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	
	//Step 1 : create pom class for every web page
	
		//Step 2 : Identify locator by using @FindBy, @FindAll and @FindBys
		@FindBy(name = "accountname")
		private WebElement OrgNameEdt;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement SaveBtn;
		
		@FindBy(name = "industry")
		private WebElement IndustryDropDwn;
		
		@FindBy(name = "accounttype")
		private WebElement OrgTypeDropDwn;
		
		//Step 3 : Create a constructor to initialize these web elements
		public CreateNewOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//Step 4 : create getters method to access the elements
		public WebElement getOrgNameEdt() {
			return OrgNameEdt;
		}

		public WebElement getSaveBtn() {
			return SaveBtn;
		}

		public WebElement getIndustryDropDwn() {
			return IndustryDropDwn;
		}

		public WebElement getOrgTypeDropDwn() {
			return OrgTypeDropDwn;
		}
		
		//Business Libraries : This is specific to project
		/**
		 * This method will create Organization with OrgName
		 * @param OrgName
		 */
		public void createOrganization(String OrgName) {
			OrgNameEdt.sendKeys(OrgName);
			SaveBtn.click();
		}
		
		/**
		 * This method will create Organization with OrgName and IndustryType
		 * @param OrgName
		 * @param IndustryTpe
		 */
		public void createOrganization(String OrgName, String IndustryTpe) {
			OrgNameEdt.sendKeys(OrgName);
			handleDropdown(IndustryDropDwn, IndustryTpe);
			SaveBtn.click();
		}
		
		
		public void selectOrgTypeDropdown(String OrgTypeValue) {
			WebDriverUtility wUtil = new WebDriverUtility();
			wUtil.handleDropdown(OrgTypeDropDwn,OrgTypeValue);
		}

}
