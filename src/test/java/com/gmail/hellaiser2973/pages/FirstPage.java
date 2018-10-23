package com.gmail.hellaiser2973.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPage {
    public FirstPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    WebDriver driver;
    @FindBy (linkText = "qulixteachingsite.UserController")
    private WebElement lnk;

    public void Click() {
        lnk.click();
    }
    public void isFirstPage() {
        try {
            driver.findElement(By.linkText("qulixteachingsite.UserController"));

        } catch (NoSuchElementException e) {
            System.out.println("Login page is not opened");
            driver.quit();
            throw new RuntimeException(("Test ended with critical error"));
        }
    }
}
