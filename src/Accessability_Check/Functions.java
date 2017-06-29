package Accessability_Check;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions {

	public static WebDriver driver = null;
	public static EventFiringWebDriver dvr = null;
	public static Properties Prop = new Properties();
	public static int MaxWaitSeconds = 2000;
	public static void loadproperties(String filename) throws Exception {
		String CurrentDir = System.getProperty("user.dir");

		FileInputStream ip = new FileInputStream(CurrentDir+ "\\src\\" + filename + ".properties");
		Prop.load(ip);

	}

	public static void selectbrowser(String browser, String website) {
		String txt = Prop.getProperty(browser);
		if (txt.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "d:\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(Prop.getProperty("website"));
			dvr = new EventFiringWebDriver(driver);
		} else if (txt.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(Prop.getProperty("website"));
			dvr = new EventFiringWebDriver(driver);
		} else if (txt.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "d:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(Prop.getProperty("website"));
			dvr = new EventFiringWebDriver(driver);
		}
	}
	public static void click(String locator) {

		try {
			dvr.findElement(By.xpath(Prop.getProperty(locator))).click();
		} catch (Exception e) {
			System.out.println("was not able to find through xpath of click");
		}
	}

	public static void sendkeys(String locator, String input) {
		try {
			dvr.findElement(By.xpath(Prop.getProperty(locator))).sendKeys(Prop.getProperty(input));
		}

		catch (Exception e) {
			System.out.println("was not able to find through xpath of sendkeys");
		}
	}
	
	public static void mouseclick(String locator){
		try {
			WebElement x1 = dvr.findElement(By.xpath(Prop.getProperty(locator)));
			Actions act = new Actions(dvr);
			act.moveToElement(x1).click().build().perform();
		} catch (Exception e) {
			System.out.println("Mouse click did not work");
			}
		
	}

	public static void dropdown(String locator, String input) {
		try {
			Select dropdown = new Select(dvr.findElement(By.xpath("locator")));
			dropdown.selectByVisibleText(input);
		}

		catch (Exception e) {
			System.out.println("was not able to find through xpath of dropdown");
		}
	}

	public static void checkbox(String locator) {
		try {
			dvr.findElement(By.xpath(Prop.getProperty(locator))).click();
		} catch (Exception e) {
			System.out.println("was not able to find through xpath of Checkbox");
		}
	}

	public static void explicitwait(String locator) {
		WebDriverWait wait = new WebDriverWait(dvr, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Prop.getProperty(locator))));
	}
	
	public static void clear(String locator){
		try {
			dvr.findElement(By.xpath(Prop.getProperty(locator))).clear();
		} catch (Exception e) {
		System.out.println("Clear did not work");
		}
	}
	
	public static String geturl(){
		String url=dvr.getCurrentUrl();
		return url;
	}
	
	public static void getheadertext(){
	//	ArrayList list = new ArrayList();
		String header=dvr.findElement(By.tagName("h1")).getText();
		System.out.println(header);
			}

}