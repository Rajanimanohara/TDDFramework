package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {//Step 1 : Create pom class for every web page
	
	//Step 2 : Identify the elements by using @FindBy, @FindAll and @FindBys
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;

	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']/a")
	private WebElement OrganizationNameLink;
	
	//Step 3 : Create a constructor to initialize these elements
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Business Libraries : this methods are specific to project
	/**
	 * This method to capture the text from contact header text 
	 * @return
	 */
	public String getContactHeaderText() {
		return ContactHeaderText.getText();
	}

}
