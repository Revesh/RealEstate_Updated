package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.generics.GenericMethods;
import com.training.pom.RealLoginPOM;
import com.training.pom.RealDashBoard;
import com.training.pom.doneQuis;
import com.training.pom.blogPOM;
import com.training.pom.contactFormPOM;



import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC1_Medium_test {

	//Test case Medium one
	
	private WebDriver driver;
	private String baseUrl;
	private RealLoginPOM loginPOM;
	public RealDashBoard dashBoardPOM;
	private doneQuis quisPOM;
	private blogPOM blogPom;
	private contactFormPOM contactPOM;
	
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods GM;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new RealLoginPOM(driver); 
		dashBoardPOM = new RealDashBoard(driver);
		GM = new  GenericMethods (driver);
		quisPOM = new doneQuis(driver);
		blogPom =  new blogPOM(driver);
		contactPOM = new contactFormPOM(driver);

		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Assert.assertEquals("http://realestatem1.upskills.in/", baseUrl);
	}
		@Test
		/*first TC*/
		public void A_validLoginTest() throws InterruptedException {
			loginPOM.clickLoginLink();
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("First");
			Thread.sleep(5000);
			dashBoardPOM.home.click();
			blogPom.clickBlog();
			blogPom.searchBlog.click();
						
       
		
		
			blogPom.sendSearchBlog("Nullam hendrerit apartment");
			blogPom.clickResult();

	        String parentWinHandle = driver.getWindowHandle();
	         System.out.println("Parent window handle: " + parentWinHandle);
	         
	         Set<String> winHandles = driver.getWindowHandles();
	         // Loop through all handles
	         for(String handle: winHandles){
	             if(!handle.equals(parentWinHandle)){
	             driver.switchTo().window(handle);
	             
	             Thread.sleep(5000); 
	         	
	         	String str1 = driver.getTitle();
	         	System.out.println(str1);
	         	String Expected = "Nullam hendrerit Apartments – Real Estate";
	         	if ( str1.equals( Expected))
	         	{
	         		System.out.println("page navigated to Nullam aparment page");
	         		
	         	}
	             }
	         }
	         	driver.switchTo().window(parentWinHandle);
	         	blogPom.clickDropUs();
	         	
	         	String str2 = driver.getTitle();
	         	System.out.println(str2);
	         	String Expected2 = "Contact – Real Estate";
	         	if ( str2.equals( Expected2))
	         	{
	         		System.out.println("I am in contact from page");
	         		
	         	}
	         	
	         	
	         	contactPOM.sendContactName("selenium");
	         	contactPOM.sendContactEmail("selenium@gmail.com");
	         	contactPOM.sendContactSubject("apartment");
	         	contactPOM.sendContactMessage("looking for apartment");
	         	contactPOM.clickSubmitForm();
	         	
	         	GM.assertText("Thanks you for your message. It has been sent" , "/html//div[@id='wrapper']//article//div[@role='form']/form[@action='/contact/#wpcf7-f119-p134-o1']/div[@role='alert']", "xpath", "Assert NOT passed for contact form submission");
	         	
	         	
	         	
	             }
			
						
       
		
	
		
		
	
@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}  
}
	
	
	
	
	

