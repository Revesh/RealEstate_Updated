package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC1Test {

	private WebDriver driver;
	private String baseUrl;
	private RealLoginPOM loginPOM;
	public RealDashBoard dashBoardPOM;
	private doneQuis quisPOM;
	
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

		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Assert.assertEquals("http://realestatem1.upskills.in/", baseUrl);
	}
		@Test
		/*first TC*/
		public void A_validLoginTest() throws InterruptedException {
		/*	loginPOM.clickLoginLink();
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("First");
			
			Thread.sleep(5000);
			dashBoardPOM.home.click();*/
			GM.mouseHover(dashBoardPOM.newLaunch,dashBoardPOM.doneQuis,GM.driver) ;
			
			
		GM.assertText("FOR ENQUIRIES" , "//h3[contains (text() , 'FOR ENQUIRIES')]", "xpath", "Assert NOT passed for enquiries");
					
		quisPOM.sendEnquiryName("Revathy");
		quisPOM.sendEnquiryMail("revahty.dps@gmail.com");
		quisPOM.sendEnquirySubject("Land rate enquiry");
		quisPOM.sendEnquiryMessage("could you please share the square ft rate in north bangalore");
        quisPOM.clickEnquirySubmit();
        
        // this assert fails as the curretly displayed message in the page is not the one expected
        GM.assertText("Thank you for your message. It has been sent. Message should get displayed" , "//div[@id='widget_contact_widget_findeo-2']//div[@role='form']/form[@action='/donec-quis/#wpcf7-f4-o1']/div[@role='alert']", "xpath", "Assert NOT  passed for final message");
        
       
		}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	} 
	
	
	
	
	
	
}
