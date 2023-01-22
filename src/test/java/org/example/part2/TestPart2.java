package org.example.part2;

import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPart2 {
	
	private static WebDriver webDriver;
	private static String baseUrl;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kenan\\Desktop\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		webDriver = new ChromeDriver(options);
		baseUrl = "https://www.gog.com/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}
	
	
	@Test
	@Order(1)
	void testLanguage() throws InterruptedException {
		
		webDriver.get(baseUrl);
		
		webDriver.findElement(By.xpath("/html/body/div[2]/footer/div[2]/div/div[1]/div[1]/ul/li[4]")).click();
		
		Thread.sleep(3000);
		
		WebElement polecane = webDriver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]"));
		assertEquals("Polecane", polecane.getText());
		
	}
	
	@Test
	@Order(2)
	void testDownload() throws InterruptedException {
		
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("/html/body/div[2]/footer/div[2]/div/div[2]/div[1]/a[2]/span")).click();
		Thread.sleep(2000);
		
		
	}
	
	@Test
	@Order(3)
	void testGamePrice() throws InterruptedException {
		
		webDriver.get(baseUrl);
		
		webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/div[4]/a")).click();
		
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/div[4]/div/div[1]/div/input")).sendKeys("The Witcher: Enhanced Edition");
		
		Thread.sleep(5000);
		
		webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/div[4]/div/div[3]/div/div/div[1]/div/div[2]/a/div")).click();
		
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("//*[@id=\"pageTop\"]/body/div[1]/button")).click();
		
		Thread.sleep(5000);
		
		WebElement price = webDriver.findElement(By.xpath("//*[@id=\"pageTop\"]/body/div[2]/div[6]/div[2]/div/div[1]/span[3]"));
		assertEquals("1.49", price.getText());
		
	}
	
	@Test
	@Order(4)
	void testTwitchStream() throws InterruptedException {
		
		webDriver.get(baseUrl);
		
		Thread.sleep(6000);
		
		webDriver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
		 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[16]/div[2]/div[2]/div/div[6]/a/picture/img")));
		webDriver.findElement(By.xpath("/html/body/div[2]/div/div[16]/div[2]/div[2]/div/div[6]/a/picture/img")).click();
		
		WebElement title1 = webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[3]/ul/div[1]/a/div[3]/div/div/div[1]/div/span"));
		assertEquals("Prey: Digital Deluxe Edition", title1.getText());
		
		WebElement title2 = webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[3]/ul/div[2]/a/div[3]/div/div/div[1]/div/span"));
		assertEquals("Vampyr", title2.getText());
		
		WebElement title3 = webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[3]/ul/div[3]/a/div[3]/div/div/div[1]/div/span"));
		assertEquals("Curse of the Dead Gods", title3.getText());
		
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[2]/div[3]/div[2]/a")).click();
		Thread.sleep(4000);
		
		String url = webDriver.getCurrentUrl();
		
		assertEquals("https://www.gog.com/en/partner/streamteam", url);
		
		Thread.sleep(2000);
		
	}
	
	@Test
	@Order(5)
	void testModifyPrice() throws InterruptedException {
		
		webDriver.get(baseUrl);
		
		webDriver.findElement(By.xpath("//*[@id=\"SEE_ALL_DEALS\"]/a")).click();
		Thread.sleep(3000);
		
		
		webDriver.findElement(By.xpath("//*[@id=\"genres-shooter\"]")).click();
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/app-root/div/div/app-catalog/catalog-content/div/div[1]/filters-wrapper/div/div[1]/div[2]/div/div/div/filters/div/price-filter/collapsible-section/div[2]/div/range-slider/div/div/label[1]/input")).clear();
		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/app-root/div/div/app-catalog/catalog-content/div/div[1]/filters-wrapper/div/div[1]/div[2]/div/div/div/filters/div/price-filter/collapsible-section/div[2]/div/range-slider/div/div/label[1]/input")).sendKeys("3");
		
		webDriver.findElement(By.xpath("/html/body/div[1]/app-root/div/div/app-catalog/catalog-content/div/div[1]/filters-wrapper/div/div[1]/div[2]/div/div/div/filters/div/price-filter/collapsible-section/div[2]/div/range-slider/div/div/label[2]/input")).clear();
		Thread.sleep(1000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/app-root/div/div/app-catalog/catalog-content/div/div[1]/filters-wrapper/div/div[1]/div[2]/div/div/div/filters/div/price-filter/collapsible-section/div[2]/div/range-slider/div/div/label[2]/input")).sendKeys("15");
		Thread.sleep(2000);
		
		WebElement title = webDriver.findElement(By.xpath("/html/body/div[1]/app-root/div/div/app-catalog/catalog-content/div/div[2]/paginated-products-grid/div/product-tile[3]/a/div[2]/div[1]/product-title/span"));
		assertEquals("S.T.A.L.K.E.R.: Call of Pripyat", title.getText());
	}
	
	@Test
	@Order(6)
	void testLinux() throws InterruptedException {
		
		webDriver.get(baseUrl);
		
		webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/div[4]/a")).click();
		
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/div[4]/div/div[1]/div/input")).sendKeys("Postal 2");
		
		Thread.sleep(5000);
		
		webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/div[4]/div/div[3]/div/div/div[1]/div/div[2]/a/div")).click();
		
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("//*[@id=\"pageTop\"]/body/div[1]/button")).click();
		
		Thread.sleep(5000);
		
		WebElement worksOn = webDriver.findElement(By.xpath("//*[@id=\"pageTop\"]/body/div[2]/div[7]/div[4]/div[3]/div[2]/div[3]/div[2]"));
		assertNotEquals("Windows (7, 8, 10, 11), Linux, Mac", worksOn.getText());
	
	
}
	
	@Test
	@Order(7)
	void testCart() throws InterruptedException {
		
		webDriver.get(baseUrl);

		webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[1]/div[1]/a")).click();
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/app-root/div/div/app-catalog/catalog-content/div/div[2]/div/div/sort/div/div[2]")).click();
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/app-root/div/div/app-catalog/catalog-content/div/div[2]/div/div/sort/div/dropdown/div/menu/div[2]/div/label[8]")).click();
		Thread.sleep(2000);
		
		WebElement element = webDriver.findElement(By.xpath("/html/body/div[1]/app-root/div/div/app-catalog/catalog-content/div/div[2]/paginated-products-grid/div/product-tile[1]/a/div[2]"));
		Actions actions = new Actions(webDriver);
		actions.moveToElement(element).click().perform();
		webDriver.findElement(By.xpath("//*[@id=\"pageTop\"]/body/div[1]/div[6]/div[2]/div[2]/div[2]/button[1]")).click();
		Thread.sleep(3000);
		
		webDriver.navigate().to("https://www.gog.com/en/games?order=desc:releaseDate");
		Thread.sleep(3000);
		
		WebElement element2 = webDriver.findElement(By.xpath("/html/body/div[1]/app-root/div/div/app-catalog/catalog-content/div/div[2]/paginated-products-grid/div/product-tile[6]/a/div[2]"));
		Actions actions2 = new Actions(webDriver);
		actions2.moveToElement(element2).click().perform();
		webDriver.findElement(By.xpath("//*[@id=\"pageTop\"]/body/div[1]/div[6]/div[2]/div[2]/div[2]/button[1]")).click();
		Thread.sleep(3000);
		
		webDriver.navigate().to("https://www.gog.com/en/games?order=desc:releaseDate");
		Thread.sleep(5000);
		
		WebElement element3 = webDriver.findElement(By.xpath("/html/body/div[1]/app-root/div/div/app-catalog/catalog-content/div/div[2]/paginated-products-grid/div/product-tile[19]/a/div[2]"));
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element3);
		Thread.sleep(3000); 
		
		WebElement element4 = webDriver.findElement(By.xpath("/html/body/div[1]/app-root/div/div/app-catalog/catalog-content/div/div[2]/paginated-products-grid/div/product-tile[19]/a/div[2]"));
		Actions actions3 = new Actions(webDriver);
		actions3.moveToElement(element4).click().perform();
		webDriver.findElement(By.xpath("//*[@id=\"pageTop\"]/body/div[1]/div[6]/div[2]/div[2]/div[2]/button[1]")).click();
		Thread.sleep(3000);
		
		webDriver.navigate().to("https://www.gog.com/en/games?order=desc:releaseDate");
		Thread.sleep(5000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/nav/div[1]/div[2]/div[3]/a")).click();
		WebElement cartTotal = webDriver.findElement(By.xpath("/html/body/div[1]/nav/div[1]/div[2]/div[3]/div/div[1]/div[2]"));
		assertEquals("94.37", cartTotal.getText());
		
		Thread.sleep(5000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/nav/div[1]/div[2]/div[3]/div/div[3]/div/div/div/div[1]/a[1]/div/div/div[2]/span[1]")).click();
		Thread.sleep(5000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/nav/div[1]/div[2]/div[3]/div/div[3]/div/div/div/div[1]/a[1]/div/div/div[2]/span[1]")).click();
		Thread.sleep(5000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/nav/div[1]/div[2]/div[3]/a")).click();
		WebElement cartTotal2 = webDriver.findElement(By.xpath("/html/body/div[1]/nav/div[1]/div[2]/div[3]/div/div[1]/div[2]"));
		Thread.sleep(3000);
		assertNotEquals("94.37", cartTotal2.getText());
		Thread.sleep(3000);
		
	}
}