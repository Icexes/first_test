package com.gmail.hellaiser2973.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    WebDriver driver;

    //todo и смысл от того, что ты их сюда перенес? где методы, с ними работающие?
    @FindBy(css = "a[href*='logout']")
    protected WebElement logoutButton;

    @FindBy(css = "a.create")
    protected WebElement newMsgButton;

    @FindBy(css = "input[name='allUsers']")
    protected WebElement chBoxAllUsers;

    public void logOut() {
        logoutButton.click();
    }
}
