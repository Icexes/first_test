package com.gmail.hellaiser2973.pages;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.UUID;

public class CreateMsgPage {

    String title = "Create Message";

    WebDriver driver;

    @FindBy (id ="headline")
    private WebElement headline;

    @FindBy (id ="text")
    private WebElement text;

    @FindBy (id = "create")
    //todo имя с мал буквы
    private WebElement CreateButton;

    public CreateMsgPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public  String getRandomString(int length)
    {
        String randomStr = UUID.randomUUID().toString();
        while(randomStr.length() < length) {
            randomStr += UUID.randomUUID().toString();
        }
        return randomStr.substring(0, length);
    }

    public ShowMessagePage createMessage(String head, String txt)
            //todo вот эта скобка ниже не переносится, она должна быть в одной строке с названием класса
    {
        headline.sendKeys(head);
        text.sendKeys(txt);
        CreateButton.click();
        return new ShowMessagePage(driver);
    }

    public void isOpened()
            //todo вот эта скобка ниже не переносится, она должна быть в одной строке с названием класса
    {
        Assert.assertEquals(title, driver.getTitle());
    }
}
