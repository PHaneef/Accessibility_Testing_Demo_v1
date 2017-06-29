//Author: Mohammad Haneef P
// Prakat Solutions
package Accessability_Check;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WCAG_2_4_2 extends Functions {
	
		private static String pagetitle = "title";
		
		
		@BeforeTest
		public void loadproperties() throws Exception {
			loadproperties("WCAG2-0Guidelines");
		}

		@Test
		public void titleattribute() {
			 String title_text = Prop.getProperty("title_attribute");
			 String title_text_description = Prop.getProperty("title_description");
		
String Title=dvr.getTitle();
String url = dvr.getCurrentUrl();
SoftAssert sa= new SoftAssert();
if(Title.isEmpty()||(Title.equalsIgnoreCase(url))){
	Reporter.log(title_text +title_text_description);
	Reporter.log("WCAG2.0 Guildeline is Not Met"+"<br>"	
			+ " For  URL - " + url);
	sa.assertFalse(Title.isEmpty()||(Title.equalsIgnoreCase(url)));
	sa.assertAll();
}/*
if(Title.equalsIgnoreCase(url)){
	Reporter.log(title_text +title_text_description);
	Reporter.log("WCAG2.0 Guildeline is Not Met"+"<br>"	
			+ " For  URL - " + url);
	
}*/
/*else{
	Reporter.log("WCAG2.0 Guildeline is Met"+"<br>"	
			+ " For  URL - " + url +"<br>" + "Title of the page is: "+Title);
}*/
	
	
}}
