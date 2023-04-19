package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists is related to webDriver actions
 * @author Rajani
 *
 */
public class WebDriverUtility {
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait for the page to load
	 * @param driver
	 */
	public void waitForPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method waits until the element become visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method waits until the element become clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * This method to double click on an element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * This method to double click anywhere on the web page
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	
	/**
	 * This method to drag an element from source to destination
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement targetElement) {
		Actions a=new Actions(driver);
		a.dragAndDrop(srcElement, targetElement).perform();
	}
	
	/**
	 * This method will perform right click on a web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method will perform right click anywhere on web page
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver) {
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * This method will handle dropdown using index
	 * @param element
	 * @param IndexValue
	 */
	public void handleDropdown(WebElement element, int Index) {
		Select s = new Select(element);
		s.selectByIndex(Index);
	}
	
	/**
	 * This method will handle dropdown using value
	 * @param element
	 * @param IndexValue
	 */
	public void handleDropdown(WebElement element, String elementValue) {
		Select s = new Select(element);
		s.selectByValue(elementValue);
	}
	
	/**
	 * This method will handle dropdown based on visible text
	 * @param element
	 * @param IndexValue
	 */
	public void handleDropdown(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * method to deselect a selected option using index
	 * @param element
	 * @param index
	 */
	public void deselectDropdown(WebElement element,int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}
	
	/**
	 * method to deselect a selected option using value
	 * @param element
	 * @param value
	 */
	public void deselectDropdown(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}
	
	/**
	 * method to deselect a selected option using text
	 * @param element
	 * @param value
	 */
	public void deselectDropdown(String text, WebElement element) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}
	
	/**
	 * method to deselects all selected options
	 * @param element
	 * @param value
	 */
	public void deselectDropdown(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}
	
	
	
	/**
	 * This method will accept the alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will capture the text from alert popup
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle frame based on index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame based on name or Id
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will handle frame based on Web element
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method switch to immediate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * method to handle notification popup
	 * @return
	 */
	public ChromeOptions notificationPopup() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		return option;
	}
	
	/** 
	 * This method will perform random scroll downwards vertically
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	/**
	 * This method will scroll until the element is identified in DOM
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	//------------------------------------------
	/**
	 * method to scroll down the scroll bar based on x and y value
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrolldownWithCoordinateValue(JavascriptExecutor driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	/**
	 * method to scroll down the scroll bar till element reference
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrolldownTillElement(JavascriptExecutor driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	//------------------------------------------------------------
	
	/**
	 * This method will switch the window based on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		
		//Step 1 : Capture all window IDs
		Set<String> winIDs = driver.getWindowHandles();
		
		//Step 2 : Navigate to each window
		for(String win : winIDs) {
			
			//Step 3 : Switch to window and capture the title
			String winTitle = driver.switchTo().window(win).getTitle();
			
			//Step 4 : compare the title with required partial title
			if(winTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}
	
	/**
	 * this method will take screen shot and save it in folder
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshots\\"+screenshotName+".png");
		Files.copy(src, dest);
		
		return dest.getAbsolutePath();//used for extent Reports..	
		}

}
