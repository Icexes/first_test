package com.gmail.hellaiser2973.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract class BasePage {

    WebDriver driver;

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
