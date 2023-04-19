package vtiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass
{
	@Test(groups = "RegressionSuite")
	public void CreateContactWithOrganizationTest() throws EncryptedDocumentException, IOException, InterruptedException {
		// Step 1: Create Object for all utilities
		
		JavaUtility jUtil = new JavaUtility();

		// Step 2: Read all the necessary Data
		/* Read data from excel sheet - Test data */
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 4, 2) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 4, 3);

		// Step 4: Click on Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationsLink();
		
		// Step 5: Click on Create Organization look up image
		OrganizationsPage orgp = new OrganizationsPage(driver);
		orgp.clickCreateOrganizationLookUpImg();
		
		// Step 6: Create Organization with mandatory details
		CreateNewOrganizationPage cOrgP = new CreateNewOrganizationPage(driver);
		cOrgP.createOrganization(ORGNAME);
		System.out.println("org created");
		
		Thread.sleep(2000);

		// Step 9: Navigate to contacts Link
		hp.clickContactsLink();

		// Step 10:Click on create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickCreateContactLookUpImg();

		// Step 11: Create contact with mandatory fields and save
		CreateNewContactPage cConP = new CreateNewContactPage(driver);
		cConP.createNewContact(LASTNAME, ORGNAME, driver);
		
		// Step 16: Validate for Contacts
		ContactsInfoPage cIp = new ContactsInfoPage(driver);
		String ContactHeader = cIp.getContactHeaderText();
		
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader+" --- Contact created ");
		
	}

}
