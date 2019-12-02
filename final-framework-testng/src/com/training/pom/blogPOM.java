package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class blogPOM {
	private WebDriver driver; 
	
	public blogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@id='responsive']/li[6]/a")
	private WebElement blog; 
	
	@FindBy(xpath="//div[@id='ajaxsearchlite1']//form[@title='Ajax serch form']/input[1]")
	public WebElement searchBlog;
	

	@FindBy(xpath="//*[@id=\"mCSBap_1_container\"]/div/div[1]/div[1]/h3/a/span")
	private WebElement searchResult;
	
	
	
	@FindBy(xpath="/html//aside[@id='secondary']/section[@class='widget widget_text']//a[@href='/contact/']")
	private WebElement dropUs;
	
	
	
	@FindBy(xpath="/html//div[@id='wrapper']/div//div[@class='col-md-8']/div/div/a[@href='http://realestatem1.upskills.in/efe/']")
	private WebElement readMore; 

	public void sendSearchBlog(String apartmentName) {
		this.searchBlog.clear();
		this.searchBlog.sendKeys(apartmentName);
		
		
		
		
	}
	public void clickBlog() {
		this.blog.click(); }
	
	public void clickResult() {
		this.searchResult.click();
	}
	
	public void clickDropUs() {
		this.dropUs.click();
	}
	
	public void clickReadMore() {
		this.readMore.click();
	}
	
	
	
	
}
	
	
	
	
	
	
	
	
	

