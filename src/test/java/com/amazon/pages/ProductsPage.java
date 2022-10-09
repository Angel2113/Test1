package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;


    @FindAll({@FindBy(className = "a-size-mini a-spacing-none a-color-base s-line-clamp-2")})
    public List<WebElement> products;


    @FindBy(xpath="//*[@id='add-to-cart-button']")
    public WebElement addCartBtn;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    /*
    public WebElement getProduct(String product){
        this.driver.navigate().refresh();
        WebElement localProduct = null;
        for(WebElement p: this.products){
            p.getText();
        }

        return localProduct;
    }
     */

    public WebElement getAddCartBtn() {
        return addCartBtn;
    }

    public List<WebElement> getProducts(){
        return this.products;
    }

    /**
     * Find the first element with that name
     * @param name
     * @return
     */
    public WebElement getProduct(String name){
        WebElement firstProduct = this.driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);
        return firstProduct;
    }

    public void addCart() {
        this.driver.navigate().refresh();
        this.addCartBtn.click();
    }
}
