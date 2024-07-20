package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
   WebDriver driver;
	@FindBy(xpath="//div[@class='expandable-field__container expandable-field__container--expanded']/fieldset[@id='filter-ministers']/button")
	WebElement element;
	
	@FindBy(xpath="//fieldset[@id='filter-ministers']/div/input")
	List<WebElement> webElementMinisterList;
	
	@FindBy(xpath="//div[@class='nsw-filters__accept']/input[@value='Apply filters']")
     WebElement apply_filter;
	
	@FindBy(xpath="//div[@class='nsw-form__group']/button[text()='Clear all filters']")
    WebElement clearAll_filter;
	
	
	  
	
	
	
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	
	public void  clickonShowAll()
	{
		System.out.println("Test is Running");
		 //System.out.println(this.driver.getCurrentUrl());
		
 
         Actions actionsshow = new Actions(this.driver);

      	 actionsshow.moveToElement(element).click(element).build().perform(); 
      	 
	}
	
	public List<WebElement> getAllMinsterList()
	{ return webElementMinisterList;
    
	  
	}
	
	public void click_On_given_ministers_feature_file(List<String> ministersList )
	{
		for(String ministername:ministersList)
	       {
	       
	       
	         for(WebElement minister:webElementMinisterList)
	           {
	    	      String  MinisterActual = minister.getAttribute("data-analytics-value");
	    	     
	    	   
	    	        if (MinisterActual.contains(ministername))
	    	         {
	    		   Actions actionsminister = new Actions(this.driver);

	    		   actionsminister.moveToElement(minister).click(minister).build().perform();
	    	      }
	          }
	    
	         }
		
	}
	
	public void click_Apply_Filter() throws InterruptedException
	{
		   Actions actionsapplyfilter = new Actions(this.driver);

	       actionsapplyfilter.moveToElement(apply_filter).click(apply_filter).build().perform();
	       Thread.sleep(5000);
	       
	}
	
	public void click_ClearAll_Filters()
	{
		   
	       Actions clear_All_Action = new Actions(this.driver);

	       clear_All_Action.moveToElement(clearAll_filter).click(clearAll_filter).build().perform();
	    
	       
	}
}
