package com.gmail.hellaiser2973.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage {

    //todo сделать все такие переменные статичнымми, обговаривали
    public final String title = "Welcome to Grails";

    @FindBy (linkText = "qulixteachingsite.UserController")
    private WebElement link;

    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public LoginPage openLoginPage() {
        link.click();
        return new LoginPage(driver);
    }
}
