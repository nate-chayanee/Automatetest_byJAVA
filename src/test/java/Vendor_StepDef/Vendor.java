package Vendor_StepDef;

import static org.junit.Assert.assertEquals;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Vendor {
	public static WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:3000");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// embed it in the report.
			scenario.embed(screenshot, "image/png");
		}
	}

	@Given("^login by user is \"([^\"]*)\" and password is \"([^\"]*)\"$")
	public void login_by_user_is_and_password_is(String user, String password) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[1]/div[2]/div/div[1]/input"))
				.sendKeys(user);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div[2]/div/div[1]/input"))
				.sendKeys(password);
	}

	@When("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/button")).click();
	}

	@Then("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		Thread.sleep(1000);
		String url = "http://localhost:3000/app/home";
		String get_url = driver.getCurrentUrl();
		assertEquals(url, get_url);
	}

	@When("^user click on create appointment button$")
	public void user_click_on_create_appointment_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div[2]/div/ul/ul/li[2]/a")).click();
	}

	@Then("^user is on createappointment page$")
	public void user_is_on_createappointment_page() throws Throwable {
		Thread.sleep(2000);
		String url = "http://localhost:3000/app/createappointment";
		String get_url = driver.getCurrentUrl();
		assertEquals(url, get_url);
	}

	@Given("^user input topic as \"([^\"]*)\"$")
	public void user_input_topic_as(String topic) throws Throwable {
		Thread.sleep(1000);
		ArrayList<WebElement> selects = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//*[contains(@id,'topic')]"));
		selects.get(0).click();
		selects.get(0)
				.findElement(By.xpath(
						"//*/div[@class=\"dx-item-content dx-list-item-content\"][contains(text(),'" + topic + "')]"))
				.click();
	}

	@Given("^user input date as \"([^\"]*)\"$")
	public void user_input_date_as(String date) throws Throwable {
		WebElement dateInput = driver.findElement(By.xpath("//*[contains(@id,'operate_date')]"));
		;
		dateInput.clear();
		dateInput.sendKeys(date);
		dateInput.sendKeys(Keys.TAB);
	}

	@Given("^user input time as \"([^\"]*)\"$")
	public void user_input_time_as(String time) throws Throwable {
		ArrayList<WebElement> selects = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//*[contains(@id,'timing_period')]"));
		selects.get(0).click();
		selects.get(0)
				.findElement(By.xpath(
						"//*/div[@class=\"dx-item-content dx-list-item-content\"][contains(text(),'" + time + "')]"))
				.click();
	}

	@Given("^user input detail as \"([^\"]*)\"$")
	public void user_input_detail_as(String detail) throws Throwable {
		WebElement detailinput = driver.findElement(By.xpath("//*[contains(@id,'description')]"));
		detailinput.sendKeys(detail);
		detailinput.sendKeys(Keys.TAB);
	}

	@Given("^user input type of product as \"([^\"]*)\"$")
	public void user_input_type_of_product_as(String product) throws Throwable {

		ArrayList<WebElement> selects = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//*[contains(@id,'product_groups_id')]"));
		selects.get(0).sendKeys(product);
		Thread.sleep(1000);
		selects.get(0).sendKeys(Keys.ENTER);

	}

	@Given("^user input dealer as \"([^\"]*)\"$")
	public void user_input_dealer_as(String dealer) throws Throwable {
		driver.findElement(By.xpath("//*[contains(text(),'" + dealer + "')]")).click();
	}

	@Given("^user add file by \"([^\"]*)\" path$")
	public void user_add_file_by_path(String path) throws Throwable {

		ArrayList<WebElement> selects = (ArrayList<WebElement>) driver.findElements(By.name("files[]"));

		selects.get(0).sendKeys(path);
	}

	@Given("^user input file to upload is \"([^\"]*)\"$")
	public void user_input_file_to_upload_is(String file) throws Throwable {
		driver.findElement(By.xpath("//*[contains(text(),'" + file + "')]")).click();
		Thread.sleep(5000);
	}

	@When("^user click appointment button$")
	public void user_click_appointment_button() throws Throwable {

	}

	@Then("^user click save button$")
	public void user_click_save_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^user click accept$")
	public void user_click_accept() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^user is  on loginpage$")
	public void user_is_on_loginpage() throws Throwable {

	}

}