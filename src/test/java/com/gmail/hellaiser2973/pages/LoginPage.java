package com.gmail.hellaiser2973.pages;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
      WebDriver driver;

    @FindBy(id ="login")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "save")
    private WebElement loginButton;



    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void Click() {
        loginButton.click();
    }

    public void isLoginPage() {
        Assert.assertEquals("Login", driver.getTitle());
    }
}
