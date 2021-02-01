package runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/features/Vendor_Features",
		glue = { "Vendor_StepDef" }, 
		tags = {},
		plugin = { "pretty",
		"json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
		"html:target/cucumber-reports" }, monochrome = true)

public class Vendor_runner {
	

	@AfterClass
	public static void writeExtentReport()  {
		
		Reporter.loadXMLConfig(new File("config/report.xml"));

	}
}