package org.example.part1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
public class Test1 {

    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    static void startup() {
        System.setProperty("webdriver.chrome.driver", "/home/dorijank/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("--no-sandbox"); // Bypass OS security model
        webDriver = new ChromeDriver(options);
        baseUrl = "https://www.gog.com/";
    }

    @AfterAll
    static void tearDownAfterAll() {
        webDriver.quit();
    }

    @Test
    void testHighlights() throws InterruptedException {

        webDriver.get(baseUrl);

        webDriver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[1]")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[1]")).click();

        webDriver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/div[3]/div[2]/div/div[13]/a")).click();

        Thread.sleep(4000);
        WebElement title = webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/h1"));
        String gameTitle = title.getText();

        assertEquals("Mafia Trilogy", gameTitle);

    }

    @Test
    void testSearch() throws InterruptedException {
        webDriver.get(baseUrl);

        Thread.sleep(2000);

        webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/div[4]/a")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/div[4]/div/div[1]/div/input")).sendKeys("Witcher");

        Thread.sleep(2000);

        WebElement title = webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/div[4]/div/div[3]/div/div/div[1]/div/div[3]/a/div/div/div[1]/span"));
        String gametitle = title.getText();

        if (gametitle.contains("Witcher")) {
            webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/div[4]/div/div[3]/div/div/div[1]/div/div[3]/a/div")).click();
            webDriver.findElement(By.xpath("/html/body/div[1]/button")).click();

            WebElement header = webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/h1"));
            String gameTitle = header.getText();

            assertEquals("The Witcher 3: Wild Hunt - Complete Edition", gameTitle);
            webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div[2]/div/div[3]/button[1]")).click();
        }
    }

    @Test
    void testVideoPlayer() throws InterruptedException {
        webDriver.get(baseUrl);

        webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/div[4]/a")).click();

        Thread.sleep(2000);
        webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/div[4]/div/div[1]/div/input")).sendKeys("Stardew Valley");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("/html/body/nav/div[1]/div[2]/div[4]/div/div[3]/div/div/div[1]/div/div[1]/a/div/div/div[1]")).click();

        webDriver.findElement(By.xpath("/html/body/div[1]/div[3]/div/a")).click();

    }

    @Test
    void TestGamesCountInCart() throws InterruptedException {
        Actions action = new Actions(webDriver);
        webDriver.get(baseUrl);
        action.moveToElement(webDriver.findElement(By.xpath("/html/body/div[2]/footer"))).perform();
        Thread.sleep(2000);

        webDriver.findElement(By.xpath("/html/body/div[2]/div/div[16]/div[1]/div/div[2]/a[1]")).click();


        WebElement we1 = webDriver.findElement(By.xpath("/html/body/div/app-root/div/div/app-catalog/catalog-content/div/div[2]/paginated-products-grid/div/product-tile[1]/a/div[2]"));
        action.moveToElement(we1).click().perform();
        webDriver.findElement(By.xpath("/html/body/div[1]/div[6]/div[2]/div/div[2]/button[1]/span/span[2]")).click();
        webDriver.navigate().to("https://www.gog.com/en/games");

        WebElement we2 = webDriver.findElement(By.xpath("/html/body/div/app-root/div/div/app-catalog/catalog-content/div/div[2]/paginated-products-grid/div/product-tile[2]/a"));
        action.moveToElement(we2).click().perform();
        webDriver.findElement(By.xpath("/html/body/div[1]/button")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("/html/body/div[2]/div[6]/div[2]/div/div[3]/button[1]")).click();
        webDriver.navigate().to("https://www.gog.com/en/games");

        WebElement we3 = webDriver.findElement(By.xpath("/html/body/div/app-root/div/div/app-catalog/catalog-content/div/div[2]/paginated-products-grid/div/product-tile[3]/a"));
        action.moveToElement(we3).click().perform();
        webDriver.findElement(By.xpath("/html/body/div[1]/div[6]/div[2]/div/div[2]/button[1]/span/span[2]")).click();
        webDriver.navigate().to("https://www.gog.com/en/games");

        webDriver.navigate().to("https://www.gog.com/en/games");
        WebElement we4 = webDriver.findElement(By.xpath("/html/body/div/nav/div[1]/div[2]/div[3]/a/span[1]"));
        String cart = we4.getText();

        assertEquals("3", cart);
        Thread.sleep(10000);
    }
}
