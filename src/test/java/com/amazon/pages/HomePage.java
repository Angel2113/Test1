package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {



    private WebDriver driver;

    @FindBy(id="twotabsearchtextbox")
    WebElement searchBar;

    @FindBy(id="nav-search-submit-button")
    WebElement searchBtn;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Sent a product in search bar and click on the button
     * @param product
     */
    public void searchProduct(String product){
        searchBar.sendKeys(product);
        searchBtn.click();
    }

}
