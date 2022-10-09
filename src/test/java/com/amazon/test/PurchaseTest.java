package com.amazon.test;

import com.amazon.pages.CartProduct;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PurchaseTest {

    // WebDriver
    WebDriver driver;

    // Main Page
    private static String MAIN_URL = "https://www.amazon.com.mx/";

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(MAIN_URL);
    }

    @Test()
    public void purchaseTest001(){
        WebElement refrigerator;
        // Page objects
        HomePage homePage = new HomePage(this.driver);
        CartProduct cartPage = new CartProduct(driver);

        // Read data
        String query = "refregerador";
        String product1 = "Samsung";
        String product2 = "Mabe";

        // Get first fridge
        homePage.searchProduct(query);
        ProductsPage productPage = new ProductsPage(this.driver);
        refrigerator = productPage.getProduct(product1);
        refrigerator.click();
        //ProductPage fridge1 = new ProductPage(this.driver);

        WebElement btnAddCart = this.driver.findElement(By.id("add-to-cart-button"));
        btnAddCart.click();

        try {
            wait(14000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement noProteccionBtn = this.driver.findElement(By.id("attachSiNoCoverage-announce"));
        noProteccionBtn.click();

        this.driver.navigate().back();
        this.driver.navigate().back();

        // Get second fridge
        homePage.searchProduct(query);
        refrigerator = productPage.getProduct(product2);
        refrigerator.click();



    }

    @AfterTest()
    public void teardown(){
        driver.quit();
    }
}
