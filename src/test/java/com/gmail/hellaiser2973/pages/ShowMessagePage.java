package com.gmail.hellaiser2973.pages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowMessagePage {
    //todo добавить модификатор
    String title = "Show Message";

    @FindBy(css = "a.list")
    private WebElement listMsgButton;

    WebDriver driver;

    public ShowMessagePage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void openMainPage()
    {
        listMsgButton.click();
    }

    public void isOpened()
    {
        Assert.assertEquals(title, driver.getTitle());
    }
}


