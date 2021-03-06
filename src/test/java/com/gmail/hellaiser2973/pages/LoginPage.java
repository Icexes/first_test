package com.gmail.hellaiser2973.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Log;
public class LoginPage extends BasePage {


    public static final String TITLE = "Login";

    @FindBy(id ="login")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "save")
    private WebElement loginButton;

    LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public MainPage logIn(String login, String password) {
        Log.info("Enter login");
        loginField.sendKeys(login);
        Log.info("Enter password");
        passwordField.sendKeys(password);
        Log.info("Open MainPage");
        loginButton.click();
        return new MainPage(driver);
    }


}
