package com.qa.tdl.acceptanceTesting;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class homePageTest {
	
	private static WebDriver driver;

	@BeforeAll
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void homePageCheck() throws InterruptedException {
		
		String test = "To-Do-List";
		
		homePage page = PageFactory.initElements(driver, homePage.class);
		
		driver.get(page.URL);
		
		Thread.sleep(6000);
		
		assertEquals(test, page.pageTitleResult());
	}
	
	@Test
	public void createItemCheck() throws InterruptedException {
		
		String expected = "Created";
		
		homePage page = PageFactory.initElements(driver, homePage.class);
		driver.get(page.URL);
		Thread.sleep(6000);
		
		assertEquals(expected, page.createItem(expected));
		
	}
	
	@Test
	public void updateItemCheck() throws InterruptedException {
		
		String expected = "Updated";
		
		homePage page = PageFactory.initElements(driver, homePage.class);
		driver.get(page.URL);
		Thread.sleep(6000);
		page.updateItem(expected, "3", "completed");
		Thread.sleep(5000);
		
		assertEquals(expected, page.updateItemReturn());
		
	}
	
	@Test
	public void deleteItem() throws InterruptedException {
		
		String expected = "Deleted";
		
		homePage page = PageFactory.initElements(driver, homePage.class);
		driver.get(page.URL);
		Thread.sleep(6000);
	
		assertEquals(expected, page.deleteItem(expected));
		
	}
	

	
	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
	
}
