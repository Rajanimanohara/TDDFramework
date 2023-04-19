package Sample;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOlympicsMedal {

	public static void main(String[] args) 
	{
		//Set up the chromedriver executable file
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=null;
		try {
			
		//launch the browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//open the URL
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		int count =1;
		
		//collect all the countries
		List<WebElement> countries = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
		System.out.println("countries : "+countries.size());
		System.out.println();
		
		//navigate through each contry
		for(WebElement countryId : countries)
		{
		//get country name
		String country =countryId.getText();
		
		//these below three contries contain special char, so it will skip for these three contries
		if(!(country.contains("Ivoire") || country.contains("China") || country.contains("rkiye")))
		{
			count++;
			//collects each medals for perticular country
		 List<WebElement> medals = driver.findElements(By.xpath("(//span[text()='"+country+"']/parent::div/following-sibling::div)[position()<=4]"));
		
		 System.out.println(country);
		 //navigate through each medal
		 for(WebElement medal : medals)
		{
			String title = medal.getAttribute("title");
			if(!(title.equals("")))
			//String title = driver.findElement(By.xpath("//div[@data-cy='medal']")).getAttribute("title");
			//---System.out.print(title+"-----> "+medal.getText());
			System.out.print("-----> "+title+"("+medal.getText()+") ");
			else
			{
				System.out.print("-----> total("+medal.getText()+")");
			}
			
		}
		 
		}
		System.out.println();
		}
		System.out.println("displayed counties : "+count);
		}
		finally {
			driver.quit();
		}
		

	}

}
