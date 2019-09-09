package steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class StepDefinition {
	
	public WebDriver driver;

	@Given("^I launch the webpage$")
	public void i_launch_the_webpage() throws InterruptedException {
		System.out.println("Print web page launch");

		System.setProperty("webdriver.chrome.driver",
				"C:/Automation/Workspace_FXIP/CucumberJava/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		driver.quit();

	}

	@When("^I click on submit$")
	public void i_click_on_submit() {
		System.out.println("Print Print Print");
	}

	@When("^Login with (.*?)$")
	public void helloHere(String userName) {
		System.out.println("TEXT --- " + userName);
	}
	
	/*
Given: I launch google
When: I search "nearby restaurant"
Then: I select the first value
	*/
	@Given("^I launch google$")
	public void i_launch_google() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Automation/Workspace_FXIP/CucumberJava/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='btnK']")).isDisplayed());
		Thread.sleep(2000);
	}

	@When("^I search (.*?)$")
	public void i_search(String searchValue) {
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(searchValue);
		
	}
	
	@When("^I select the first value$")
	public void i_select_firstvalue() {
		
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='hdtb-mitem hdtb-msel hdtb-imb']")).isDisplayed());
	List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='ellip']"));
	searchResults.get(1).click();
	driver.quit();
	}
}
