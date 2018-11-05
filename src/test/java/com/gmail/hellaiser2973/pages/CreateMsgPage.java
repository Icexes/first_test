package com.gmail.hellaiser2973.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

public class CreateMsgPage extends BasePage {

    public final String title = "Create Message";

    @FindBy (id ="headline")
    private WebElement headline;

    @FindBy (id ="text")
    private WebElement text;

    @FindBy (id = "create")
    private WebElement createButton;

    public CreateMsgPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public String getRandomString(int length) {
        String randomStr = UUID.randomUUID().toString();
        while(randomStr.length() < length) {
            randomStr += UUID.randomUUID().toString();
        }
        return randomStr.substring(0, length);
    }

    public ShowMessagePage createMessage(String head, String txt) {
        headline.clear();
        headline.sendKeys(head);
        text.clear();
        text.sendKeys(txt);
        createButton.click();
        return new ShowMessagePage(driver);
    }
}
