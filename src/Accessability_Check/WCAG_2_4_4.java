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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

	public class WCAG_2_4_4 extends Functions {
		HashMap<String, String> content = new HashMap<String, String>();

		private static String altAttribute = "alt";

		private static String srcAttribute = "src";
		private static String imageXpath = "//img";
		private static String areaXpath = "//area";
		private static String hrefAttribute = "href";
		private static String ariaattribute = "aria-label";
		private static String inputimgtitle = "title";
		private final String inputXpath = "//input[@type='image']";
		private final String navXpath = "//*[@role='navigation']";
		private final String regionXpath = "//*[@role='region']";
		private final String anchorXpath = "//a";
		private final String anchorimgXpath = "//a//img";
		private final String objectXpath = "//object";
		public static HashMap<String, String> WCAG2_0_notmetobject = new HashMap<String, String>();
		public static HashMap<String, String> WCAG2_0_metobject = new HashMap<String, String>();

		@BeforeTest
		public void loadproperties() throws Exception {
			loadproperties("WCAG2-0Guidelines");
		}

		@Test
		public void alttextforanchortag() {
			
			String alt_text = Prop.getProperty("anchor_text");
			String alt_text_description = Prop.getProperty("anchor_description");
			SoftAssert sa= new SoftAssert();
			try {
			
				
				WebElement AnchorElements = dvr.findElement(By.xpath(anchorXpath));
				
				List<WebElement> AnchortxElements = dvr.findElements(By.xpath(anchorXpath));
				
				ArrayList<String> anchor = new ArrayList<String>();
for(WebElement AnchortxElement:AnchortxElements){
				String anchref1 = AnchortxElement.getAttribute(hrefAttribute);

				String anchortext = AnchortxElement.getText();
				anchor.add(anchortext);
				if(anchortext.isEmpty()){
					List<WebElement> AnchorimgElements = AnchorElements.findElements(By.xpath(anchorimgXpath));
					for(WebElement AnchorimgElement:AnchorimgElements){
					String ancsrc = AnchorimgElement.getAttribute(srcAttribute);
					String anctext1 = AnchorimgElement.getAttribute(altAttribute);
					String anchref2 = AnchorimgElement.getAttribute(hrefAttribute);
					if (anctext1.isEmpty()){
						String anchortextt = AnchorimgElement.getText();
						if(anchor.contains(anchortextt)){
						
						}else{
		WCAG2_0_notmetobject.put((anchref2), ("WCAG2.0 Guildeline is Not Met For Anchor Tag with href = "));

						//Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Anchor Tag with href - " + anchref2);

					}
					}
					else{
						WCAG2_0_metobject.put((anctext1), ("WCAG2.0 Guildeline is Met For Anchor Tag with src = " + ancsrc
								+ " where  alt text = "));

					//	Reporter.log("WCAG2.0 Guildeline is Met" + "<br>" + " For Anchor Tag with src - " + ancsrc
						//		+ " where  alt text = " + anctext1);
					}
					}}
					else{
					
							WCAG2_0_metobject.put((anchortext), ("WCAG2.0 Guildeline is Met For Anchor Tag with href = " + anchref1
									+ " where  anchor text = "));
						
					
						//Reporter.log("WCAG2.0 Guildeline is Met" + "<br>" + " For Anchor Tag with href - " + anchref1
						//		+ " where  anchor text = " + anchortext);
					}
					}
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
			}
			int size=WCAG2_0_notmetobject.size();
			if (size>0){

					Reporter.log(alt_text +"<br>"+ alt_text_description);
					for (Map.Entry<String, String> entry : WCAG2_0_notmetobject.entrySet()) {
					    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
					}
					sa.assertFalse(size>0);
					sa.assertAll();
		}}
	}
		
			