//Author: Mohammad Haneef P
// Prakat Solutions
package Accessability_Check;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(value=Ireporters.class)

public class WCAG_3_1_1 extends Functions {

	private static String langAttribute = "lang";
	private static String htmlXpath = "//html";
	
	public static HashMap<String, String> WCAG2_0_notmet = new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_met = new HashMap<String, String>();
 
	public WCAG_3_1_1() {
	}

	@BeforeTest
	public void loadproperties() throws Exception {
		loadproperties("WCAG2-0Guidelines");
	}

	@Test(priority=1, description="Checking lang attribute in the website")
	public void langattribute() {
		SoftAssert sa= new SoftAssert();
		try {
			WebElement element = dvr.findElement(By.xpath(htmlXpath));
String s=element.getAttribute("innerHTML");
System.out.println(s);
			String titleText = element.getAttribute(langAttribute);
			String alt1=Prop.getProperty("lang_attribute");
			String alt2=Prop.getProperty("lang_Description");
			if (titleText.isEmpty()) {
				//WCAG2_0_notmet.put("No Data",(alt1+alt2));
							
				//System.out.println(alt1+"\n"+alt2+"\n"+"WCAG2.0 Guildeline is Not Met");
				Reporter.log(alt1+"<br>"+alt2+"<br>"+"WCAG2.0 Guildeline is Not Met");
				sa.assertFalse(titleText.isEmpty());
				sa.assertAll();		
			} else {
				WCAG2_0_met.put("No Data",(alt1+alt2));
			//	System.out.println(alt1+"\n"+alt2+"\n"+"WCAG2.0 Guildeline is Met");
			//	Reporter.log(alt1+"<br>"+alt2+"<br>"+"WCAG2.0 Guildeline is Met");	
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		
		
}
		
	}
	
