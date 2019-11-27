package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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

public class TC2Test {

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
	}
		@Test
		public void A_validLoginTest() throws InterruptedException {
		/*	loginPOM.clickLoginLink();
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("First");
			
			Thread.sleep(5000);
			dashBoardPOM.home.click();*/
			GM.mouseHover(dashBoardPOM.newLaunch,dashBoardPOM.doneQuis,GM.driver) ;
			
			
		GM.assertText("Mortgage Calculator" , "//h3[contains ( text() , 'Mortgage Calculator')]", "xpath", "Assert passed");
		
		
		
					
		quisPOM.sendSalesPrice("400000");
		quisPOM.sendDownPayment("20000");
		quisPOM.sendLoanYears("20");
		quisPOM.sendInterest("7.25");
        quisPOM.clickCalulateSubmit();
    String str=    quisPOM.value.getText();
 System.out.println(str.contains("3003.43 Rs"));
     
			
			
		}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	} 
	
	
	
	
	
	
}
