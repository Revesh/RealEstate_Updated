package com.training.sanity.tests;

import java.awt.AWTException;
//import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
import com.training.pom.findHome;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class TC3Test {

	private WebDriver driver;
	private String baseUrl;
	private RealLoginPOM loginPOM;
	public RealDashBoard dashBoardPOM;
	private doneQuis quisPOM;
	private findHome fh;
	
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
		fh = new findHome(driver);
		GM = new  GenericMethods (driver);
		quisPOM = new doneQuis(driver);

		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	//Assert.assertEquals("http://realestatem1.upskills.in/", baseUrl);

		
	}
		@Test
		public void A_validLoginTest() throws InterruptedException, AWTException {
		/*	loginPOM.clickLoginLink();
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			screenShot.captureScreenShot("First");
			
			Thread.sleep(5000);
			dashBoardPOM.home.click();*/
			
			
			Robot robot = new Robot();
		dashBoardPOM.newLaunch.click();
System.out.println( "whether map displayed or not " + fh.map.isDisplayed()); 
	GM.assertText("Find Your Home" , "//h4[contains(text() , 'Find Your Home')]", "xpath", "Assert NOT passed for find your home");
	
	
	GM.sendValue(fh.address, "Electronic city");
	Actions action = new Actions(driver);
	action.keyDown(Keys.CONTROL).click().perform();
	fh.propertyType.click();
	 WebElement allOptions =   driver.findElement(By.xpath("//*[@id=\"_property_type_chosen\"]/div/ul")); 
	 

     List<WebElement> options = allOptions.findElements(By.xpath("//*[@id=\"_property_type_chosen\"]/div/ul/li"));
     System.out.println(options.size());
     for (int i =0 ; i < options.size(); i++)
     {
    	 String str = options.get(i).getText();
    	 System.out.println(str);
    	 
    	 if (str.equals("Plots")) {
    		 
    		 
    		 options.get(i).click();
    		 
    		 
    	 }}
        
         
    	 
    	 
    	 
    	 driver.findElement(By.cssSelector("div > .chosen-default.chosen-single")).click();;
    	 WebElement allRegions =   driver.findElement(By.xpath("//*[@id=\"realteo-search-form\"]/div[2]/div[2]/div/div")); 
    	 

         List<WebElement> l1 = allRegions.findElements(By.tagName("li"));
         System.out.println(l1.size());
         for (int j =0 ; j < l1.size(); j++)
         {
        	 String str1 = l1.get(j).getText();
        	 System.out.println(str1);
        	 
        	 if (str1.contains("Central")) {
        		 
        		 
        		 l1.get(j).click();
        		 
        		 
        	 }
    	 
    	 
    	 
     } 

	 
	// below used Robot class for drop down control 
	/*fh.propertyType.click();
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	
	//li[@class='active-result']
	driver.findElement(By.cssSelector("[class='col-md-6 ']:nth-of-type(2) .chosen-default")).click();

	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER); */
	
        String parentWinHandle = driver.getWindowHandle();
         System.out.println("Parent window handle: " + parentWinHandle);
		WebElement search = driver.findElement(By.xpath("//button[contains ( text(), 'Search')]"));
	System.out.println(search.isDisplayed());
	search.click();


	
    // Locate 'Click to open a new browser window!' button using id
   
    Set<String> winHandles = driver.getWindowHandles();
    // Loop through all handles
    for(String handle: winHandles){
        if(!handle.equals(parentWinHandle)){
        driver.switchTo().window(handle);
        
        Thread.sleep(5000); 
        
        
    	
    	GM.assertText("Region: New Launch" , "//*[@id=\"titlebar\"]/div/div/div/h1", "xpath", "Assert NOT passed for search");
    	
        
        }

	
	//driver.findElement(By.xpath("//button[contains ( text(), 'Search')]")).click();
	
	
	//*[@id="titlebar"]/div/div/div/h1
			
	//h1[contains (text(), 'Region: New Launch')]
			
		} 
}}
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	} */
	
	
	
	
	
	

