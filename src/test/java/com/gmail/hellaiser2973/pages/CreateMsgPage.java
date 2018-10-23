package com.gmail.hellaiser2973.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateMsgPage {
    public CreateMsgPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    WebDriver driver;
    @FindBy (name ="headline")
    private WebElement headline;
    @FindBy (name ="text")
    private WebElement text;
    @FindBy (id = "create")
    private WebElement CreateButton;


    public void inputHeadline(String head) {
        headline.sendKeys(head);
    }

    public void inputText (String txt) {
        text.sendKeys(txt);
    }

    public void Click() {
        CreateButton.click();
    }

}
