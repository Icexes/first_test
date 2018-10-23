package com.gmail.hellaiser2973.pages;

import org.junit.Assert;

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
    private WebElement link;

    //todo пускай методы, которые переключаются на другую страницу, ее и возвращают
    //вот пример (он вместо метода Click)

    public LoginPage openLoginPage() {
        link.click();
        return new LoginPage(driver);
    }

    /*public void Click() {
        link.click();
    }*/
    public void isFirstPage() {
        Assert.assertEquals("Welcome to Grails", driver.getTitle());
    }
}
