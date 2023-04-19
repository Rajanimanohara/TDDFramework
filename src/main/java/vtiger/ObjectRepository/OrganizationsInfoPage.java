package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {//Step 1 : Create pom class for every web page
	
	//Step 2 : Identify the elements by using @FindBy, @FindAll and @FindBys
	@FindAll({@FindBy(xpath="//span[contains(text(),'Organization Information')]"),@FindBy(xpath="//span[@class='dvHeaderText']")})
	//@FindAll({@FindBy(xpath="//span[contains(text(),'Organization Information')]"), @FindBy(xpath = "//span[@class='dvHeaderText']")})
	//@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	//Step 3 : Create a constructor to initialize these elements
		public OrganizationsInfoPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//Business Libraries : this methods are specific to project
		/**
		 * This method to capture the text from org header and return it to caller
		 * @return
		 */
		public String getOrgHeader() {
			return OrgHeaderText.getText();
		}

}
