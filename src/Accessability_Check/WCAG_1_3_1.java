//Author: Mohammad Haneef P
// Prakat Solutions
package Accessability_Check;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class WCAG_1_3_1 extends Functions {
	HashMap<String, String> content = new HashMap<String, String>();

	private static String idattribute = "id";
	private final String inputXpath = "//input[@type='text']";
	private final String checkboxXpath = "//input[@type='checkbox']";
	private final String radioXpath = "//input[@type='radio']";
	private final String pwdXpath = "//input[@type='password']";
	private final String fileXpath = "//input[@type='file']";
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
	public static HashMap<String, String> WCAG2_0_met8= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_notmet8= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_met9= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_notmet9= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_met10= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_notmet10= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_met11= new HashMap<String, String>();
	public static HashMap<String, String> WCAG2_0_notmet11= new HashMap<String, String>();

	public static String labelid;
	public static String Summaryattribute="summary";
	public static String labelXpath = "//form";
	public static String tableXpath = "//table";
	private final String tableHeaderXpath = "//th";
	private final String tableRowXpath = "//th";
	private final String roleAttribute = "role";
	private final String scopeAttribute = "scope";
	private final String headerAttribute = "header";
	public static String selectXpath = "//select";
	private boolean isPresent1;

	private boolean isPresent2 ;

	private boolean isPresent3;

	private boolean isPresent4;

	private boolean isPresent5;

	private boolean isPresent6;

	private boolean isPresent7;

	private boolean isPresent8;

	private boolean isPresent9;

	private boolean isPresent10;
	
	private boolean isPresent11;
	
	@BeforeTest
	public void loadproperties() throws Exception {
		loadproperties("WCAG2-0Guidelines");
	}
	
	@Test(priority=1)
	public void aaprintguidelines(){
		
		
		String label_text = Prop.getProperty("label_text");
		String label_description = Prop.getProperty("label_description");
		Reporter.log(label_text + "<br>" + label_description);
	}

	@Test(priority=2)
	public void labeltext(){
		String labeltext;
		boolean isPresent1=false;
		isPresent1 = driver.findElements(By.xpath(inputXpath)).size() > 0;
		String label_text = "Error: input element, type of 'text', has no text in label.";
		String label_description = "Description: input element that contains a type attribute value of 'text' must have text in its associated label.";
		SoftAssert sa= new SoftAssert();
		if(isPresent1!=false){	
			
		
		
				List<WebElement> subNavLinks = dvr.findElements(By.xpath(inputXpath));
			
			

			for (WebElement subNavLink : subNavLinks) {
				labelid = subNavLink.getAttribute(idattribute);
			
			if (labelid.isEmpty()){
					String name= subNavLink.getAttribute("name");
					WCAG2_0_notmet1.put((name), ("WCAG2.0 Guildeline is Not Met For Input element with name =" ));

				}
				else{
				String labelxpath = "//*[@for='" + labelid + "']";
				
			
				try{
					labeltext = dvr.findElement(By.xpath(labelxpath)).getText();
					if (labeltext.isEmpty()) {
						WCAG2_0_notmet1.put((labeltext), ("WCAG2.0 Guildeline is Not Met For Input element with id =" ));

						// Reporter.log(alt_text + "\n" + alt_text_description + "\n" +
						// "WCAG2.0 Guildeline is Not Met");

						// Reporter.log(alt_text +"<br>"+ alt_text_description +"<br>"+
						// "WCAG2.0 Guildeline is Not Met"+"<br>"
						// + "For Image URL - " + srcAttributeText);

						//Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Input element with id - " + labelid);

					}

					else

					{
						WCAG2_0_met1.put(("Input element with id " + labeltext), (label_text + label_description));

						// Reporter.log(alt_text + "\n" + alt_text_description + "\n" +
						// "WCAG2.0 Guildeline is Met");
						// Reporter.log(alt_text+ "<br>"+ alt_text_description +"<br>"
						// +"WCAG2.0 Guildeline is Met"+"<br>"
						// + " For Image URL - " + srcAttributeText);
					//	Reporter.log("WCAG2.0 Guildeline is Met" + "<br>" + " For Input element with id - " + labelid
						//		+ " where the label text is " + labeltext);

					}
				}catch (Exception e) {
					String name= subNavLink.getAttribute("name");
					WCAG2_0_notmet1.put((name), ("WCAG2.0 Guildeline is Not Met For Input element with name =" ));

				}
				
				//System.out.println(labelxpath);
				//Reporter.log(label_text + "<br>" + label_description);
				// for (WebElement subNavLink : subNavLinks) {
				
				
				
				
			}
			//int size=WCAG2_0_notmet1.size();
			//if (size>0){
			
				
			
			/*finally{
				 isPresent1=false;*/
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
	}
		
		
		
	

	////////////fieldset for radio buuton
	@Test(priority=3)
	public void Radiolabelfieldset() {
		isPresent2=false;
		isPresent2 = driver.findElements(By.xpath(labelXpath)).size() > 0;
		SoftAssert sa= new SoftAssert();
		if(isPresent2!=false){	
		
		try {
			String label_text = "Erorr: Form missing fieldset and legend to group multiple radio buttons.";
			String label_description = "Description: Form element content must contain both fieldset and legend elements if there are related radio buttons.";

			WebElement formElement = dvr.findElement(By.xpath(labelXpath));
			List<WebElement> allFormElements = formElement.findElements(By.xpath("//form//fieldset"));
			
			List<WebElement> allradioElements = formElement.findElements(By.xpath(radioXpath));
			List namelist= new ArrayList<>();
			for (WebElement allradioElement : allradioElements) {
				
				namelist.add(allradioElement.getAttribute("name"));}
				if(namelist.get(0).equals(namelist.get(1))){
					
				
			//Reporter.log(label_text + "<br>" + label_description);
			if(allFormElements.isEmpty()){
				String actiontext =formElement.getAttribute("action");
				WCAG2_0_notmet2.put((actiontext), ("WCAG2.0 Guildeline is Not Met for Form which doesnot contain Fieldset where Action =" ));

			//	Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " Form doesnot contain Fieldset  where Action = "
				//		+ actiontext);	
			}
			else{
			for (WebElement allFormElement : allFormElements) {
				Boolean s = allFormElement.getTagName().contains("fieldset");

				String actiontext = allFormElement.getAttribute("action");
				if (s.equals(true)) {
					String legendtext = allFormElement.findElement(By.xpath("//legend")).getText();
					WCAG2_0_met2.put(("Form contains Fieldset  with legend = " + legendtext),
							(label_text + label_description));

				//	Reporter.log(
				//			"WCAG2.0 Guildeline is Met" + "<br>" + " Form contains Fieldset  with legend = " + legendtext);

				}

				else{
					
				}

					

				}
			}
				}
				else{
					
				}
				int size=WCAG2_0_notmet2.size();
				if (size>0){
				Reporter.log(label_text +"<br>"+ label_description);
				for (Map.Entry<String, String> entry : WCAG2_0_notmet2.entrySet()) {
				    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
				}
				sa.assertFalse(size>0);
				sa.assertAll();
				}
		} catch (NoSuchElementException e) {
			
		}finally{
			 isPresent2=false;}
		}
		else{
			 throw new SkipException("Skipping this Test Case");
		}
		
	}
/////input element has associated label for check box
	@Test(priority=4)
	public void checkboxlabel()  {
		isPresent3=false;
		isPresent3 = driver.findElements(By.xpath(checkboxXpath)).size() > 0;
		
		SoftAssert sa= new SoftAssert();
		if(isPresent3!=false){	
			
		
			String label_text = "Error: Input element, type of 'checkbox', missing an associated label.";
			String label_description = "Description: input element that contains a type attribute value of 'checkbox'"
					+ " must have an associated label element. An associated label is one in which the for attribute value of the label element is the same as the id attribute value of the input element.";
			//Reporter.log(label_text + "<br>" + label_description);
			List<WebElement> subNavLinks = dvr.findElements(By.xpath(checkboxXpath));

			for (WebElement subNavLink : subNavLinks) {
				labelid = subNavLink.getAttribute(idattribute);
				if(labelid.isEmpty()){
					String labelname =subNavLink.getAttribute("name");
					WCAG2_0_notmet3.put((labelname), ("WCAG2.0 Guildeline is Not Met For Input element of type checkbox with name ="));
					
				//	Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Input element of type checkbox with name - " + labelname);

				}
				else{
					
				String labelxpath = "//*[@for='" + labelid + "']";
				
				String labeltext;
				try {
					labeltext = dvr.findElement(By.xpath(labelxpath)).getText();
					if (labeltext.isEmpty()) {
						WCAG2_0_notmet3.put((labelid), ("WCAG2.0 Guildeline is Not Met For Input element of type checkbox with name ="));
						
						// Reporter.log(alt_text + "\n" + alt_text_description + "\n" +
						// "WCAG2.0 Guildeline is Not Met");

						// Reporter.log(alt_text +"<br>"+ alt_text_description +"<br>"+
						// "WCAG2.0 Guildeline is Not Met"+"<br>"
						// + "For Image URL - " + srcAttributeText);

					//	Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Input element of type checkbox with id - " + labelid);

					}

					else

					{
						WCAG2_0_met3.put(("Input element of type checkbox with id " + labeltext), (label_text + label_description));

						// Reporter.log(alt_text + "\n" + alt_text_description + "\n" +
						// "WCAG2.0 Guildeline is Met");
						// Reporter.log(alt_text+ "<br>"+ alt_text_description +"<br>"
						// +"WCAG2.0 Guildeline is Met"+"<br>"
						// + " For Image URL - " + srcAttributeText);
						//Reporter.log("WCAG2.0 Guildeline is Met" + "<br>" + " For Input element of type checkbox with id - " + labelid
					//			+ " where the label text is : " + labeltext);

					}
				}
				catch (Exception e){
					WCAG2_0_notmet3.put((labelid), ("WCAG2.0 Guildeline is Not Met For Input element of type checkbox with name ="));
				//System.out.println(labelxpath);
				
				// for (WebElement subNavLink : subNavLinks) {

				

			}}}
			int size=WCAG2_0_notmet3.size();
			if (size>0){
			Reporter.log(label_text +"<br>"+ label_description);
			for (Map.Entry<String, String> entry : WCAG2_0_notmet3.entrySet()) {
			    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
			}
			sa.assertFalse(size>0);
			sa.assertAll();
			}
		
			
			
			
		}
		else{
			 throw new SkipException("Skipping this Test Case");
		}
	

}
	
/////input element has associated label for Radio Button
	@Test(priority=5)
	public void radiolabel() {
		isPresent4=false;
		isPresent4 = driver.findElements(By.xpath(radioXpath)).size() > 0;
		SoftAssert sa= new SoftAssert();
		if(isPresent4!=false){	
		
		try {
			String label_text = "Error: input element, type of 'radio', missing an associated label.";
			String label_description = "Description: input element that contains a type attribute value of 'radio' must have an associated label element. An associated label is one in which the for attribute value of the label element is the same as the id attribute value of the input element.";
			//Reporter.log(label_text + "<br>" + label_description);
			List<WebElement> subNavLinks = dvr.findElements(By.xpath(radioXpath));

			for (WebElement subNavLink : subNavLinks) {
				labelid = subNavLink.getAttribute(idattribute);
				if(labelid.isEmpty()){
					String labelname =subNavLink.getAttribute("name");
					WCAG2_0_notmet4.put((labelname), ("WCAG2.0 Guildeline is Not Met For Input element of type radio with name = "));
					
					//Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Input element of type radio with name - " + labelname);

				}
				else{
				String labelxpath = "//*[@for='" + labelid + "']";
				String labeltext = dvr.findElement(By.xpath(labelxpath)).getText();
				System.out.println(labelxpath);
				
				// for (WebElement subNavLink : subNavLinks) {

				if (labeltext.isEmpty()) {
					WCAG2_0_notmet4.put((labelid), ("WCAG2.0 Guildeline is Not Met For Input element of type radio with id - "));

					// Reporter.log(alt_text + "\n" + alt_text_description + "\n" +
					// "WCAG2.0 Guildeline is Not Met");

					// Reporter.log(alt_text +"<br>"+ alt_text_description +"<br>"+
					// "WCAG2.0 Guildeline is Not Met"+"<br>"
					// + "For Image URL - " + srcAttributeText);

					//Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Input element of type radio with id - " + labelid);

				}

				else

				{
					WCAG2_0_met4.put(("Input element of type radio with id " + labeltext), (label_text + label_description));

					// Reporter.log(alt_text + "\n" + alt_text_description + "\n" +
					// "WCAG2.0 Guildeline is Met");
					// Reporter.log(alt_text+ "<br>"+ alt_text_description +"<br>"
					// +"WCAG2.0 Guildeline is Met"+"<br>"
					// + " For Image URL - " + srcAttributeText);
				//	Reporter.log("WCAG2.0 Guildeline is Met" + "<br>" + " For Input element of type radio with id - " + labelid
				//			+ " where the label text is : " + labeltext);

				}

			}
}
			int size=WCAG2_0_notmet4.size();
			if (size>0){
				Reporter.log(label_text +"<br>"+ label_description);
			
for (Map.Entry<String, String> entry : WCAG2_0_notmet4.entrySet()) {
    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
}sa.assertFalse(size>0);
sa.assertAll();
}
		} catch (NoSuchElementException e) {
			
		}finally{
			 isPresent4=false;
		}}
		else{
			 throw new SkipException("Skipping this Test Case");	
		}

}
	
////////////fieldset for check boxes
@Test(priority=6)
public void checkboxlabelfieldset() {
	isPresent5=false;
	isPresent5 = driver.findElements(By.xpath("//label//form//fieldset")).size() > 0;
	SoftAssert sa= new SoftAssert();
	if(isPresent5!=false){	
	try {
		String label_text = "Erorr: Form missing fieldset and legend to group multiple radio buttons.";
String label_description = "Description: Form element content must contain both fieldset and legend elements if there are related radio buttons.";

WebElement formElement = dvr.findElement(By.xpath(labelXpath));
List<WebElement> allFormElements = formElement.findElements(By.xpath("//form//fieldset"));

List<WebElement> allradioElements = formElement.findElements(By.xpath(checkboxXpath));
List namelist= new ArrayList<>();
for (WebElement allradioElement : allradioElements) {
		
		namelist.add(allradioElement.getAttribute("name"));}
		if(namelist.get(0).equals(namelist.get(1))){
			
		
//Reporter.log(label_text + "<br>" + label_description);
if(allFormElements.isEmpty()){
		String actiontext =formElement.getAttribute("action");
		WCAG2_0_notmet5.put((actiontext),("WCAG2.0 Guildeline is Not Met for Form which doesnot contain Fieldset where Action = "));
		//Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " Form doesnot contain Fieldset  where Action = "
		//		+ actiontext);	
}
else{
for (WebElement allFormElement : allFormElements) {
		Boolean s = allFormElement.getTagName().contains("fieldset");
		
		String actiontext = allFormElement.getAttribute("action");
		if (s.equals(true)) {
			String legendtext = allFormElement.findElement(By.xpath("//legend")).getText();
			WCAG2_0_met5.put(("Form contains Fieldset  with legend = " + legendtext),
					(label_text + label_description));

			//Reporter.log(
		//			"WCAG2.0 Guildeline is Met" + "<br>" + " Form contains Fieldset  with legend = " + legendtext);

		}

		else{
			
		}

			

		}
}
		}
		else{
			
		}
		int size=WCAG2_0_notmet5.size();
		if (size>0){
			Reporter.log(label_text +"<br>"+ label_description);
		
		for (Map.Entry<String, String> entry : WCAG2_0_notmet5.entrySet()) {
		    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
		}
		sa.assertFalse(size>0);
		sa.assertAll();
		}
	} catch (NoSuchElementException e) {
		
	}finally{
		 isPresent5=false;}}
	else{
		 throw new SkipException("Skipping this Test Case");
	}

}
/////input element has associated label for Password
@Test(priority=7)
public void passwordlabel() {
	isPresent6=false;
	isPresent6 = driver.findElements(By.xpath(pwdXpath)).size() > 0;
	SoftAssert sa= new SoftAssert();
	if(isPresent6!=false){	
	try {
		String label_text = "Error: input element, type of 'password', missing an associated label.";
		String label_description = "Description: input element that contains a type attribute value of 'password' must have an associated label element. An associated label is one in which the for attribute value of the label element is the same as the id attribute value of the input element.";
		Reporter.log(label_text + "<br>" + label_description);
		List<WebElement> subNavLinks = dvr.findElements(By.xpath(pwdXpath));

		for (WebElement subNavLink : subNavLinks) {
			labelid = subNavLink.getAttribute(idattribute);
			if(labelid.isEmpty()){
				String labelname =subNavLink.getAttribute("name");
				WCAG2_0_notmet6.put((labelname), ("WCAG2.0 Guildeline is Not Met For Input element of type password with name = "));
				
				//Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Input element of type password with name - " + labelname);

			}
			else{
			String labelxpath = "//*[@for='" + labelid + "']";
			String labeltext = dvr.findElement(By.xpath(labelxpath)).getText();
			System.out.println(labelxpath);
			
			// for (WebElement subNavLink : subNavLinks) {

			if (labeltext.isEmpty()) {
				WCAG2_0_notmet6.put((labelid), ("WCAG2.0 Guildeline is Not Met For Input element of type password with id - "));

				// Reporter.log(alt_text + "\n" + alt_text_description + "\n" +
				// "WCAG2.0 Guildeline is Not Met");

				// Reporter.log(alt_text +"<br>"+ alt_text_description +"<br>"+
				// "WCAG2.0 Guildeline is Not Met"+"<br>"
				// + "For Image URL - " + srcAttributeText);

		//		Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Input element of type password with id - " + labelid);

			}

			else

			{
				WCAG2_0_met6.put(("Input element of type password with id " + labeltext), (label_text + label_description));

				
			//	Reporter.log("WCAG2.0 Guildeline is Met" + "<br>" + " For Input element of type password with id - " + labelid
//						+ " where the label text is : " + labeltext);

			}

		}
}
		int size=WCAG2_0_notmet6.size();
		if (size>0){
			Reporter.log(label_text +"<br>"+ label_description);
	
for (Map.Entry<String, String> entry : WCAG2_0_notmet6.entrySet()) {
    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
}
sa.assertFalse(size>0);
sa.assertAll();
		}
	} catch (NoSuchFrameException e) {
		
	}finally{
		 isPresent6=false;}}
	else{
		 throw new SkipException("Skipping this Test Case");
	}

}
/////input element has associated label for file
@Test(priority=8)
public void filelabel() {
	isPresent7=false;
	isPresent7 = driver.findElements(By.xpath(fileXpath)).size() > 0;
	SoftAssert sa= new SoftAssert();

	if(isPresent7!=false){	
		String label_text = "Error: input element, type of 'file', missing an associated label.";
	
try {
	String label_description = "Description: input element that contains a type attribute value of 'file' must have an associated label element. An associated label is one in which the for attribute value of the label element is the same as the id attribute value of the input element.";
	Reporter.log(label_text + "<br>" + label_description);
	List<WebElement> subNavLinks = dvr.findElements(By.xpath(fileXpath));
	
	for (WebElement subNavLink : subNavLinks) {
		labelid = subNavLink.getAttribute(idattribute);
		if(labelid.isEmpty()){
			String labelname =subNavLink.getAttribute("name");
			WCAG2_0_notmet7.put(("Input element with type file " + labelname), (label_text + label_description));
			
			Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Input element of type file with name - " + labelname);
	
		}
		else{
		String labelxpath = "//*[@for='" + labelid + "']";
		String labeltext = dvr.findElement(By.xpath(labelxpath)).getText();
		System.out.println(labelxpath);
		
		// for (WebElement subNavLink : subNavLinks) {
	
		if (labeltext.isEmpty()) {
			WCAG2_0_notmet7.put((labelid), ("WCAG2.0 Guildeline is Not Met For Input element of type file with id = "));
	
			//	Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Input element of type file with id - " + labelid);
	
		}
	
		else
	
		{
			WCAG2_0_met7.put(("Input element of type file with id " + labeltext), (label_text + label_description));
	
			
			Reporter.log("WCAG2.0 Guildeline is Met" + "<br>" + " For Input element of type file with id - " + labelid
					+ " where the label text is : " + labeltext);
	
		}
	
	}
	}
	int size=WCAG2_0_notmet7.size();
	if (size>0){
		Reporter.log(label_text +"<br>"+ label_description);
	
	for (Map.Entry<String, String> entry : WCAG2_0_notmet7.entrySet()) {
	    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
	}
	sa.assertFalse(size>0);
	sa.assertAll();
	}
} catch (NoSuchElementException e) {
	
}finally{
	 isPresent7=false;}}
	else{
		 throw new SkipException("Skipping this Test Case");
	}

}

/////tabel summary has associated text
@Test(priority=9)
public void tablesummary() throws Exception {
	isPresent8=false;
	isPresent8 = driver.findElements(By.xpath(tableXpath)).size() > 0;
	SoftAssert sa= new SoftAssert();

	if(isPresent8!=false){	
		try {
			String label_text = "Error: Data table summary is empty.";
			String label_description = "Description: table element cannot contain an empty summary attribute if it's a data table.";

WebElement tableElement = dvr.findElement(By.xpath(tableXpath));
String tableheadings = tableElement.findElement(By.xpath("//tr")).getText();
String layouttableheadings = tableElement.findElement(By.xpath("//tr//td")).getText();
List<WebElement> subNavLinks = dvr.findElements(By.xpath(tableXpath));
Boolean isPresent = tableElement.findElements(By.xpath("//tr//th")).size() > 0;

for (WebElement subNavLink : subNavLinks) {
String Summary = subNavLink.getAttribute(Summaryattribute);

if(isPresent.equals(false)){

String tabel_text = "Error: Layout table has a summary.";
String tabel_description = "Description: The table element, summary attribute for all layout tables contains no printable characters or is absent.";		

if(Summary.isEmpty()){
			
			Reporter.log(tabel_text + "<br>" + tabel_description);
			WCAG2_0_met8.put(("Layout Table with text" + layouttableheadings), (tabel_text + tabel_description));
		//	Reporter.log("WCAG2.0 Guildeline is Met" + "<br>" + " For Layout Table with text - " + layouttableheadings);
}
else{
			
				WCAG2_0_notmet8.put((layouttableheadings), ("WCAG2.0 Guildeline is Not Met For Layout Table with text = "));
				
				//Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Layout Table with text - " + layouttableheadings);

				
				}}
else if(isPresent.equals(true)){
if(Summary.isEmpty()){
			WCAG2_0_notmet8.put((tableheadings), ("WCAG2.0 Guildeline is Not Met For Table with headers = "));
			
	//		Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Table with headers - " + tableheadings);

			}
else{
		//	Reporter.log(label_text + "<br>" + label_description);
			WCAG2_0_met8.put(("For Table with headers" + tableheadings), (label_text + label_description));
		//	Reporter.log("WCAG2.0 Guildeline is Met" + "<br>" + " For Table with headers - " + tableheadings);

				
				
				}}
			


}
int size=WCAG2_0_notmet8.size();
if (size>0){
	Reporter.log(label_text +"<br>"+ label_description);

for (Map.Entry<String, String> entry : WCAG2_0_notmet8.entrySet()) {
    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
}
sa.assertFalse(size>0);
sa.assertAll();
}
		} catch (NoSuchElementException e) {
			
		}finally{
			 isPresent8=false;}}else{
				 throw new SkipException("Skipping this Test Case");
}
}

///table headers has scope
@Test(priority=10)
public void checkTableHeaders(){
	isPresent9=false;
	isPresent9 = driver.findElements(By.xpath(tableXpath)).size() > 0;
	System.out.println("check table headers"+isPresent9);
	SoftAssert sa= new SoftAssert();
	if(isPresent9!=false){	
	try {
		boolean isElementPresent = false;
		WebElement thElement = null;
		WebElement trElement = null;
		WebElement tableElement = dvr.findElement(By.xpath(tableXpath));
		String label_text = "Error: Data table with both row and column headers does not use scope to identify cells.";
		String label_description = "Description: The scope attribute may be used to clarify the scope of any cell used as a header.";

		thElement=tableElement.findElement(By.xpath(tableHeaderXpath));
		trElement=tableElement.findElement(By.xpath(tableRowXpath));
		if ((thElement != null) && (trElement !=null))
			isElementPresent = true;
			else
			isElementPresent = false;
		if(isElementPresent){
			List<WebElement> subNavLinks = tableElement.findElements(By.xpath(tableHeaderXpath));
			for (WebElement subNavLink : subNavLinks) {
				String tableheadings = subNavLink.getText();
				//String headerAttributeText = subNavLink.getAttribute(headerAttribute);
				//String roleAttributeText = subNavLink.getAttribute(roleAttribute);
				String scopeAttributeText = subNavLink.getAttribute(scopeAttribute);
				if(scopeAttributeText == null) {
					WCAG2_0_notmet9.put((tableheadings), ("WCAG2.0 Guildeline is Not Met As Table doesnot contain Scope Attribute, where Table Header = "));
					
					//Reporter.log("WCAG2.0 Guildeline is Not Met " + "<br>" + " Table Header "+ tableheadings + " doesnot contain Scope Attribute - " + tableHeaderXpath);
		
				}
				else{
					WCAG2_0_met9.put(("For Table with headers" + tableHeaderXpath), (label_text + label_description));
					//Reporter.log("WCAG2.0 Guildeline is Met " + "<br>" + " Table Header " + tableheadings + " contains Scope Attribute where Scope - " + scopeAttributeText);
				
				}
		}
}
		int size=WCAG2_0_notmet9.size();
		if (size>0){
			Reporter.log(label_text +"<br>"+ label_description);
	
for (Map.Entry<String, String> entry : WCAG2_0_notmet9.entrySet()) {
    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
}
sa.assertFalse(size>0);
sa.assertAll();
		}
	} catch (NoSuchElementException e) {
		
	}finally{
		 isPresent9=false;}}
	else{
		 throw new SkipException("Skipping this Test Case");
	}
}
//All select elements have an explicitly associated label.
@Test(priority=11)
public void Selecttext() {
	isPresent10=false;
	isPresent10 = driver.findElements(By.xpath(selectXpath)).size() > 0;
	//System.out.println("selecttext"+isPresent10);
	SoftAssert sa= new SoftAssert();
	if(isPresent10!=false){	
		try {
			String label_text = "Error: select element missing an associated label.";

String label_description = "Description: select element must have an associated label element. A label element is associated with the select element if the for attribute value of the label is the same as the id attribute of the select element.";

List<WebElement> subNavLinks = dvr.findElements(By.xpath(selectXpath));

for (WebElement subNavLink : subNavLinks) {
			String selectid = subNavLink.getAttribute(idattribute);
			
			String labelxpath = "//*[@for='" + selectid + "']";
			String labeltext = dvr.findElement(By.xpath(labelxpath)).getText();
			
			//Reporter.log(label_text + "<br>" + label_description);
			// for (WebElement subNavLink : subNavLinks) {

			if (labeltext.isEmpty()) {
				WCAG2_0_notmet10.put((selectid), ("WCAG2.0 Guildeline is Not Met For Select element with id = " ));

				// Reporter.log(alt_text + "\n" + alt_text_description + "\n" +
				// "WCAG2.0 Guildeline is Not Met");

				// Reporter.log(alt_text +"<br>"+ alt_text_description +"<br>"+
				// "WCAG2.0 Guildeline is Not Met"+"<br>"
				// + "For Image URL - " + srcAttributeText);

				//Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Select element with id - " + selectid);

			}

			else

			{
				WCAG2_0_met10.put(("Select element with id " + labeltext), (label_text + label_description));

				// Reporter.log(alt_text + "\n" + alt_text_description + "\n" +
				// "WCAG2.0 Guildeline is Met");
				// Reporter.log(alt_text+ "<br>"+ alt_text_description +"<br>"
				// +"WCAG2.0 Guildeline is Met"+"<br>"
				// + " For Image URL - " + srcAttributeText);
			//	Reporter.log("WCAG2.0 Guildeline is Met" + "<br>" + " For Select element with id - " + selectid
			//			+ " where the label text is " + labeltext);

			}

}
int size=WCAG2_0_notmet10.size();
if (size>0){
	Reporter.log(label_text +"<br>"+ label_description);

for (Map.Entry<String, String> entry : WCAG2_0_notmet10.entrySet()) {
    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
}
sa.assertFalse(size>0);
sa.assertAll();
}
		} catch (NoSuchElementException e) {
			
		}finally{
			 isPresent10=false;}}else{
				 throw new SkipException("Skipping this Test Case");
	}
}

///Data tables that contain more than one row/column of headers use the id and headers attributes to identify cells
@Test(priority=12)
public void tableshaveid() throws Exception {
	isPresent11=false;
	isPresent11 = driver.findElements(By.xpath(tableXpath)).size() > 0;
	SoftAssert sa= new SoftAssert();
	if(isPresent11!=false){		
		try {
			String label_text = "Error: Data table with more than one row/column of headers does not use id and headers attributes to identify cells";

String label_description = "Description: table element cannot contain an empty summary attribute if it's a data table.";

WebElement tableElement = dvr.findElement(By.xpath(tableXpath));
List<WebElement> altable = dvr.findElements(By.xpath(tableXpath));;
for(int a=0; a<altable.size();a++){
int isPresent = tableElement.findElements(By.xpath("//tr")).size();
if(isPresent> 1){
 for(int b=0;b<isPresent;b++){
				List<WebElement> subNavLinks = tableElement.findElements(By.xpath("//tr//th"));
				int thsize = subNavLinks.size();
				 for(int k=0; k<thsize;k++){	
				String thtext=subNavLinks.get(k).getText();
					String tableheadings = subNavLinks.get(k).getAttribute("id");
					String tablehtml = subNavLinks.get(k).getAttribute("innerHTML");
					
					if (tableheadings.isEmpty()) {
						WCAG2_0_notmet11.put((thtext),
								("WCAG2.0 Guildeline is Not Met For Table with header = "));

						//Reporter.log("WCAG2.0 Guildeline is Not Met" + "<br>" + " For Table with header - "
						//		+ thtext);

					} else {
						
						WCAG2_0_met11.put(("For Table headers with id " + tableheadings), (label_text + label_description));
					//	Reporter.log("WCAG2.0 Guildeline is Met" + "<br>" + " For Table headers "+ thtext + " with id - " + tableheadings);

					}}
}}
 else {
			
}}
		int size=WCAG2_0_notmet11.size();
if (size>0){
	Reporter.log(label_text +"<br>"+ label_description);

for (Map.Entry<String, String> entry : WCAG2_0_notmet11.entrySet()) {
    Reporter.log((entry.getValue()+" <br> "+entry.getKey()));
}
sa.assertFalse(size>0);
sa.assertAll();
}}
		 catch (NoSuchElementException e) {
			
		}finally{
			 isPresent11=false;}
	}
else{
	 throw new SkipException("Skipping this Test Case");
}
	
}
}

