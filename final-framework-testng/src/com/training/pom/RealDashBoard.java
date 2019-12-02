package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RealDashBoard {
	public WebDriver driver; 
	
	public RealDashBoard(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//li[@id='wp-admin-bar-site-name']/a[@href='http://realestatem1.upskills.in/']")
	public WebElement home; 
	
	//li[@id='wp-admin-bar-site-name']/a[@href='http://realestatem1.upskills.in/']
	
	
	@FindBy(xpath="//ul[@id='responsive']/li[2]/a")
	public WebElement  newLaunch ; 
	
	
	
	@FindBy(xpath="/html//ul[@id='responsive']/div/div/div/div[@class='wpmm-entry-title']/a[@title='Donec quis']")
	public WebElement  doneQuis ; 
	
	@FindBy(xpath="//li[@id='menu-posts']//div[@class='wp-menu-name']")
	public WebElement  post ; 
	
	
	@FindBy(xpath="//li[@id='menu-posts']/ul[@class='wp-submenu wp-submenu-wrap']//a[@href='edit-tags.php?taxonomy=category']")
	public WebElement  categories ;
	
	
	
	@FindBy(xpath="/html//input[@id='tag-name']")
	public WebElement  categoryName; 
	
	@FindBy(xpath="//input[@id='tag-slug']")
	public WebElement  categorySlug;
	
	@FindBy(xpath="/html//textarea[@id='tag-description']")
	public WebElement  categoryDescription;
	
	
	
	@FindBy(xpath="/html//input[@id='submit']")
	public WebElement  categoryAdd; 
	
	
	
	
	@FindBy(xpath="//li[@id='menu-posts']/ul[@class='wp-submenu wp-submenu-wrap']//a[@href='edit.php']")
	public WebElement  allPost; 
	
	@FindBy(xpath="//div[@id='wpbody-content']//a[@href='http://realestatem1.upskills.in/wp-admin/post-new.php']")
	public WebElement  addPost; 
	
	
	
	
	@FindBy(xpath="//div[@id='wpbody-content']//a[@href='http://realestatem1.upskills.in/wp-admin/post-new.php']")
	public WebElement  addNewPost; 
	
	@FindBy(xpath="//input[@name='post_title'] ")
	public WebElement postTitle;
	
	@FindBy(xpath="/html//textarea[@id='content']")
	public WebElement postBody;
	
	
	@FindBy(xpath="//*[@id=\"in-category-717\"]")
	public WebElement postCategory ;
	
	@FindBy(xpath="//input[@id='publish']")
	public WebElement postPublish ;
	
	
	
	
	@FindBy(xpath="//tbody[@id='the-list']/tr[1]//strong/a[@href='http://realestatem1.upskills.in/wp-admin/post.php?post=7417&action=edit']")
	public WebElement latestPost ;
	
	public void clickHomeLink() {
		this.home.click(); 
	}
	
	
	
	public void clickdoneQuis() {
		this.doneQuis.click(); 
	}
	
	public void clickPost() {
		this.post.click(); 
	}
	
	
	public void clickCategory() {
		this.categories.click(); 
	}

		public void clickCategoryAdd() {
			this.categoryAdd.click(); 
		}
		
		public void clickAllPost() {
			this.allPost.click(); 
		}
		
		public void clickPostCategory() {
			this.postCategory.click(); 
		}
		
		public void clickNewPost() {
			this.addNewPost.click(); 
		}
		
		public void clickPostPublish() {
			this.postPublish.click();
		}
		
		
		

	public void sendCategoryName(String Message) {
		this.categoryName.clear();
		this.categoryName.sendKeys(Message);	
}	
	
	public void sendCategorySlug(String Message) {
		this.categorySlug.clear();
		this.categorySlug.sendKeys(Message);	
}	
	
	
	public void sendCategoryDesc(String Message) {
		this.categoryDescription.clear();
		this.categoryDescription.sendKeys(Message);	
		
}


	public void sendPostTitle(String Message) {
		this.postTitle.clear();
		this.postTitle.sendKeys(Message);	
		
}
	public void sendPostBody(String Message) {
		this.postBody.clear();
		this.postBody.sendKeys(Message);	
		
}	
	
	
	
	
	
}
