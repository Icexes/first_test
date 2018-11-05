package com.gmail.hellaiser2973.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowMessagePage extends BasePage {

    public final String title = "Show Message";

    @FindBy(css = "a.list")
    private WebElement listMsgButton;

    public ShowMessagePage(WebDriver driver) {
       PageFactory.initElements(driver,this);
       this.driver = driver;
    }

    public void openMainPage() {
        listMsgButton.click();
    }
}


