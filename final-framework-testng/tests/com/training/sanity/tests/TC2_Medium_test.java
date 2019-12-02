package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class TC2_Medium_test {

	//TC Medium two
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
			dashBoardPOM.sendCategoryName("A1_New Launches");
			dashBoardPOM.sendCategorySlug("launch");
			dashBoardPOM.sendCategoryDesc("New Launches of villas, apartments, flats");
			dashBoardPOM.clickCategoryAdd();
			driver.navigate().refresh();
		//*[@id="the-list"]/tr/td[1]/strong/a
			
		List <WebElement> categoryNames =	driver.findElements(By.xpath("//*[@id=\"the-list\"]/tr/td[1]/strong/a"));
		
		WebElement next = driver.findElement(By.cssSelector(".bottom.tablenav .next-page"));
		
		for (int i =0; i<categoryNames.size(); i++)
		{
			
		String str2 =	categoryNames.get(i).getText();
		System.out.println(str2);
		System.out.println(str2);
		 if (str2.contentEquals("A1_New Launches")) {
			
			System.out.println("Category added successfully");
			
			break;
		}
		}
		
		
		
		
		 if (next.isEnabled())
		{
			
			
			next.click();
			List <WebElement> categoryNamestwo =	driver.findElements(By.xpath("//*[@id=\"the-list\"]/tr/td[1]/strong/a"));
			
			
			
			
	        
	        
	        for (int i =0; i<categoryNamestwo.size(); i++)
			{
				
			String str1 =	categoryNamestwo.get(i).getText();
			System.out.println(str1);
			 if (str1.contentEquals("A1_New Launches")) {
				
				System.out.println("Category added successfully");
				
			}
			}}
	        
		 dashBoardPOM.clickPost();
		 dashBoardPOM.clickNewPost();
		 dashBoardPOM.postTitle.click();
		 dashBoardPOM.sendPostTitle("New Launch_Reva");
		 dashBoardPOM.sendPostBody(" New Launch in Home");
		 dashBoardPOM.clickPostCategory();
		 dashBoardPOM.clickPostPublish();

		 
		 WebDriverWait wait = new WebDriverWait(driver,30);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='publish']")));
		 
		 
		System.out.println( dashBoardPOM.postPublish.isEnabled());
		 dashBoardPOM.clickPostPublish();
		 Thread.sleep(2000);
		 dashBoardPOM.clickAllPost();
		// dashBoardPOM.latestPost.getText()
		
		 
 GM.assertText("New Launch_Reva" , "//tbody[@id='the-list']/tr[1]/td[1]/strong/a", "xpath", "Assert for Post failed");
		 
		 
		
	        
	        }
		
        
		
		
		
		
			
			
	         	
	         	
			
		
	             }
			
						
       
		
	
		
		
	
/*	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}  */
	
	
	
	
	
	

