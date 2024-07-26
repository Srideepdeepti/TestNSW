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
	
	public static WebDriver driver;
	public static HomePage home;
	List<String> selected_minister_list = new ArrayList<>();
	
	@Given("I navigate to specified URL")
	public void i_navigate_to_specified_url() {
	    
		   driver = new ChromeDriver();
		   driver.get("https://www.nsw.gov.au/media-releases");
		   driver.manage().window().maximize();
           
	}
	
	@Given("I expand the Minister List available on page")
	public void i_expand_the_minister_list_available_on_page() {
	    // Write code here that turns the phrase above into concrete actions
		
		 home = PageFactory.initElements(driver, HomePage.class);
         home.clickonShowAll();
       
	 	  }
	
	@Given("I select the following ministers given below:")
	public void i_select_the_following_ministers_given_below(List<String> ministersList) {
	    
		selected_minister_list.addAll(ministersList);
		List<WebElement> webElementMinisterList=home.getAllMinsterList() ;
		System.out.println("WebMinisterList Size in TEst Function ::"+webElementMinisterList.size());
		home.click_On_given_ministers_feature_file(ministersList);
	       
		
	}
	
	
	@When("I click on Apply Filter after selection")
	public void i_click_on_apply_filter_after_selection() throws InterruptedException {
	    
             home.click_Apply_Filter();
	    	
	}
	
	@Then("I validate filters are applied correctly and corresponding Minister Media Release cards are visible")
	public void i_validate_filters_are_applied_correctly_and_corresponding_minister_media_release_cards_are_visible() {
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
	
	
	
	@Then("then I close the browser")
	public void then_i_close_the_browser() {
	   
		 driver.close();
		 driver.quit();
		
	}
	
	
	
	@Given("I am on the page with Filters applied on Ministers")
	public void i_am_on_the_page_with_filters_applied_on_ministers() {
         
		//System.out.println(driver.getCurrentUrl());
		 
	}
	@When("I click on CLear All to remove the applied filters")
	public void i_click_on_c_lear_all_to_remove_the_applied_filters() {
        
		home.click_ClearAll_Filters();
		 }
	
	@Then("I validate that Filters are removed correcly")
	public void i_validate_that_filters_are_removed_correcly() {
	   
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
	
	
	}






