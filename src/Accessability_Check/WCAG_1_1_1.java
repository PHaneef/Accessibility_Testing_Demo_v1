//Author: Mohammad Haneef P
// Prakat Solutions

package Accessability_Check;

import java.net.Socket;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class WCAG_1_1_1 extends Functions {

	HashMap<String, String> content = new HashMap<String, String>();

	private static String altAttribute = "alt";
	private static String srcAttribute = "src";
	private static String valueAttribute = "value";
	private static String imageXpath = "//img";
	private static String inputimgtitle = "title";
	private static String areaXpath = "//area";
	private static String hrefAttribute = "href";
	private final String objectXpath = "//object";
	private final String inputXpath = "//input[@type='image']";
	private final String appletXpath = "//applet";
	private final String submitXpath = "//input[@type='submit']";
	private final String ObjecttypeXpath = "//object[@type='image/gif']";
	public static HashMap<String, String> WCAG2_0_met1 = new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_notmet1= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_met2= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_notmet2= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_met3= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_notmet3= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_met4= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_notmet4= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_met5= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_notmet5= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_met6= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_notmet6= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_met7= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_notmet7= new HashMap<String, String>();

	
	private boolean isPresent;

	private boolean isPresent2;

	private boolean isPresent3;

	private boolean isPresent4;

	private boolean isPresent5;

	private boolean isPresent6;

	private boolean isPresent7;

	private boolean isPresent8;

	private boolean isPresent9;

	private boolean isPresent10;
		

	
	public WCAG_1_1_1() {

	}

	@BeforeTest
	public void loadproperties() throws Exception {
		loadproperties("WCAG2-0Guidelines");
		
	}
	
	
	@Test(priority=1)
		public void aaprintguideline(){
			String alt_text = Prop.getProperty("image_alttext");
			 String alt_text_description = Prop.getProperty("image_Description");
			 
			 Reporter.log(alt_text +"<br>"+ alt_text_description);
		}
	
	
	@Test(priority =2)
	public void alttext() {
		String alt_text = "Error: img element missing alt attribute.";
		 String alt_text_description = "Description: All img elements must have an alt attribute.";
		
		 boolean isPresent= false;
		 isPresent = dvr.findElements(By.xpath(imageXpath)).size() > 0;
		 SoftAssert sa= new SoftAssert();
		 //System.out.println(isPresent);
		 if(isPresent!=false){	
	
		 try {
				List<WebElement> subNavLinks = dvr.findElements(By.xpath(imageXpath));
				
			
					//	Reporter.log(alt_text +"<br>"+ alt_text_description);
			for (WebElement subNavLink : subNavLinks) {
				String altAttributeText = subNavLink.getAttribute(altAttribute);
				String srcAttributeText = subNavLink.getAttribute(srcAttribute);
				
				
				if (altAttributeText.isEmpty() || altAttributeText==null) {
					WCAG2_0_notmet1.put((srcAttributeText), ("WCAG2.0 Guideline is Not Met For Image URL - "));

					//Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
					//		+ " For Image URL - " + srcAttributeText);
					
				}

				else

				{
					WCAG2_0_met1.put(("Image URL - " + srcAttributeText), (alt_text + alt_text_description));
					
//Reporter.log("WCAG2.0 Guideline is Met"+"<br>"	
	//		+ " For Image URL - " + srcAttributeText);

				}
			}
			int size=WCAG2_0_notmet1.size();
			if (size>0){
			Reporter.log(alt_text +"<br>"+ alt_text_description);
			for (Map.Entry<String, String> entry : WCAG2_0_notmet1.entrySet()) {
			   
				Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
				
			}}
			sa.assertFalse(size>0);
			sa.assertAll();
		} catch (NoSuchElementException e) {
			
		} 
		 finally{
			 isPresent=false;
		 }}else {
			 throw new SkipException("Skipping this Test Case");
		 }
	
		 
		}
	
	// test case for input type image
		@Test(priority =3)
		public void alttextofinputimage() {
			isPresent3 = false;
			 isPresent3 = dvr.findElements(By.xpath(inputXpath)).size() > 0;
			 SoftAssert sa= new SoftAssert();
			 if(isPresent3!=false){	
		
			 try {
				String alt_text = "Error: Image used for input element is missing Alt text.";
				 String alt_text_description = "Description: input element with type of 'image' must have an alt attribute.";
					List<WebElement> subNavLinks = dvr.findElements(By.xpath(inputXpath));
					
				//Reporter.log(alt_text +"<br>"+ alt_text_description);
				for (WebElement subNavLink : subNavLinks) {
					String altAttributeText = subNavLink.getAttribute(altAttribute);
					String inputimg = subNavLink.getAttribute(inputimgtitle);
					String href=subNavLink.getAttribute("src");
					
					if (altAttributeText.isEmpty()) {
						WCAG2_0_notmet2.put((href), ("WCAG2.0 Guideline is Not Met For Input Image with src - "));

						
						//Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
						//		+ " For Input Image with Title - "+ inputimg );
						
					
						
					}

					else

					{
						WCAG2_0_met2.put(("Image URL - "), (alt_text + alt_text_description));

//Reporter.log("WCAG2.0 Guideline is Met"+"<br>"	
	//			+ " For Input Image - "+ inputimg + "  with alt text as " + altAttributeText);

					}}
				int size=WCAG2_0_notmet2.size();
				if (size>0){
				Reporter.log(alt_text +"<br>"+ alt_text_description);
					for (Map.Entry<String, String> entry : WCAG2_0_notmet2.entrySet()) {
					    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
					}
					sa.assertFalse(size>0);
					sa.assertAll();
					}}
				
			catch (NoSuchElementException e) {
				
			}
			 finally{
				 isPresent3=false;
			 }}	else{
				 throw new SkipException("Skipping this Test Case");
			 }
			
			

	
	
	}
		//test case for area
		@Test(priority=4)
		public void alttextarea() {
			 isPresent4 = false;
			 isPresent4 = dvr.findElements(By.xpath(areaXpath)).size() > 0;
			 SoftAssert sa= new SoftAssert();

			// System.out.println(isPresent);
			if(isPresent4!=false){	
				String alt_text = "Error: Imagemap area element missing alt attribute.";
				 String alt_text_description = "Description: area elements must contain a alt attribute.";
				
				//Reporter.log(alt_text + "<br>"+alt_text_description);
				
			 try {
						List<WebElement> subNavLinks = dvr.findElements(By.xpath(areaXpath));
		

				for (WebElement subNavLink : subNavLinks) {
					String altAttributeText = subNavLink.getAttribute(altAttribute);
					String hrefAttributeText = subNavLink.getAttribute(hrefAttribute);
					
					
					if (altAttributeText.isEmpty()) {
						WCAG2_0_notmet3.put((hrefAttributeText), ("WCAG2.0 Guideline is Not Met For Area - with Href = "));

						
						//Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
						//		+ " For Area - with Href = "+hrefAttributeText );
						
					}

					else

					{
						WCAG2_0_met3.put(("Area - " + hrefAttributeText), (alt_text + alt_text_description));

						
//Reporter.log("WCAG2.0 Guideline is Met"+"<br>"	
	//			 + " For Area - " + " where href = "+ hrefAttributeText);
					}
				}
				int size=WCAG2_0_notmet3.size();
				if (size>0){
				Reporter.log(alt_text +"<br>"+ alt_text_description);
				for (Map.Entry<String, String> entry : WCAG2_0_notmet3.entrySet()) {
				    Reporter.log((entry.getKey()+" : "+entry.getValue()));
				}
				sa.assertFalse(size>0);
				sa.assertAll();
				}
			 }catch (NoSuchElementException e) {
			
			 }finally{
				 isPresent=false;
			 }}
			 else{
				 throw new SkipException("Skipping this Test Case");
			 }
		}
		//test case for object that includes a long description
			@Test(priority=5)
			public void textforobject() {
				isPresent2 = false;
				 isPresent2 = driver.findElements(By.xpath(objectXpath)).size() > 0;
				 SoftAssert sa= new SoftAssert();
				 if(isPresent2!=false){	
				
				 try {
					String alt_text = "Error: object is missing long description that describe it.";
					 String alt_text_description = "Description: An object should include a long description that describes it.";
					 List <WebElement> alttexts=dvr.findElements(By.xpath(objectXpath));
					//Reporter.log(alt_text + "<br>"+alt_text_description);
					for (WebElement alttext : alttexts) {
						String objecttitle = alttext.getAttribute("title");
						String objectdata = alttext.getAttribute("data");
					String objecttext = alttext.getText();
					

									
						if (objecttext.isEmpty()) {
							WCAG2_0_notmet4.put((objectdata), ("WCAG 2.0 Guideline is Not Met For object with data = " ));

							
							//Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
							//		+ " For object - " +objecttitle);
							
						}

						else

						{
							WCAG2_0_met4.put(("Object with title - " + objecttitle), (alt_text + alt_text_description));

//Reporter.log("WCAG2.0 Guideline is Met"+"<br>"	
	//				 + " For object with title - " +objecttitle + " where  text = "+ objecttext);
						}}	
					int size=WCAG2_0_notmet4.size();
					if (size>0){
					Reporter.log(alt_text +"<br>"+ alt_text_description);
					for (Map.Entry<String, String> entry : WCAG2_0_notmet4.entrySet()) {
					    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
					}
					sa.assertFalse(size>0);
					sa.assertAll();
					}
				} catch (NoSuchElementException e) {
					
				}finally{
					 isPresent2=false;
				 }}else{
					 throw new SkipException("Skipping this Test Case");
				 }
			}
			
			//test case for An object includes non-text content with a text alternative
			@Test(priority=5)
			public void alttextforobject() {
				isPresent5 = false;
				 isPresent5 = driver.findElements(By.xpath(objectXpath)).size() > 0;
				 SoftAssert sa= new SoftAssert();
				 if(isPresent5!=false){	
				
				 try {
					String alt_text = "Error: object may be missing a text equivalent.";
					 String alt_text_description = "Description: object element must contain a text equivalent for the object in case the object can't be rendered.";
					
					WebElement objectElement = dvr.findElement(By.xpath(objectXpath));
					
					List <WebElement> alttexts=objectElement.findElements(By.xpath("//img"));
					//Reporter.log(alt_text + "<br>"+alt_text_description);
					for (WebElement alttext : alttexts) {
						String objectsrc = alttext.getAttribute(srcAttribute);
							
					String objectalttext = alttext.getAttribute(altAttribute);
					

									
						if (objectalttext.isEmpty()) {
							WCAG2_0_notmet5.put((objectsrc), (" WCAG 2.0 Guideline is Not Met For object where src = "));

							
							
							//Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
							//		+ " For object - " +objectsrc);
							
						}

						else

						{
							WCAG2_0_met5.put(("Object with title - " + objectsrc), (alt_text + alt_text_description));

						
//Reporter.log("WCAG2.0 Guideline is Met"+"<br>"	
	//				 + " For object with src - " +objectsrc + " where  text = "+ objectalttext);
						}
					}
					int size=WCAG2_0_notmet5.size();
					if (size>0){
					Reporter.log(alt_text +"<br>"+ alt_text_description);
					for (Map.Entry<String, String> entry : WCAG2_0_notmet5.entrySet()) {
					    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
					}
					sa.assertFalse(size>0);
					sa.assertAll();
					}}
				 catch (NoSuchElementException e) {
					
				}finally{
					 isPresent5=false;
				 }}else{
					 throw new SkipException("Skipping this Test Case");
				 }
			}		
			
			
			//test case for The image object has content that provides a brief description of the function of the image
			@Test(priority=5)
			public void imagetextforobject() {
				isPresent6 = false;
				 isPresent6 = driver.findElements(By.xpath(ObjecttypeXpath)).size() > 0;
				 SoftAssert sa= new SoftAssert();
				 if(isPresent6!=false){	
				
				 try {
					String alt_text = "Error: object with image may be missing a text equivalent.";
					 String alt_text_description = "Description: The image object has content that provides a brief description of the function of the image";
					

					List <WebElement> alttexts=dvr.findElements(By.xpath(ObjecttypeXpath));
					//Reporter.log(alt_text + "<br>"+alt_text_description);
					for (WebElement alttext : alttexts) {
						String objectdata = alttext.getAttribute("data");
							
					String objecttext = alttext.getText();
					

									
						if (objecttext.isEmpty()) {
							WCAG2_0_notmet6.put((objectdata), ("WCAG2.0 Guideline is Not Met for Object -where data = "));

							
						//	Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
							//		+ " For object with data- " +objectdata);
							
						}

						else

						{
							WCAG2_0_met6.put(("Object with data - " + objectdata), (alt_text + alt_text_description));

							
//Reporter.log("WCAG2.0 Guideline is Met"+"<br>"	
	//				 + " For object with data - " +objectdata + " where  text = "+ objecttext);
						}
					}
					int size=WCAG2_0_notmet6.size();
					if (size>0){
					Reporter.log(alt_text +"<br>"+ alt_text_description);
					for (Map.Entry<String, String> entry : WCAG2_0_notmet6.entrySet()) {
					    Reporter.log((entry.getKey()+" : "+entry.getValue()));
					}
					sa.assertFalse(size>0);
					sa.assertAll();}	}			
				catch (NoSuchElementException e) {
				
				}finally{
					 isPresent6=false;
				 }}
				 else{
					 throw new SkipException("Skipping this Test Case");
				 }
			}	
			
			
			
			
			
			
			
			
			
				//test case for applet
				@Test(priority=6)
				public void alttextforapplet() {
					isPresent7 = false;
					 isPresent7 = driver.findElements(By.xpath(appletXpath)).size() > 0;
					 SoftAssert sa= new SoftAssert();
					 if(isPresent7!=false){	
					
					try {
						String alt_text = "Error: applet may not contain a text equivalent in the alt attribute.";
						 String alt_text_description = "Use the alt attribute to label an applet.";
						

						List <WebElement> alttexts=dvr.findElements(By.xpath(appletXpath));
						
						for (WebElement alttext : alttexts) {
							String appletalttext = alttext.getAttribute(altAttribute);
							String applettext = alttext.getText();
						

										
							if (appletalttext.isEmpty()){
								Reporter.log(alt_text + "<br>"+alt_text_description);
												
								Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
										+ " For applet - ");
								sa.assertFalse(appletalttext.isEmpty());
								sa.assertAll();
							}

							else

							{
								
								
//Reporter.log("WCAG2.0 Guideline is Met"+"<br>"	
	//					 + " For applet with alttext - " +appletalttext);
							}
						}
					} catch (NoSuchElementException e) {
						
					}finally{
						 isPresent7=false;
					 }}else{
						 throw new SkipException("Skipping this Test Case");
					 }
						}
				
					//test case for applet get text
					@Test(priority=7)
					public void textforapplet() {
						isPresent8 = false;
						 isPresent8 = driver.findElements(By.xpath(appletXpath)).size() > 0;
						 SoftAssert sa= new SoftAssert();
						 isPresent7=false;
					 
						 if(isPresent8!=false){	
						
						try {
							String alt_text = "Error: applet body may not contain a text equivalent.";
							 String alt_text_description = "applet should contain a text equivalent in the body of the applet";
							
							List <WebElement> alttexts=dvr.findElements(By.xpath(appletXpath));
							
							for (WebElement alttext : alttexts) {
								String applettext = alttext.getText();
													
											
								if (applettext.isEmpty()) {
									
									Reporter.log(alt_text + "<br>"+alt_text_description);
									Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
											+ " For applet - ");
									sa.assertFalse(applettext.isEmpty());
									sa.assertAll();
								}

								else

								{
									
								
//Reporter.log("WCAG2.0 Guideline is Met"+"<br>"	
	//						 + " For applet with alttext - " +applettext);
								}
							}
						} catch (NoSuchElementException e) {
							
							e.printStackTrace();
						}finally{
							 isPresent8=false;
						 }}else{
							 throw new SkipException("Skipping this Test Case");
						 }
}
					


					/*//test case for area linktext
					@Test(priority=8)
					public void linktextarea() {
						 String alt_text = "Error: Alt text for area element may not identify the link destination.";
						 String alt_text_description = "Description: Alt text for area element must describe the link destination.";
						System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
						WebDriver driver = new ChromeDriver();
						driver.get("file:///C:/Users/Prakat-Admin/Desktop/sample%20codes%20used%20for%20testing/arealinktext.html");

						List<WebElement> subNavLinks = driver.findElements(By.xpath(areaXpath));
						
					
						Reporter.log(alt_text + "<br>"+alt_text_description);
						for (WebElement subNavLink : subNavLinks) {
							String altAttributeText = subNavLink.getAttribute(altAttribute);
							String hrefAttributeText = subNavLink.getAttribute(hrefAttribute);
							
							
							if (altAttributeText.isEmpty()) {
								WCAG2_0_notmetarea.put(("Area - " + hrefAttributeText), (alt_text + alt_text_description));

								//Reporter.log(alt_text + "\n" + alt_text_description + "\n" + "WCAG2.0 Guideline is Not Met");

								//Reporter.log(alt_text +"<br>"+ alt_text_description +"<br>"+ "WCAG2.0 Guideline is Not Met"+"<br>"
								//		+ "For Image URL - " + srcAttributeText);
								
								Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
										+ " For Area - " );
								
							}

							else{
								String [] hreflist =hrefAttributeText.split(".");
								
								if(hreflist[0].contains(hrefAttributeText)){
								
								WCAG2_0_metarea.put(("Area - " + hrefAttributeText), (alt_text + alt_text_description));

								//Reporter.log(alt_text + "\n" + alt_text_description + "\n" + "WCAG2.0 Guideline is Met");
								//Reporter.log(alt_text+ "<br>"+ alt_text_description +"<br>" +"WCAG2.0 Guideline is Met"+"<br>"	
								//		+ " For Image URL - " + srcAttributeText);
					Reporter.log("WCAG2.0 Guideline is Met"+"<br>"	
						 + " For Area - " + " where href = "+ hrefAttributeText);
							}
								else{WCAG2_0_notmetarea.put(("Area - " + hrefAttributeText), (alt_text + alt_text_description));

								//Reporter.log(alt_text + "\n" + alt_text_description + "\n" + "WCAG2.0 Guideline is Not Met");

								//Reporter.log(alt_text +"<br>"+ alt_text_description +"<br>"+ "WCAG2.0 Guideline is Not Met"+"<br>"
								//		+ "For Image URL - " + srcAttributeText);
								
								Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
										+ " For Area - " );
								}
						}
					}
				}

					//test case for embed tag
					@Test(priority=8)
					public void embedtag() {
						 String alt_text = "Error: embed element missing noembed element.";
						 String alt_text_description = "Description: Provide a text equivalent for the embed element.";
						System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
						WebDriver driver = new ChromeDriver();
						driver.get("file:///C:/Users/Prakat-Admin/Desktop/sample%20codes%20used%20for%20testing/embed.html");

						if(driver.getPageSource().contains("<embed") &&
								driver.getPageSource().contains("<noembed>")){
									
								Reporter.log("WCAG2.0 Guideline is Met"+"<br>"	
										+ " For embed Tag " );
								
							

								
						}		
								else{
													
								Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
										+ " For embed Tag " );
								}
						
					}*/
					//check input type = submit
					@Test(priority =2)
					public void submitalttext() {
						isPresent9 = false;
						 isPresent9 = driver.findElements(By.xpath(submitXpath)).size() > 0;
						 SoftAssert sa= new SoftAssert();
						 if(isPresent9!=false){	
						
						 try {
							String alt_text = "Error: only input type image should have alt text.";
							 String alt_text_description = "Description: input element should not have alt attribute for input type = submit.";
							

							List<WebElement> subNavLinks = dvr.findElements(By.xpath(submitXpath));
							

							
							for (WebElement subNavLink : subNavLinks) {
								String altAttributeText = subNavLink.getAttribute(altAttribute);
								String valueAttributeText = subNavLink.getAttribute(valueAttribute);
								
								
								if (altAttributeText.isEmpty()) {
								
//Reporter.log("WCAG2.0 Guideline is Met"+"<br>"	
	//						+ " For input type = Submit" + " where value = "+valueAttributeText );
								}

								else

								{
									
									Reporter.log(alt_text +"<br>"+ alt_text_description);
Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
								+ " For input type = Submit " + " where value = "+valueAttributeText);
sa.assertFalse(altAttributeText.length()>0);
sa.assertAll();
								}

							}
						} catch (NoSuchElementException e) {
						
						}finally{
							 isPresent9=false;
						 }}else{
							 throw new SkipException("Skipping this Test Case");
						 }
						}


					
					
					@Test(priority =2)
					public void decorativeimagetest() {
						isPresent10 = false;
						 isPresent10 = driver.findElements(By.xpath(imageXpath)).size() > 0;
						 SoftAssert sa= new SoftAssert();
						 if(isPresent10!=false){	
						
						try {
							String alt_text = "Error: Decorative images should contain null alt text and no title attribute.";
							 String alt_text_description = "Description: Using null alt text and no title attribute on img elements for images that AT should ignore.";
							
							List<WebElement> subNavLinks = dvr.findElements(By.xpath(imageXpath));
							

							//Reporter.log(alt_text +"<br>"+ alt_text_description);
							for (WebElement subNavLink : subNavLinks) {
								
								String srcAttributeText = subNavLink.getAttribute(srcAttribute);
								
								
									String altAttributeText = subNavLink.getAttribute(altAttribute);	
									String isPresent1 = subNavLink.getAttribute(inputimgtitle);
								
								if (altAttributeText.isEmpty() && (isPresent1.isEmpty())){
									
									if (srcAttributeText.endsWith(".gif")){
									WCAG2_0_met7.put(("Image URL - " + srcAttributeText), (alt_text + alt_text_description));

								
//Reporter.log("WCAG2.0 Guideline is Met"+"<br>"	
	//						+ " For Decorative Image URL - " + srcAttributeText);	
									
									}
									else{
										
									}
								}
								else

								{
							
WCAG2_0_notmet7.put((srcAttributeText), ("WCAG2.0 Guideline is Not Met for Image URL where src = "));


//Reporter.log("WCAG2.0 Guideline is Not Met"+"<br>"	
	//							+ " For Decorative Image URL - " + srcAttributeText);
								}
							}
							int size=WCAG2_0_notmet7.size();
							if (size>0){
							Reporter.log(alt_text +"<br>"+ alt_text_description);
							for (Map.Entry<String, String> entry : WCAG2_0_notmet7.entrySet()) {
							    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
							}
							sa.assertFalse(size>0);
							sa.assertAll();
							}}
						catch (NoSuchElementException e) {
						
						}finally{
							 isPresent10=false;
						 }}else{
							 throw new SkipException("Skipping this Test Case");
						 }
					}

					
					

}