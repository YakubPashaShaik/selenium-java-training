package test.java;

import static junit.framework.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLocalRun {
	 private WebDriver driver;
	 private WebDriverWait wait;
	
	
	  @Before 
	  public void setUp() { 
	    driver = new FirefoxDriver(); 
	    wait = new WebDriverWait(driver, 10);
	    driver.get("http://www.google.com"); 
	  } 

	  @After 
	  public void tearDown() throws IOException { 
	    driver.quit(); 
	  } 

	  @Test 
	  public void pageTitleAfterSearchShouldBeginWithDrupal() throws IOException { 
	    WebElement searchField = driver.findElement(By.name("q")); 
	    searchField.sendKeys("Drupal!"); 
	    searchField.submit(); 

		assertTrue("The page title should start with the search string after the search.", 
	        wait.until(new ExpectedCondition<Boolean>() { 
	          public Boolean apply(WebDriver d) { 
	            return d.getTitle().toLowerCase().startsWith("drupal!"); 
	          } 
	        })); 
	  } 
	
}
