package vtiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactTest extends BaseClass 
{
	@Test(groups = "SmokeSuite")
	public void CreateContactTest() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 1, 2);
		
		HomePage hp = new HomePage(driver);
		hp.clickContactsLink();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickCreateContactLookUpImg();
		
		CreateNewContactPage cConP = new CreateNewContactPage(driver);
		cConP.createNewContact(LASTNAME);
		
		ContactsInfoPage conIp = new ContactsInfoPage(driver);
		String ContactHeader = conIp.getContactHeaderText();
		
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader+" --- Contact created ");
		
		hp.logoutOfApp(driver);
		System.out.println("Sign out successfull");
		
		Thread.sleep(2000);
	}

}
