package Vendor_StepDef;

import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Vendor {
	public static WebDriver driver;
	//public static Scenario scenario;
	
	
	
	@After
	public void tearDown(Scenario scenario)  {
		if (scenario.isFailed()) {
			// Take a screenshot...
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// embed it in the report.
			scenario.embed(screenshot, "image/png");

		}
	}
	
	
	
	@Given("^user is on \"([^\"]*)\" website$")
	public void user_is_on_website(String website) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(website);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^login by user is \"([^\"]*)\" and password is \"([^\"]*)\"$")
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
		dateInput.clear();
		dateInput.sendKeys(date);
		dateInput.sendKeys(Keys.TAB);
		Thread.sleep(1000);
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
		Thread.sleep(5000);
		selects.get(0).sendKeys(Keys.ENTER);

	}

	@Given("^user input dealer as \"([^\"]*)\"$")
	public void user_input_dealer_as(String dealer) throws Throwable {
		driver.findElement(By.xpath("//*[contains(text(),'" + dealer + "')]")).click();
	}

	@Given("^user add file by \"([^\"]*)\" path$")
	public void user_add_file_by_path(String path) throws Throwable {

		ArrayList<WebElement> selects = (ArrayList<WebElement>) driver.findElements(By.name("files[]"));
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		selects.get(0).sendKeys(s+path);
	}

	@Given("^user input file to upload is \"([^\"]*)\"$")
	public void user_input_file_to_upload_is(String file) throws Throwable {
		driver.findElement(By.xpath("//*[contains(text(),'" + file + "')]")).click();
		Thread.sleep(2000);
	}

	@Given("^user click accept on createappointment page$")
	public void user_click_accept_on_createappointment_page() throws Throwable {
		driver.findElement(By
				.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/div[2]/div/div/div[1]/div[2]/div/span/span[1]/input"))
				.click();
	}

	@When("^user click appointment button$")
	public void user_click_appointment_button() throws Throwable {
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div/div/div/div/div[2]/div/div/div[1]/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[3]/div/div/div/div"))
				.click();

	}

	@Then("^user click save button$")
	public void user_click_save_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/button")).sendKeys(Keys.ENTER);

	}
	
	@Then("^website has a pop up as \"([^\"]*)\"$")
	public void has_a_pop_up_as(String massage) throws Throwable {
		WebElement popup = driver.findElement(By.xpath("//*[@id=\"client-snackbar\"]"));
		String txt_popup = popup.getText();
		assertEquals(massage,txt_popup);
		
		
	}
	
	@When("^user refresh$")
	public void user_refresh() throws Throwable {
		driver.navigate().refresh();
	}

}