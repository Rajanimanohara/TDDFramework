package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {//Step 1 : Create pom class for every web page
	
	//step 2 : Identify the element by @FindBy, @FindAll and @FindBys
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateContactLookUpImg;
	
	//Step 3 : Create a constructor to initialize these elements
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Step 4 : create getters method to access the elements
	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}

	//Step 5 :  Business Librabries - generic methods specific to current project
	/**
	 * This method is used to click on Plus Create Contacts lookup Image
	 */
	public void clickCreateContactLookUpImg()
	{
		CreateContactLookUpImg.click();
	}
	

}
