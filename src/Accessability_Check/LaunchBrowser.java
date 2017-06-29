package Accessability_Check;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import atu.testng.reports.ATUReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class LaunchBrowser extends Functions{
	//public static WebDriver driver;
	
	@Test
	public static void selectbrowser() {
		
		System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
			driver = new ChromeDriver();
			dvr = new EventFiringWebDriver(driver);	
			
		//	driver.navigate().to("https://alphagov.github.io/accessibility-tool-audit/test-cases.html");
			dvr.get("");
/// add the website address here
		//	driver.manage().window().maximize();
		
	}
}

