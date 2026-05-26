package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--incognito");

		driver = new ChromeDriver(options);	
		driver.manage().window().maximize();
		driver.get("https://practicesoftwaretesting.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
	