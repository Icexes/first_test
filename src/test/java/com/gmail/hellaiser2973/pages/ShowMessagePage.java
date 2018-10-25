package com.gmail.hellaiser2973.pages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowMessagePage {

    String title = "Show Message";

    @FindBy (linkText = "Message List")
    private WebElement ListMsgButton;

    WebDriver driver;

    public ShowMessagePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void openMainPage()
    {
        ListMsgButton.click();
    }

    public void isOpened()
    {
        Assert.assertEquals(title, driver.getTitle());
    }
}


