package Accessability_Check;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WCAG_3_2_2 extends Functions{
	public static String labelXpath = "//label";
	public static String formXpath = "//form";
	public static HashMap<String, String> WCAG2_0_met1 = new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_notmet1= new HashMap<String, String>();
	@Test
	
	public void labeltext(){
		String labeltext;
		System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//dvr = new EventFiringWebDriver(driver);	
		
	//	driver.navigate().to("https://alphagov.github.io/accessibility-tool-audit/test-cases.html");
		driver.get("https://alphagov.github.io/accessibility-tool-audit/test-cases.html#forms");
		boolean isPresent1=false;
		isPresent1 = driver.findElements(By.xpath(formXpath)).size() > 0;
		String label_text = "Error: 3.3.2 Labels or Instructions Level A";
		String label_description = "Description: Labels or instructions are provided when content requires user input.";
		SoftAssert sa= new SoftAssert();
		if(isPresent1!=false){	
			
		
		
				List<WebElement> subNavLinks = driver.findElements(By.xpath(formXpath));
			for(int i=0;i<subNavLinks.size();i++){
			String text=subNavLinks.get(i).getText();
			String classname=subNavLinks.get(i).getAttribute("class");
		
			if (text.contains("name")){
				boolean fail=text.contains("First")&&(text.contains("Last"));	
				if(text.contains("First")&&(text.contains("Last"))){
					//Reporter.log(label_text + "\n" + label_description + "\n" +
					//		 "WCAG2.0 Guildeline is  Met");
					}

					else

					{
						WCAG2_0_notmet1.put((classname),("form contains Name, but doesnot contain First and Last where class ="));

					// Reporter.log(label_text + "\n" + label_description + "\n" +"<br>"+
						// "WCAG2.0 Guildeline is not Met");
					 sa.assertFalse(fail);
					 sa.assertAll();
						// Reporter.log(alt_text+ "<br>"+ alt_text_description +"<br>"
						// +"WCAG2.0 Guildeline is Met"+"<br>"
						// + " For Image URL - " + srcAttributeText);
					//	Reporter.log("WCAG2.0 Guildeline is Met" + "<br>" + " For Input element with id - " + labelid
						//		+ " where the label text is " + labeltext);

					
				}}
		}
			Reporter.log(label_text + "<br>" + label_description);
			for (Map.Entry<String, String> entry : WCAG2_0_notmet1.entrySet()) {
			    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));}
		}}}
				
				//System.out.println(labelxpath);
				//Reporter.log(label_text + "<br>" + label_description);
				// for (WebElement subNavLink : subNavLinks) {
				
				
				
				
		/*	}
			//int size=WCAG2_0_notmet1.size();
			//if (size>0){
			
				
			
			finally{
				 isPresent1=false;
			}}
			else{
				 throw new SkipException("Skipping this Test Case");
			}
			
			Reporter.log(label_text +"<br>"+ label_description);
			for (Map.Entry<String, String> entry : WCAG2_0_notmet1.entrySet()) {
			    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
			}
			sa.assertFalse(WCAG2_0_notmet1.size()>0);
			sa.assertAll();		
	}*/
		

