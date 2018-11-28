package com.gmail.hellaiser2973.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Log;

public abstract class BasePage {

    WebDriver driver;

    @FindBy(css = "a[href*='logout']")
    private WebElement logoutButton;

    @FindBy(css = "a.create")
    private WebElement newMsgButton;

    @FindBy(css = "input[name='allUsers']")
    private WebElement chBoxAllUsers;

    public void isOpened(String title) {
        Assert.assertEquals(title, driver.getTitle());
        Log.info("Page opened");
    }

    public CreateMsgPage openCreateMsgPage() {
        Log.info("Open CreateMessagePage");
        newMsgButton.click();
        return new CreateMsgPage(driver);
    }

    public void openAllMessages() {
        if (!chBoxAllUsers.isSelected())
            chBoxAllUsers.click();
    }

    public void logOut() {
        logoutButton.click();
    }
}
