package vtiger.OrganizationsTest;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateOrganizationTest extends BaseClass {
	
	@Test(groups = "SmokeSuite")
		public void CreateOrganizationTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		Random r = new Random();
		int random = r.nextInt(1000);
		
		//Step 1 :Read data from excel file - Test Data
		
			ExcelFileUtility eUtil = new ExcelFileUtility();
		 	String ORGNAME = eUtil.readDataFromExcelFile("Organizations", 1, 2)+random;
				
			//Step 4 : Navigate to Organization Link
			HomePage hp = new HomePage(driver);
			hp.clickOrganizationsLink();
			
			//Step 5 : Click on create Organization look up image
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickCreateOrganizationLookUpImg();
			
			//Step 6 : Create Organization with mandatory fields and save
			CreateNewOrganizationPage co = new CreateNewOrganizationPage(driver);
			co.createOrganization(ORGNAME);
			
			Thread.sleep(2000);
			
			//step 7 : Verification for Organization
			OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
			String OrganizationHeader = oip.getOrgHeader();
			
			Assert.assertTrue(OrganizationHeader.contains(ORGNAME));
			System.out.println(OrganizationHeader+" --- Organization created ");
			
			Thread.sleep(2000);

		}
		
		@Test(groups = "RegressionSuite")
		public void demoScript() {
			System.out.println("Demo");
			//Assert.fail();
		}
		
		@Test
		public void regional() {
			System.out.println("regional regression");
		}


}
