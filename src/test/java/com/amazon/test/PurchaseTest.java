package com.amazon.test;

import com.amazon.pages.CartProduct;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

        // Read data
        String query = "refrigerador";
        String product1 = "Samsung";
        String product2 = "Grafito Mabe";

        // Get first fridge
        homePage.searchProduct(query);
        ProductsPage productPage = new ProductsPage(this.driver);
        refrigerator = productPage.getProduct(product1);
        refrigerator.click();
        //ProductPage fridge1 = new ProductPage(this.driver);

        try {
            WebElement btnAddCart = this.driver.findElement(By.id("add-to-cart-button"));
            btnAddCart.click();

            // Click not protection
            WebElement noProteccionBtn = this.driver.findElement(By.id("attachSiNoCoverage-announce"));
            //WebElement frame = this.driver.findElement(By.id("attach-warranty-display"));
            //this.driver.switchTo().frame(frame);
            noProteccionBtn.click();

        } catch (Exception e) {
            System.out.println("The store doesn't have inventory for this product");
        }

        this.driver.navigate().back();
        this.driver.navigate().back();

        // Get second fridge
        homePage.searchProduct(query);
        refrigerator = productPage.getProduct(product2);
        refrigerator.click();

        try {
            WebElement btnAddCart = this.driver.findElement(By.id("add-to-cart-button"));
            btnAddCart.click();
        } catch (Exception e) {
            System.out.println("The store doesn't have inventory for this product");
        }

        homePage.backHomePage();
        homePage.goCart();
        CartProduct cartPage = new CartProduct(driver);
        Float total = cartPage.getTotal();

        Assert.assertEquals(total, 10000);

    }

    @AfterTest()
    public void teardown(){
        driver.quit();
    }
}
