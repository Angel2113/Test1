package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage {
    private WebDriver driver;


    @FindBy(xpath="//*[@id='add-to-cart-button']")
    public WebElement addCartBtn;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addCart() {
        this.driver.navigate().refresh();
        this.addCartBtn.click();
    }
}
