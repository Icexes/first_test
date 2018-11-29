package com.gmail.hellaiser2973.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Log;

public class StartPage extends BasePage {

    public static final String TITLE = "Welcome to Grails";

    @FindBy (linkText = "qulixteachingsite.UserController")
    private WebElement link;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public LoginPage openLoginPage() {
        link.click();
        Log.info("Open LoginPage");
        return new LoginPage(driver);
    }
}
