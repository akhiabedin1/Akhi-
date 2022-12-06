package com.qa.fifa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager; 



public class SearchTest {
	
	@Test
	
	public void ValidateSearch() { 
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver ();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("fifa world cup 2022"); 
		search.sendKeys(Keys.ENTER); 
		
		WebElement firstLink = driver.findElement(By.xpath("(//div[@class='ofy7ae'])[1]"));
		
		String actualText = firstLink.getText();
		String expected = "FIFA World Cup Qatar 2023�";
		Assert.assertTrue(actualText.equalsIgnoreCase(expected), "Expected " + expected + " but found" + actualText);
		
		//Assert.assertTrue(actualText.equalsIgnoreCase(expected), "Expected " + expected + " but found " + actualText); 
		
			
		
		

}
}
	
//	public static void main(String[] args) {
		
		//SearchTest ST = new SearchTest (); 
		//ST.ValidateSearch();
	