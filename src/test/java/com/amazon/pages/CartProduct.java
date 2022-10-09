package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartProduct {
    private WebDriver driver;

    /*
    @FindBy(id = )
    public static WebDriver
    */

    public CartProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}

