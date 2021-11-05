package com.test.YouTube;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class YoutubeTest extends DriverSetUp{
	
	public static String baseURL = "https://www.youtube.com";
	
	@Test
	public static void play() throws InterruptedException {
		driver.get(baseURL); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
		Thread.sleep(5000);
		
		//verify page title
		String actualtext1= "YouTube";
		String text1 = driver.getTitle();
		Assert.assertEquals(actualtext1, text1);
		System.out.println("The page title is: "+text1 );
		
		
		//verify search option
		String actualtext2= "Search";
		String text2 = driver.findElement(By.xpath( "//input[@id='search']")).getAttribute("aria-label");
		Assert.assertEquals(actualtext2, text2);
		System.out.println("Title Print: "+text2);
		
		//search
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("What is Software Testing & Why Testing is Important");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ytd-masthead/div[@id='container']/div[@id='center']/ytd-searchbox[@id='search']/button[@id='search-icon-legacy']/yt-icon[1]")).click();
		Thread.sleep(2000);
		
		
		//verify signin title
		String actualtext3 = "SIGN IN";
		String text3 = driver.findElement(By.xpath("//ytd-button-renderer[@class='style-scope ytd-masthead style-suggestive size-small']//yt-formatted-string[@id='text']")).getText();
		Assert.assertEquals(actualtext3, text3);
		System.out.println("Title Print: "+text3);
		
		//play
		driver.findElement(By.xpath("//body/ytd-app[1]/div[1]/ytd-page-manager[1]/ytd-search[1]/div[1]/ytd-two-column-search-results-renderer[1]/div[1]/ytd-section-list-renderer[1]/div[2]/ytd-item-section-renderer[1]/div[3]/ytd-video-renderer[1]/div[1]/div[1]/div[1]/div[1]/h3[1]/a[1]/yt-formatted-string[1]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(60000);
		
		
		//verify video's title
		
		String actualtext4 = "What is Software Testing & Why Testing is Important?";
		String text4 = driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-primary-info-renderer'][contains(text(),'What is Software Testing & Why Testing is Importan')]")).getText();
		Assert.assertEquals(actualtext4, text4);
		System.out.println("The title of the video is: "+text4);
		
		
	}

}
