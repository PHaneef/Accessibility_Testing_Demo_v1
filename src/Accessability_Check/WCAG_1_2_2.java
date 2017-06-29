//Author: Mohammad Haneef P
// Prakat Solutions
package Accessability_Check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WCAG_1_2_2 extends Functions {
	
	HashMap<String, String> content = new HashMap<String, String>();

	private static String idattribute = "id";
	private final String inputXpath = "//input[@type='text']";
	private final String checkboxXpath = "//input[@type='checkbox']";
	private final String radioXpath = "//input[@type='radio']";
	private final String pwdXpath = "//input[@type='password']";
	private final String fileXpath = "//input[@type='file']";
	public static HashMap<String, String> WCAG2_0_notmet = new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_met = new HashMap<String, String>();
	public static String labelid;
	public static String Summaryattribute = "summary";
	public static String labelXpath = "//form";
	public static String tableXpath = "//table";
	public static String VideoXpath = "//video";
	private final String tableHeaderXpath = "//th";
	private final String tableRowXpath = "//th";
	private final String roleAttribute = "role";
	private final String scopeAttribute = "scope";
	private final String headerAttribute = "header";
	private static String source = "src";
	private boolean isPresent;

	
	@BeforeTest
	public void loadproperties() throws Exception {
		loadproperties("WCAG2-0Guidelines");
	}
//1.2.2 Captions (Prerecorded)-- Audio Descriptions in one language
	@Test
	public void captions(){
		isPresent= false;
		 isPresent = dvr.findElements(By.xpath(VideoXpath)).size() > 0;
		 String captions_text = Prop.getProperty("Captionlang_text");
			String captions_description = Prop.getProperty("Captionlang_description");
			SoftAssert sa= new SoftAssert();
		 if(isPresent!=false){	
		try {
			
			WebElement videoElement = dvr.findElement(By.xpath(VideoXpath));
			List<WebElement> allvideoElements = videoElement.findElements(By.xpath("//track"));

			for (WebElement allvideoElement : allvideoElements) {
				String videoposter = videoElement.getAttribute("poster");	
			String captionsrc= allvideoElement.getAttribute(source);
			if(captionsrc.isEmpty()){
				Reporter.log(captions_text + "<br>" + captions_description);
				WCAG2_0_notmet.put(( videoposter), ("WCAG2.0 Guildeline is Not Met for Video Tag with name = "));

				//Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " Video Tag with name - " + videoposter);

			}
			else{
				String captionkind=allvideoElement.getAttribute("kind");
				if(captionkind.isEmpty()){
					//WCAG2_0_notmetcaptions.put(("Video Tag with name - " + videoposter), (captions_text + captions_description));
					WCAG2_0_notmet.put(( videoposter), ("WCAG2.0 Guildeline is Not Met for Video Tag with name = "));

					//Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " Video Tag with name - " + videoposter);
				}
				else{
				WCAG2_0_met.put((videoposter), ("WCAG2.0 Guildeline is Met for Video Tag with name = "));

			//	Reporter.log("WCAG2.0 Guildeline is Met" + "<br>" + " Video Tag with name - " + videoposter + " where captions source = " +captionsrc);
				}
			}
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}}
		 else{
			 throw new SkipException("Skipping this Test Case");
		 }int size=WCAG2_0_notmet.size();
			if (size>0){
		 Reporter.log(captions_text +"<br>"+ captions_description);
			for (Map.Entry<String, String> entry : WCAG2_0_notmet.entrySet()) {
			    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
			}
			sa.assertFalse(size>0);
			sa.assertAll();
			}
	}
}
