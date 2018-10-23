package com.gmail.hellaiser2973.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

public class CreateMsgPage {
    public CreateMsgPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    WebDriver driver;
    @FindBy (id ="headline")
    private WebElement headline;
    @FindBy (id ="text")
    private WebElement text;
    @FindBy (id = "create")
    private WebElement CreateButton;

    public static String head, txt;


    private static String getRandomString(int length)

    {
        String randomStr = UUID.randomUUID().toString();
        while(randomStr.length() < length) {
            randomStr += UUID.randomUUID().toString();
        }
        return randomStr.substring(0, length);
    }


    public void inputHeadline() {
        head = getRandomString(5);
        headline.sendKeys(head);
    }

    public void inputText () {
        txt = getRandomString(5);
        text.sendKeys(txt);
    }

     public void Click() {

        CreateButton.click();
    }

    public void isCreateMsgPage() {

        Assert.assertEquals("Create Message", driver.getTitle());
    }

}
