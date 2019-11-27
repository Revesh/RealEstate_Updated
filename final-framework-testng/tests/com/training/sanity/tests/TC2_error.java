package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class TC2_error {

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
			dashBoardPOM.clickPost();
			dashBoardPOM.clickCategory();
			dashBoardPOM.sendCategoryName("Z2_New Launches");
			dashBoardPOM.sendCategorySlug("launch");
			dashBoardPOM.sendCategoryDesc("New Launches of villas, apartments, flats");
			dashBoardPOM.clickCategoryAdd();
			driver.navigate().refresh();
		//*[@id="the-list"]/tr/td[1]/strong/a
			
		List <WebElement> categoryNames =	driver.findElements(By.xpath("//*[@id=\"the-list\"]/tr/td[1]/strong/a"));
		
		WebElement next = driver.findElement(By.cssSelector(".bottom.tablenav .next-page"));
		
		
		
		if (next.isEnabled())
		{
			
			List <WebElement> categoryNamesone =	driver.findElements(By.xpath("//*[@id=\"the-list\"]/tr/td[1]/strong/a"));
			next.click();
			List <WebElement> categoryNamestwo =	driver.findElements(By.xpath("//*[@id=\"the-list\"]/tr/td[1]/strong/a"));
			
			
			
			List<WebElement> newList = new ArrayList<WebElement>(categoryNamesone);
	        newList.addAll(categoryNamestwo );
	        
	        
	        for (int i =0; i<newList.size(); i++)
			{
				
			String str1 =	newList.get(i).getText();
			System.out.println(str1);
			 if (str1.contentEquals("Z2_New Launches")) {
				
				System.out.println("Category added successfully");
				
			}
			}}
	        
			
		
	        else {
	        for (int i =0; i<categoryNames.size(); i++)
			{
				
			String str2 =	categoryNames.get(i).getText();
			System.out.println(str2);
			 if (str2.contentEquals("Z2_New Launches")) {
				
				System.out.println("Category added successfully");
				
			}}
	        }
		
        
		
		
			
			
	         	
	         	
			
		
	             }
			
						
       
		}
	
		
		
	
/*	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}  */
	
	
	
	
	
	

