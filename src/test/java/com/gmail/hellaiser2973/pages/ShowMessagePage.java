package com.gmail.hellaiser2973.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowMessagePage extends BasePage {

    public static final String TITLE = "Show Message";

    @FindBy(css = "a.list")
    private WebElement listMsgButton;

    ShowMessagePage(WebDriver driver) {
       PageFactory.initElements(driver,this);
       this.driver = driver;
    }

    public MainPage openMainPage() {
        listMsgButton.click();
        return new MainPage(driver);
    }
}


