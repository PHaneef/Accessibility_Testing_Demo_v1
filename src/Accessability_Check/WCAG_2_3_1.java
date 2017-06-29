package Accessability_Check;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WCAG_2_3_1 extends Functions{
	
	public static HashMap<String, String> WCAG2_0_notmet = new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_met = new HashMap<String, String>();
	
	public void loadproperties() throws Exception {
		loadproperties("WCAG2-0Guidelines");
	}
	
	@Test(priority=1)
	public void aprintguidelines(){
		String label_text = Prop.getProperty("flash_text");
		String label_description = Prop.getProperty("flash_text_description");
		Reporter.log(label_text + "<br>" + label_description);
	}
	@Test
	public void checkFlashingContent(){

		SoftAssert sa= new SoftAssert();
	
		try {
			if(dvr.getPageSource().contains("<blink>") || 

					dvr.getPageSource().contains("<marquee>")){
							
				Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
					+ " As the Website contains blink or marquee elements");	
				sa.assertFalse(dvr.getPageSource().contains("<blink>") || 

						dvr.getPageSource().contains("<marquee>"));
				sa.assertAll();
			}else {
				 throw new SkipException("Skipping this Test Case");
				//Reporter.log("WCAG2.0 Guideline is  Met"+"<br>"	
				//	+ " As the Website doesnot contain blink or marquee elements");	
			
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			
		}
}
	@Test(priority=1, description="Checking blink test interval")
	public void checkblinktext() {
			try {
				String alt_text="Error: Blink Text";
String alt_text_description="Description: Text Should not blink more than 3 times per second.";
SoftAssert sa= new SoftAssert();
List<WebElement> subNavLinks = dvr.findElements(By.tagName("script"));
	
for (WebElement subNavLink : subNavLinks) {



JavascriptExecutor js = (JavascriptExecutor) driver;  
Object scriptText = js.executeScript(
				"return arguments[0].innerHTML", subNavLink);
//System.out.println(scriptText);
//String[] alldata=scriptText.toString().split("setInterval");
String[] alldata2=scriptText.toString().split(";");
//String[] alldata1=alldata2.toString().split("blinker,");
//String[] alldata2=scriptText.toString().split(";");
String data=alldata2[0];
String[] alldata1=data.toString().split("blinker,");
String actdata=alldata1[1];
String[] alldata3=actdata.toString().split("\\)");
String actdata1=alldata3[0];
String output = actdata1.replaceAll("\\s+","");
int output1 = Integer.parseInt(output);
//System.out.println(output1);
if(output1<333){
	Reporter.log(alt_text+"<br>"+alt_text_description);
				Reporter.log("WCAG Guideline is not met as Website contains text that blinks more than 3 times per sec");
				sa.assertFalse(output1<333);
				sa.assertAll();
}
else{
			//	Reporter.log("WCAG Guideline is met as Website maynot have text that blinks or contains text that blinks less than 3 times per sec");
	 throw new SkipException("Skipping this Test Case");	
}
//Reporter.log(alldata);
}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}	
}
	
	
	
	@Test(priority=1, description="Checking blink image interval")
	public void checkcarousal() {
		
		
			String alt_text="2.3.1 Three Flashes or Below Threshold Level A";
			String alt_text_description="Web pages do not contain anything that flashes more than three times in any one second period, or the flash is below the general flash and red flash thresholds.";
			SoftAssert sa= new SoftAssert();
			WebElement subNavLinks;
			try {
				subNavLinks = dvr.findElement(By.xpath("//script[contains(@src,'carousel.js')]"));
				JavascriptExecutor js = (JavascriptExecutor) dvr;  
				Object scriptText = js.executeScript(
				    "return arguments[0].innerHTML", subNavLinks);
				String tst =subNavLinks.getAttribute("src");

				//System.out.println(tst);
				driver.get(tst);
	String alltext=driver.getPageSource();
	String[] secondstring=alltext.split("auto_slide_seconds = ");
	String[] actual=secondstring[1].split(";");
	int blink=Integer.parseInt(actual[0]);

	//System.out.println(blink);
				
				if(blink<333){
					WCAG2_0_notmet.put((tst), ("WCAG Guideline is not met as Website contains carousel image that blinks more than 3 times per sec For Image URL = "));
					//Reporter.log(alt_text+"<br>"+alt_text_description);
				//	Reporter.log("WCAG Guideline is not met as Website contains carousel image that blinks more than 3 times per sec");
					
				}
				/*else{
					Reporter.log("WCAG Guideline is met as Website maynot have carousel image that blinks or contains carousel image that blinks less than 3 times per sec");
					
				}*/
			} catch (Exception e) {
				 throw new SkipException("Skipping this Test Case");
				//System.out.println(e.getMessage());
			}
finally{
	int size=WCAG2_0_notmet.size();
	if (size>0){

			Reporter.log(alt_text +"<br>"+ alt_text_description);
			for (Map.Entry<String, String> entry : WCAG2_0_notmet.entrySet()) {
			    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
			}
			sa.assertFalse(size>0);
			sa.assertAll();
	}} 

	}	}