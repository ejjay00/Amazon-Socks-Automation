package org.example;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonSocksTests {

    private WebDriver driver;

    @Before
    public void setUpBrowser() {
        // Set up the Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\e_jen\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        // Navigate to the Amazon home page
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void testSockSearch() {
        // Enter "socks" in the search bar and submit the search
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("socks");
        searchBox.submit();

        // Verify that the search results page contains the keyword "socks"
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("socks"));
    }

    @Test
    public void testSockSearchFilters() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("socks");
        searchBox.submit();

        WebElement brandFilter = driver.findElement(By.linkText("Dickies"));
        brandFilter.click();
        System.out.println("I clicked!");

        WebElement priceOption = driver.findElement(By.linkText("Up to $25"));
        priceOption.click();
}
    @Test
    public void testAddSocksToCart(){
        // Enter "socks" in the search bar and submit the search
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("socks");
        searchBox.submit();

        // Verify that the search results page contains the keyword "socks"
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("socks"));

        WebElement addToCart = driver.findElement(By.linkText("Men's Dri-tech Moisture Control Crew Socks Multipack"));
        addToCart.click();
    }

    @After
    public void shutDownBrowser() {
        // Close the browser
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}