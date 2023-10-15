package stepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class steps {
	
	Response response;
	private String url;
	String expectedTitle  = "Sesame Street";
	WebDriver driver = new ChromeDriver();
	String baseUrl = "https://api.wikimedia.org/wiki/Core_REST_API/Reference/Search";
//	private By driver1;
	
	@Given("^Open URL with chrome$")
	public void open_URL_with_chrome() throws Throwable{
		
		System.out.println("this step open browser and lanuch URL");
		
		System.setProperty("webdriver.chrom.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);
	}
	
	@When("^user type furry rabbits$") 
	public void user_type_furry_rabbits() throws Throwable{
		System.out.println("this step  click on seacrhbar and type Furry Rabbit");
		String search = "Furry Rabbits";
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[3]/div/div[2]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[3]/div/div[2]/form/div/div[2]/input")).sendKeys(search);
		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[3]/div/div[2]/form/div/div[2]/input")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//*[@id=\"search\"]/div[4]/div[2]/span/a/span[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"mw-advancedSearch-expandable-namespaces\"]/div/div[2]/div/div/label[4]/span[1]/input")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"mw-search-top-table\"]/div/div/div/span/span/button/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[2]/div[3]/div/a[5]")).click();
		
	Thread.sleep(10000);
	
	 List<WebElement> tdElements = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div[2]/div[4]"));
	 String searchText = "Sesame Street";

     // Loop through the list and search for the desired text
     WebElement[] elements = null;
	for (WebElement element : elements) {
         String elementText = element.getText();

         if (elementText.contains(searchText)) {
             // Found the desired element
             System.out.println("Found element with text: " + elementText);
             // Perform actions with the found element
             System.out.println("Title Matched");
             driver.findElement(By.linkText(searchText)).click();
         }
	}
		
	}
	
	@Then("^check page title$")
	public void check_page_title() throws Throwable{
	
		System.out.println("this step veify result");
String actualTitle  = driver.getTitle();
		
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Title Matched");
			driver.navigate().back();
			
		}
		else
		{
			System.out.println("Title didn't match");
			
			driver.navigate().back();
		}

		
		
	}
	
	public class Timestamps extends steps{
	    // Step definitions for search-related scenarios
		
		@Given("^user is on the search page$")
		public void user_is_on_the_search_page() throws Throwable{
			
			System.out.println("this step user is on the search page");
			
		}
		
		@When("^seasme page details requested$") 
		
		public void user_type_furry_rabbits() throws Throwable{
			System.out.println("this step  seasme page details requested");
		
			String actualTitle  = driver.getTitle();
			
			if(actualTitle.equalsIgnoreCase(expectedTitle))
			{
				System.out.println("Title Matched");
				driver.navigate().back();
				
			}
			else
			{
				System.out.println("Title didn't match");
				
				driver.navigate().back();
			}
			
		}
		
		@Then("^check page title$")
		public void check_page_title() throws Throwable{
		
			System.out.println("this step veify result");
			JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Execute JavaScript to get the timestamps
	        Long pageLoadStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
	        Long pageLoadEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");

	        // Calculate the page load time in milliseconds
	        long pageLoadTime = pageLoadEnd - pageLoadStart;

	        // Convert milliseconds to seconds
	        double pageLoadTimeInSeconds = pageLoadTime / 1000.0;

	        // Print the page load timestamp
	        System.out.println("Page Load Timestamp: " + pageLoadTimeInSeconds + " seconds");

	        // Close the WebDriver when done
	        driver.quit();
	    }
	
	
	}
}
