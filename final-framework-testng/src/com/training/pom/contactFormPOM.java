package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactFormPOM {
	private WebDriver driver; 
	
	public contactFormPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//contact
	
//	@FindBy(xpath="")
//	private WebElement blog; 
	
	@FindBy(xpath="/html//div[@id='wrapper']/div[@class='container full-width']/div[@class='row']/article//div[@role='form']/form[@action='/contact/#wpcf7-f119-p134-o1']//input[@name='name']")
	private WebElement contactName; 
	
	
	
	@FindBy(xpath="/html//div[@id='wrapper']/div[@class='container full-width']/div[@class='row']/article//div[@role='form']/form[@action='/contact/#wpcf7-f119-p134-o1']//input[@name='email']")
	private WebElement contactEmail; 
	

	@FindBy(xpath="/html//div[@id='wrapper']/div[@class='container full-width']/div[@class='row']/article//div[@role='form']/form[@action='/contact/#wpcf7-f119-p134-o1']//input[@name='subject']")
	private WebElement contactSubject; 
	
	@FindBy(xpath="/html//div[@id='wrapper']/div[@class='container full-width']//article//div[@role='form']/form[@action='/contact/#wpcf7-f119-p134-o1']//textarea[@name='id:comments']")
    private WebElement contactMessage; 
	
	
	
	
	@FindBy(xpath="/html//div[@id='wrapper']/div[@class='container full-width']//article//div[@role='form']/form[@action='/contact/#wpcf7-f119-p134-o1']//input[@value='Send']")
	private WebElement contactSubmit; 
	
	
	
	
	public void clickSubmitForm() {
		this.contactSubmit.click();
	}
	

	public void sendContactName(String contactName) {
		this.contactName.clear();
		this.contactName.sendKeys(contactName);	
}
	


	public void sendContactEmail(String Email) {
		this.contactEmail.clear();
		this.contactEmail.sendKeys(Email);	

}
	
	public void sendContactSubject(String Subject) {
		this.contactSubject.clear();
		this.contactSubject.sendKeys(Subject);	

}	
	
	public void sendContactMessage(String Message) {
		this.contactMessage.clear();
		this.contactMessage.sendKeys(Message);	
}	
	

	



}