package stepdefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import Utilities.URLDecode;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinition {
	
	public WebDriver driver;
	public HomePage home;
	List<String> selected_minister_list = new ArrayList<>();
	
	@Given("I navigate to url")
	public void i_navigate_to_url() {
	    
		   driver = new ChromeDriver();
		   driver.get("https://www.nsw.gov.au/media-releases");
		   driver.manage().window().maximize();
           
	}
	
	@Given("I expand the Minister List")
	public void i_expand_the_minister_list() {
	    // Write code here that turns the phrase above into concrete actions
		
		 home = PageFactory.initElements(driver, HomePage.class);
         home.clickonShowAll();
       
	 	  }
	
	@Given("I select the following ministers:")
	public void i_select_the_following_ministers(List<String> ministersList) {
	    
		selected_minister_list.addAll(ministersList);
		List<WebElement> webElementMinisterList=home.getAllMinsterList() ;
		System.out.println("WebMinisterList Size in TEst Function ::"+webElementMinisterList.size());
		home.click_On_given_ministers_feature_file(ministersList);
	       
		
	}
	
	
	@When("apply filter on the seleceted Minister List")
	public void apply_filter_on_the_seleceted_minister_list() throws InterruptedException {
	    
             home.click_Apply_Filter();
	    	
	}
	
	@Then("I validate all the minsters selected")
	public void i_validate_all_the_minsters_selected() {
	    // Write code here that turns the phrase above into concrete actions
	   
		try {
			
            
			// To check whether selected Minister Items are present in URL after Apply Filter
			String final_decoded_URL= URLDecode.decodeURL(driver.getCurrentUrl());
        
            for(String minister:selected_minister_list)
            {
            	 assert(final_decoded_URL.contains(minister));
                 
            }
            
            // Second Assertion : URL contains query Parameter ?
            assert(final_decoded_URL.contains("?ministers="));
           
          
        } catch (Exception e) {
            e.printStackTrace();
        }
		
    }
	
	
	
	
	@Then("lastly click on Clear All and validate it")
	public void lastly_click_on_clear_all_and_validate_it() {
	    // Write code here that turns the phrase above into concrete actions
		
        home.click_ClearAll_Filters();
		 
		 //Assertion: Validate the URL after clicking "Clear All Filters"
		 String ExpectedUrl ="https://www.nsw.gov.au/media-releases?";
		 String ActualUrl = driver.getCurrentUrl();
		 assertEquals(ExpectedUrl, ActualUrl);
		 
		 //Assertion: Validate that all previously selected Minister Check box get unchecked
		 
		 List<WebElement> Minister_WebElements = home.getAllMinsterList();
		 
		 for(WebElement minister:Minister_WebElements)
		 {
			 assertFalse(minister.isSelected());
		 }
		 
		
	   
	}

	
	@Then("Finally close the browser")
	public void finally_close_the_browser() {
	   
		driver.quit();
	}
	
	
	}






