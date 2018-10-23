package com.gmail.hellaiser2973.pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowMessagePage {
    public ShowMessagePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    //todo поля объявляются до конструктора, перенеси его выше
    WebDriver driver;

    @FindBy (linkText = "Message List")
    private WebElement ListMsgButton;

    public void Click() {
    ListMsgButton.click();
    }

    public void isShowMessagePage() {
        Assert.assertEquals("Show Message", driver.getTitle());
    }
}


