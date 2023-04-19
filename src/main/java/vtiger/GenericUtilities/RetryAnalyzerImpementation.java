package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for iRetryAnalyzer interface of TestNG
 * @author Rajani
 *
 */
public class RetryAnalyzerImpementation implements IRetryAnalyzer{
	
	int count=0;
	int retryCount = 3;
	
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		while(count<retryCount) {
			count++;
			return true;
		}
		
		return false;
	}

}
